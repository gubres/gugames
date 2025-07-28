package es.com.gugames.utilitario

import es.com.gugames.modelo.InfoJuegoJson
import es.com.gugames.modelo.Juego

fun InfoJuegoJson.crearJuego(): Juego {
    return Juego(
        this.titulo,
        this.portada,
        this.precio,
        this.descripcion)
}