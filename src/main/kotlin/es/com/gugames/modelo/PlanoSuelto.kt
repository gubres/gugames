package es.com.gugames.modelo

class PlanoSuelto(
    tipo: String): Plano (tipo) {

    override fun obtenerValor(alquiler: Alquiler): Double {
        var valorOriginal = super.obtenerValor(alquiler)
        if (alquiler.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1
        }
        return valorOriginal
    }
}
