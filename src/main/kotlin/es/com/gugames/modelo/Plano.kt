package es.com.gugames.modelo

sealed class Plano (val tipo: String) {

    open fun obtenerValor(alquiler: Alquiler): Double {
        return alquiler.juego.precio * alquiler.periodo.enDias
    }
}