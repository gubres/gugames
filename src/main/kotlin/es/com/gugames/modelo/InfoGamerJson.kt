package es.com.gugames.modelo

import com.google.gson.annotations.SerializedName

data class InfoGamerJson(
    @SerializedName("nome") val nombre: String,
    @SerializedName("email") val email: String,
    @SerializedName("dataNascimento") val fechaNacimiento: String,
    @SerializedName("usuario") val usuario: String)
    {



}
