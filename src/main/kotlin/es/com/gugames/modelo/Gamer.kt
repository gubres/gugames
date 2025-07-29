package es.com.gugames.modelo

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nombre: String, var email: String): Recomendado {
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

    var plano: Plano = PlanoSuelto("BRONCE")

    val juegosBuscados = mutableListOf<Juego?>()

    val juegosAlquilados = mutableListOf<Alquiler>()

    private val listadoNotas = mutableListOf<Int>()

    val juegosRecomendados = mutableListOf<Juego>()

    override val media: Double
        get() = listadoNotas.average()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            println("Nota invalida. Inserte una nota entre 1 y 10")
        } else {
            listadoNotas.add(nota)
        }
    }

    fun recomendarJuego(juego: Juego, nota: Int) {
        juego.recomendar(nota)
        juegosRecomendados.add(juego)
    }
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
        return "Gamer: \n" +
                "Nombre: $nombre \n"+
                "Email: $email \n" +
                "Fecha Nacimiento: $fechaNacimiento \n" +
                "Usuario: $usuario \n" +
                "Id Interno: $idInterno \n" +
                "Reputación: $media."
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
        val alquiler = Alquiler(this, juego, periodo)
        juegosAlquilados.add(alquiler)

        return alquiler

    }

    fun juegosDelMes(mes:Int): List<Juego> {
        return juegosAlquilados
            .filter { alquiler ->  alquiler.periodo.dataInicial.monthValue == mes}
            .map { alquiler ->  alquiler.juego}
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

