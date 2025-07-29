package es.com.gugames.principal

import com.google.gson.GsonBuilder
import es.com.gugames.modelo.Periodo
import es.com.gugames.modelo.PlanAsignatura
import es.com.gugames.servicios.ConsumoApi
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listadoGamers = consumo.buscaGamer()
    val listadoJuegoJson = consumo.buscaJuegosJson()

    val gamerCaroline = listadoGamers.get(3)
    val juegoResidentVillage = listadoJuegoJson.get(10)
    val juegoLastOfUs = listadoJuegoJson.get(2)
    val juegoSpiderman = listadoJuegoJson.get(13)

   // println(gamerCaroline)
    // println(juegoResidentVillage)



    val jogoDandara = listadoJuegoJson.get(5)
    val jogoAssassins = listadoJuegoJson.get(4)
    val jogoCyber = listadoJuegoJson.get(6)
    val jogoGod = listadoJuegoJson.get(7)
    val jogoSkyrim = listadoJuegoJson.get(18)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.alquilaJuego(juegoResidentVillage, periodo1)
    gamerCaroline.alquilaJuego(juegoLastOfUs, periodo2)
    gamerCaroline.alquilaJuego(juegoSpiderman, periodo3)
   // println(gamerCaroline.juegosAlquilados)


    val gamerCamila = listadoGamers.get(5)
    gamerCamila.plano = PlanAsignatura("PLATA", 9.90, 3, 0.15)
    gamerCamila.alquilaJuego(juegoSpiderman, periodo2)
    gamerCamila.alquilaJuego(juegoResidentVillage, periodo1)
    gamerCamila.alquilaJuego(juegoLastOfUs, periodo3)
    gamerCamila.alquilaJuego(juegoSpiderman, periodo2)
   // println(gamerCamila.juegosAlquilados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
   // println(gamerCamila)
    gamerCamila.alquilaJuego(juegoResidentVillage, periodo1)
   // println(gamerCamila.juegosAlquilados)

    gamerCamila.recomendarJuego(juegoResidentVillage, 7)
    gamerCamila.recomendarJuego(juegoLastOfUs, 10)
    gamerCaroline.recomendarJuego(juegoLastOfUs, 7)
    gamerCaroline.recomendarJuego(juegoResidentVillage, 8)

    gamerCamila.recomendarJuego(jogoAssassins, 8)
    gamerCamila.recomendarJuego(jogoCyber, 7)
    gamerCamila.recomendarJuego(jogoGod, 10)
    gamerCamila.recomendarJuego(jogoDandara, 8)
    gamerCamila.recomendarJuego(jogoSkyrim, 8)

//    println("Recomendaciones de Camila")
//    println(gamerCamila.juegosRecomendados)
//
//    println("Recomendaciones de Caroline")
//    println(gamerCaroline.juegosRecomendados)


    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacion = gson.toJson(gamerCamila.juegosRecomendados)
    println(serializacion)

    val archivo = File("juegosRecomendados.json")
    archivo.writeText(serializacion)
    println(archivo.absolutePath)
}