package es.com.gugames.modelo

import kotlin.random.Random

data class Gamer(var nombre: String, var email: String) {
    var fechaNacimiento: String? = null
    var usuario: String? = null
    var idInterno: String? = null

    constructor(nombre: String, email: String, fechaNacimiento: String, usuario: String):
        this(nombre, email){
            this.fechaNacimiento = fechaNacimiento
            this.usuario = usuario
    }

    override fun toString(): String {
        return "Gamer(nombre='$nombre', email='$email', fechaNacimiento=$fechaNacimiento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun crearIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
    }
}
