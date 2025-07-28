package es.com.gugames.modelo

data class Juego (
    val titulo: String,
    val portada: String) {
    var descripcion: String? = null
    var precio = 0.0

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
                "Precio: $precio"

    }


}