package es.com.gugames.utilitario

import es.com.gugames.datos.PlanAsignaturaEntity
import es.com.gugames.datos.PlanEntity
import es.com.gugames.datos.PlanSueltoEntity
import es.com.gugames.modelo.Plan
import es.com.gugames.modelo.PlanAsignatura
import es.com.gugames.modelo.PlanSuelto

fun Plan.toEntity(): PlanEntity{
    return if (this is PlanAsignatura) {
        PlanAsignaturaEntity(
            this.tipo,
            this.mensualidad,
            this.juegosIncluidos,
            this.porcentajeDescuentoReputacion,
            this.id
        )
    } else {
        PlanSueltoEntity(this.tipo, this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is PlanAsignaturaEntity) {
        PlanAsignatura(
            this.tipo,
            this.mensualidad,
            this.juegosIncluidos,
            this.porcentajeDescuentoReputacion,
            this.id)
    } else {
        PlanSuelto(this.tipo, this.id)
    }
}