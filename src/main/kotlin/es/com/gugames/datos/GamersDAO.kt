package es.com.gugames.datos

import es.com.gugames.modelo.Gamer
import es.com.gugames.modelo.GamerEntity
import javax.persistence.EntityManager

class GamersDAO(private val manager: EntityManager) {

    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map {
            entity -> Gamer(
            entity.nombre,
            entity.email,
            entity.fechaNacimiento,
            entity.usuario,
            entity.id) }
    }

    fun agregarGamer(gamer: Gamer) {
        val entity = GamerEntity(
            gamer.id,
            gamer.nombre,
            gamer.email,
            gamer.fechaNacimiento,
            gamer.usuario)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}
