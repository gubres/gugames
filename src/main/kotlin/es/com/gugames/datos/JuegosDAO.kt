package es.com.gugames.datos

import es.com.gugames.modelo.Juego
import javax.persistence.EntityManager

class JuegosDAO(val manager: EntityManager) {
    companion object {
        fun getJuegos(manager: EntityManager): List<Juego> {
                val query = manager.createQuery("FROM JuegoEntity", JuegoEntity::class.java)
                return query.resultList.map { entity -> Juego(
                    entity.titulo,
                    entity.portada,
                    entity.precio,
                    entity.descripcion,
                    entity.id) }
        }
    }

    fun adicionarJuego(juego: Juego){
       val entity = JuegoEntity(
           juego.titulo,
           juego.portada,
           juego.precio,
           juego.descripcion)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()


    }
}