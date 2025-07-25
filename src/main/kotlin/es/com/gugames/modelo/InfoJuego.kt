package es.com.gugames.modelo

data class InfoJuego (val info:InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}