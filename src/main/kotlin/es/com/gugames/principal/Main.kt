package es.com.gugames.principal

import es.com.gugames.modelo.Gamer
import es.com.gugames.modelo.Juego
import es.com.gugames.servicios.ConsumoApi
import java.util.*

fun main() {
    val lectura = Scanner(System.`in`)

    val gamer = Gamer.crearGamer(lectura)
    println("Cadastro concluido con exito. Datos del gamer:")
    println(gamer)

    do {
        println("Inserte el codigo del juego para búsqueda: ")
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

            gamer.juegosBuscados.add(miJuego)
        }
        println("Desea hacer una nueva búsqueda? S/N")
        val respuesta = lectura.nextLine()

    } while (respuesta.equals("s", true))

    println("Juegos buscados: ")
    println(gamer.juegosBuscados)

    println("\n Juegos ordenados por titulo: ")
    gamer.juegosBuscados.sortBy {
        it?.titulo
    }

    gamer.juegosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val juegosFiltrados = gamer.juegosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\n Juegos filtrados: ")
    println(juegosFiltrados)

    println("Desea borrar algún juego de la lista original? S/N")
    val opcion = lectura.nextLine()
    if (opcion.equals("s", true)){
        println(gamer.juegosBuscados)

        println("Informe la posicion del juego que deseas borrar: ")
        var posicion = lectura.nextInt()
        gamer.juegosBuscados.removeAt(posicion)
    }
    println("\n Listado actualizado de los juegos buscados:")
    println(gamer.juegosBuscados)

    println("Búsqueda finalizada con exito")
}