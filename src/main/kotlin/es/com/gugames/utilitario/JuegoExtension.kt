package es.com.gugames.utilitario

import es.com.gugames.datos.JuegoEntity
import es.com.gugames.modelo.InfoJuegoJson
import es.com.gugames.modelo.Juego

fun InfoJuegoJson.crearJuego(): Juego {
    return Juego(
        this.titulo,
        this.portada,
        this.precio,
        this.descripcion)
}

fun Juego.toEntity(): JuegoEntity {
    return JuegoEntity(
        this.titulo,
        this.portada,
        this.precio,
        this.descripcion,
        this.id
    )
}

fun JuegoEntity.toModel(): Juego {
    return Juego(
        this.titulo,
        this.portada,
        this.precio,
        this.descripcion,
        this.id
    )
}