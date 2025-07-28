package es.com.gugames.modelo

import com.google.gson.annotations.SerializedName

data class InfoJuegoJson(
    @SerializedName("titulo") val titulo: String,
    @SerializedName("capa") val portada: String,
    @SerializedName("preco") val precio: Double,
    @SerializedName("descricao") val descripcion: String
)
