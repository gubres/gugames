package es.com.gugames.utilitario

import es.com.gugames.datos.GamerEntity
import es.com.gugames.modelo.Gamer
import es.com.gugames.modelo.InfoGamerJson

fun InfoGamerJson.creaGamer (): Gamer {
 return Gamer(
  this.nombre,
  this.email,
  this.fechaNacimiento,
  this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
 return GamerEntity(
  this.id, this.nombre,
  this.email,
  this.fechaNacimiento,
  this.usuario,
  this.plan.toEntity()
 )
}

fun GamerEntity.toModel(): Gamer {
 return Gamer(
  this.nombre,
  this.email,
  this.fechaNacimiento,
  this.usuario,
  this.id)

}