package es.com.gugames.modelo

class PlanAsignatura (
    tipo:String,
    val mensualidad: Double,
    val juegosIncluidos: Int,
    val porcentajeDescuentoReputacion: Double): Plano(tipo) {

    override fun obtenerValor(alquiler: Alquiler): Double {
        val totalJuegosMes = alquiler.gamer.juegosDelMes(alquiler.periodo.dataInicial.monthValue).size+1

        return if(totalJuegosMes <= juegosIncluidos) {
            0.0
        } else {
            var valorOriginal = super.obtenerValor(alquiler)

            if (alquiler.gamer.media > 8) {
                valorOriginal -= valorOriginal * porcentajeDescuentoReputacion
            }
            valorOriginal
        }
    }

}