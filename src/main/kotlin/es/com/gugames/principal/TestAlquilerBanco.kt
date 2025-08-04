package es.com.gugames.principal

import es.com.gugames.datos.AlquilerDAO
import es.com.gugames.datos.Banco
import es.com.gugames.datos.GamersDAO
import es.com.gugames.datos.JuegosDAO
import es.com.gugames.modelo.Periodo

fun main() {
    val manager = Banco.getEntityManager()
    val juegoDAO = JuegosDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val alquilerDAO = AlquilerDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(9)
    val juego = juegoDAO.recuperarPeloId(6)
    val alquiler = gamer.alquilaJuego(juego, Periodo())

    alquilerDAO.agregar(alquiler)

    val listaAlquiler = alquilerDAO.getListado()
    println(listaAlquiler)

    manager.close()
}