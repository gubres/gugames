package es.com.gugames.modelo

data class Juego (val titulo: String, val portada: String) {
    var descripcion: String? = null

    override fun toString(): String {
        return "\n Juego:\n" +
                "Título = $titulo \n" +
                "Portada = $portada \n" +
                "Descripcion = $descripcion"

    }


}