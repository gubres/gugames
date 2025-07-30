package es.com.gugames.modelo

sealed class Plan (val tipo: String, var id: Int = 0) {

    open fun obtenerValor(alquiler: Alquiler): Double {
        return alquiler.juego.precio * alquiler.periodo.enDias
    }
}