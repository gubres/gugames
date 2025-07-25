package es.com.gugames.modelo

data class Juego (val titulo: String, val portada: String) {
    var descripcion: String? = null

    override fun toString(): String {
        return "Mi es.com.gugames.modelo.Juego:\n" +
                "Título = $titulo \n" +
                "Portada = $portada \n" +
                "Descripcion = $descripcion \n"

    }


}