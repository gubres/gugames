package es.com.gugames.datos

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Juegos")
class JuegoEntity(
    val titulo: String = "Titulo del juego",
    val portada: String = "Portada del juego",
    val precio: Double = 0.0,
    val descripcion: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0) {


}