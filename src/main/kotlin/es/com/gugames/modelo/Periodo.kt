package es.com.gugames.modelo

import java.time.LocalDate
import java.time.Period

data class Periodo (
    val dataInicial: LocalDate,
    val dataFinal: LocalDate)  {

    val enDias = Period.between(dataInicial, dataFinal).days
}