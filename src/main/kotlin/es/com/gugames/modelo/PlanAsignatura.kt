package es.com.gugames.modelo

import java.math.BigDecimal
import java.math.RoundingMode

class PlanAsignatura (
    tipo:String,
    val mensualidad: Double,
    val juegosIncluidos: Int,
    val porcentajeDescuentoReputacion: Double,
    id: Int = 0): Plan(tipo, id) {

    override fun obtenerValor(alquiler: Alquiler): Double {
        val totalJuegosMes = alquiler.gamer.juegosDelMes(
            alquiler.periodo.dataInicial.monthValue).size+1

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

    override fun toString(): String {
        return "Plan Asignatura \n" +
                "Tipo: $tipo \n" +
                "Id: $id \n" +
                "Mensualidad: $mensualidad \n" +
                "Juegos incluidos: $juegosIncluidos \n" +
                "Porcentaje descuento reputación: $porcentajeDescuentoReputacion \n"
    }
}