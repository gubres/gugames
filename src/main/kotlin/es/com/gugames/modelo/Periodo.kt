package es.com.gugames.modelo

import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

@Embeddable
data class Periodo (
    val dataInicial: LocalDate = LocalDate.now(),
    val dataFinal: LocalDate = LocalDate.now().plusDays(7)
)  {

    val enDias = Period.between(dataInicial, dataFinal).days
}