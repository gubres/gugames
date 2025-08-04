package es.com.gugames.datos

import es.com.gugames.modelo.Plan
import es.com.gugames.utilitario.toEntity
import es.com.gugames.utilitario.toModel
import javax.persistence.EntityManager

class PlanesDAO(manager: EntityManager): DAO<Plan, PlanEntity>(PlanEntity::class.java, manager ) {

    override fun toEntity(plan: Plan): PlanEntity {
        return plan.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }

}