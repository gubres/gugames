package es.com.gugames.datos

import es.com.gugames.modelo.Juego
import es.com.gugames.utilitario.toEntity
import es.com.gugames.utilitario.toModel
import javax.persistence.EntityManager

class JuegosDAO(manager: EntityManager): DAO<Juego, JuegoEntity>(JuegoEntity::class.java, manager ) {

    override fun toEntity(objeto: Juego): JuegoEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: JuegoEntity): Juego {
        return entity.toModel()
    }

}