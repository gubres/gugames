package es.com.gugames.principal

import es.com.gugames.modelo.Periodo
import es.com.gugames.servicios.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listadoGamers = consumo.buscaGamer()
    val listadoJuegoJson = consumo.buscaJuegosJson()

    val gamerCaroline = listadoGamers.get(3)
    val juegoResidentVillage = listadoJuegoJson.get(10)

    println(gamerCaroline)
    println(juegoResidentVillage)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val alquiler = gamerCaroline.alquilaJuego(juegoResidentVillage, periodo)
    println(alquiler)
}