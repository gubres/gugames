package es.com.gugames.modelo

import java.time.Period

data class Alquiler(
    val gamer: Gamer,
    val juego: Juego,
    val periodo: Periodo) {

    val valorAlquiler = gamer.plano.obtenerValor(this)

    override fun toString(): String {
        return "Alquiler del ${juego.titulo} por ${gamer.nombre} por el precio de $valorAlquiler€!"
    }
}
