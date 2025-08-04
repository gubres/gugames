package es.com.gugames.datos

import es.com.gugames.modelo.Alquiler
import es.com.gugames.utilitario.toEntity
import es.com.gugames.utilitario.toModel
import javax.persistence.EntityManager

class AlquilerDAO(manager: EntityManager): DAO<Alquiler, AlquilerEntity>(AlquilerEntity::class.java, manager) {
    override fun toEntity(objeto: Alquiler): AlquilerEntity {

        return AlquilerEntity(
            objeto.gamer.toEntity(),
            objeto.juego.toEntity(),
            objeto.periodo)
            .apply { valorAlquiler = objeto.valorAlquiler
                        id = objeto.id}
    }

    override fun toModel(entity: AlquilerEntity): Alquiler {

        return Alquiler(
            entity.gamer.toModel(),
            entity.juego.toModel(),
            entity.periodo).apply { id = entity.id }
    }
}