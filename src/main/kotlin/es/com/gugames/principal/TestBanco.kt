package es.com.gugames.principal

import es.com.gugames.datos.JuegosDAO
import es.com.gugames.modelo.Juego

fun main() {

    val juego = Juego(
        "Elden Ring",
        "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1245620/header.jpg?t=1748630546",
        50.0,
        "Elden Ring trata sobre un mundo llamado las Tierras Intermedias, donde el Anillo de Elden, que representa el orden, ha sido destruido.")

    val juegoDAO = JuegosDAO()
    juegoDAO.adicionarJuego(juego)

    val listaJuegos: List<Juego> = JuegosDAO.getJuegos()
    println(listaJuegos)


}