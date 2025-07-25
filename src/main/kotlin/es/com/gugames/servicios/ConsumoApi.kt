package es.com.gugames.servicios

import com.google.gson.Gson
import es.com.gugames.modelo.InfoJuego
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {
    fun buscaJuego(id: String):InfoJuego {
        val direccion = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(direccion))
            .build()

        val response = client.send(request, BodyHandlers.ofString())
        val json = response.body()

        val gson = Gson()
        val miInfoJuego = gson.fromJson(json, InfoJuego::class.java)

        return miInfoJuego
    }
}