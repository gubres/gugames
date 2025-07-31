package es.com.gugames.principal

import es.com.gugames.datos.Banco
import es.com.gugames.datos.JuegosDAO
import es.com.gugames.modelo.Juego

fun main() {

    val juego2 = Juego("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Banco.getEntityManager()

    val juegoDAO = JuegosDAO(manager)

    juegoDAO.adicionarJuego(juego2)
    val listaJuegos: List<Juego> = JuegosDAO.getJuegos(manager)
    println(listaJuegos)

    manager.close()


}