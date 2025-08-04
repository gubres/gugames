package es.com.gugames.principal

import es.com.gugames.datos.Banco
import es.com.gugames.datos.PlanesDAO
import es.com.gugames.modelo.PlanAsignatura
import es.com.gugames.modelo.PlanSuelto

fun main() {

    val suelto = PlanSuelto("BRONCE")
    val plata = PlanAsignatura("PLATA", 9.90, 3, 0.15)
    val oro = PlanAsignatura("ORO", 19.90, 5, 0.20)
    val platina = PlanAsignatura("PLATINA", 29.90, 10, 0.30)
    val diamante = PlanAsignatura("DIAMANTE", 49.90, 20, 0.50)

    val manager = Banco.getEntityManager()
    val planesDAO = PlanesDAO(manager)

    planesDAO.agregar(suelto)
    planesDAO.agregar(plata)
    planesDAO.agregar(oro)
    planesDAO.agregar(platina)
    planesDAO.agregar(diamante)

    val listadoPlanes = planesDAO.getListado()
    println(listadoPlanes)
    manager.close()
}