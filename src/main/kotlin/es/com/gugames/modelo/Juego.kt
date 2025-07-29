package es.com.gugames.modelo

import com.google.gson.annotations.Expose

data class Juego (
    @Expose val titulo: String,
    @Expose val portada: String): Recomendado {
    var descripcion: String? = null
    var precio = 0.0

    private val listadoNotas = mutableListOf<Int>()
    override val media: Double
        get() = listadoNotas.average()

    override fun recomendar(nota: Int) {
        listadoNotas.add(nota)
    }

    constructor(
        titulo: String,
        portada: String,
        precio: Double,
        descripcion: String): this(titulo, portada){
        this.precio = precio
        this.descripcion = descripcion
    }

    override fun toString(): String {
        return "\nJuego:\n" +
                "Título = $titulo \n" +
                "Portada = $portada \n" +
                "Precio: $precio \n" +
                "Descripcion = $descripcion" +
                "Precio: $precio \n" +
                "Reputación: $media"

    }


}