package es.com.gugames.datos

import es.com.gugames.modelo.Juego
import javax.persistence.EntityManager

class JuegosDAO(manager: EntityManager): DAO<Juego, JuegoEntity>(JuegoEntity::class.java, manager ) {

    override fun toEntity(objeto: Juego): JuegoEntity {
        return JuegoEntity(
            objeto.titulo,
            objeto.portada,
            objeto.precio,
            objeto.descripcion,
            objeto.id)
    }

    override fun toModel(entity: JuegoEntity): Juego {
        return Juego(
            entity.titulo,
            entity.portada,
            entity.precio,
            entity.descripcion,
            entity.id)
    }

}