package es.com.gugames.modelo

data class Alquiler(
    val gamer: Gamer,
    val juego: Juego,
    val periodo: Periodo) {

    val valorAlquiler = gamer.plan.obtenerValor(this)
    var id = 0

    override fun toString(): String {
        return "Alquiler del ${juego.titulo} por ${gamer.nombre} por el precio de $valorAlquiler€!"
    }
}
