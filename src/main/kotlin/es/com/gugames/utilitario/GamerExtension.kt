package es.com.gugames.utilitario

import es.com.gugames.modelo.Gamer
import es.com.gugames.modelo.InfoGamerJson

fun InfoGamerJson.creaGamer (): Gamer {
 return Gamer(this.nombre, this.email, this.fechaNacimiento, this.usuario)
}