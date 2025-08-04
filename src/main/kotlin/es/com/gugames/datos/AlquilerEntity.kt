package es.com.gugames.datos

import es.com.gugames.modelo.Periodo
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "alquiler")
class AlquilerEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val juego: JuegoEntity = JuegoEntity(),
    @Embedded
    val periodo: Periodo = Periodo()) {

    var valorAlquiler = 0.0
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}