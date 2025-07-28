package es.com.gugames.servicios

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import es.com.gugames.modelo.Gamer
import es.com.gugames.modelo.InfoGamerJson
import es.com.gugames.modelo.InfoJuego
import es.com.gugames.modelo.InfoJuegoJson
import es.com.gugames.modelo.Juego
import es.com.gugames.utilitario.creaGamer
import es.com.gugames.utilitario.crearJuego
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    private fun consomeDatos (direccion: String): String {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(direccion))
            .build()

        val response = client.send(request, BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJuego(id: String):InfoJuego {
        val direccion = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDatos(direccion)
        val gson = Gson()
        val miInfoJuego = gson.fromJson(json, InfoJuego::class.java)

        return miInfoJuego
    }

    fun buscaGamer(): List<Gamer> {
        val direccion = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDatos(direccion)
        val gson = Gson()
        val miGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listadoGamer : List<InfoGamerJson> = gson.fromJson(json, miGamerTipo)

        val listadoGamerMapeado = listadoGamer.map { infoGamerJson -> infoGamerJson.creaGamer() }

        return listadoGamerMapeado
    }

    fun buscaJuegosJson(): List<Juego> {
        val direccion = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDatos(direccion)

        val gson = Gson()
        val miJuegoTipo = object : TypeToken<List<InfoJuegoJson>>() {}.type
        val listadoJuego: List<InfoJuegoJson> = gson.fromJson(json, miJuegoTipo)

        val listadoJuegoMap = listadoJuego.map { infoJuegoJson -> infoJuegoJson.crearJuego() }

        return listadoJuegoMap
    }

}