package es.com.gugames.datos

import es.com.gugames.modelo.Gamer
import es.com.gugames.datos.GamerEntity
import es.com.gugames.modelo.Juego
import es.com.gugames.utilitario.toEntity
import es.com.gugames.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(GamerEntity::class.java, manager ) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plan = entity.plan.toModel() }
    }
}
