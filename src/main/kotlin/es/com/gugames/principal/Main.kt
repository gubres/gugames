package es.com.gugames.principal

import es.com.gugames.modelo.Juego
import es.com.gugames.servicios.ConsumoApi
import java.util.*

fun main() {
    val lectura = Scanner(System.`in`)
    println("Inserte el codigo del juego para busqueda: ")
    val busca = lectura.nextLine()

    val buscaApi = ConsumoApi()
    val informacionJuego = buscaApi.buscaJuego(busca)

    var miJuego: Juego? = null

    val resultado = runCatching {
            miJuego = Juego(
                informacionJuego.info.title,
                informacionJuego.info.thumb
            )
    }
    resultado.onFailure {
        println("❌ es.com.gugames.modelo.Juego no encontrado. Intente con otro ID.")
    }
    resultado.onSuccess {
        println("Te gustaría insertar una descripción personalizada? S/N")
        val opcion = lectura.nextLine()
        if (opcion.equals("s", true)) {
            println("Inserte la descripción personalizada para el juego: ")
            val descripcionPersonalizada = lectura.nextLine()
            miJuego?.descripcion = descripcionPersonalizada
        } else {
            miJuego?.descripcion = miJuego?.titulo
        }

        println(miJuego)
    }
    resultado.onSuccess {
        println("Búsqueda finalizada con exito")
    }
}