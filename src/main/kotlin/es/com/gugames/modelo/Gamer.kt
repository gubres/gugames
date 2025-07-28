package es.com.gugames.modelo

import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nombre: String, var email: String) {
    var fechaNacimiento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()){
                crearIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    val juegosBuscados = mutableListOf<Juego?>()

    constructor(nombre: String, email: String, fechaNacimiento: String, usuario: String):
        this(nombre, email){
            this.fechaNacimiento = fechaNacimiento
            this.usuario = usuario
            crearIdInterno()
    }

    init {
        if(nombre.isNullOrBlank()) {
            throw IllegalArgumentException("Nombre no puede estar en blanco")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nombre='$nombre', email='$email', fechaNacimiento=$fechaNacimiento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun crearIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)) {
            return email
        } else{
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun alquilaJuego(juego: Juego, periodo: Periodo): Alquiler {
        return Alquiler(this, juego, periodo)
    }

    companion object {
        fun crearGamer(lectura: Scanner): Gamer {
            println("¡Bienvenido al GuGames! Hagamos su cadastro. Escribe su nombre:")
            val nombre = lectura.nextLine()
            println("Escribe su e-mail:")
            val email = lectura.nextLine()
            println("Desea completar su cadastro con usuario y fecha de nacimiento? (S/N)")
            val opcion = lectura.nextLine()

            if(opcion.equals("s", true)) {
                println("Escribe su fecha de nacimiento(DD/MM/AAAA): ")
                val nacimiento = lectura.nextLine()
                println("Escribe su nombre de usuario: ")
                val usuario = lectura.nextLine()

                return Gamer(nombre, email, nacimiento, usuario)
            } else {
                return Gamer (nombre, email)
                }
            }
        }
    }

