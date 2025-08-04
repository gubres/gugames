package es.com.gugames.datos

import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity> (
    protected val entityType: Class<TEntity>,
    protected val manager: EntityManager) {

    abstract fun toEntity(objeto:TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel


     open fun getListado(): List<TModel> {
        val query = manager.createQuery(
            "FROM ${entityType.simpleName}",
            entityType )
        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun agregar(objeto: TModel) {
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun recuperarPeloId (id: Int): TModel {
        val query = manager.createQuery(
            "FROM ${entityType.simpleName} WHERE id=:id",
            entityType )
        query.setParameter("id", id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun borrar(id: Int) {
        val query = manager.createQuery(
            "FROM ${entityType.simpleName} WHERE id=:id",
            entityType )
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()

    }
}