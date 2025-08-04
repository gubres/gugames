package es.com.gugames.datos

import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

@Entity
@Table(name = "planes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlan", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val tipo: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0)

@Entity
@DiscriminatorValue("Suelto")
class PlanSueltoEntity(
    tipo: String = "Plan Suelto",
    id: Int = 0): PlanEntity(tipo, id)

@Entity
@DiscriminatorValue("Asignatura")
class PlanAsignaturaEntity(
    tipo: String = "Plan Asignatura",
    val mensualidad: Double = 0.0,
    val juegosIncluidos: Int = 0,
    val porcentajeDescuentoReputacion: Double = 0.0,
    id: Int = 0
    ): PlanEntity(tipo, id)