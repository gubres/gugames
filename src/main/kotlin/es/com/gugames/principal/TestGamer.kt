import es.com.gugames.datos.Banco
import es.com.gugames.datos.GamersDAO
import es.com.gugames.datos.PlanesDAO
import es.com.gugames.modelo.Gamer


fun main() {
    val gamer = Gamer(
        "Monica",
        "monica@mail.com",
        "28/09/1990",
        "moni")
    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planosDAO = PlanesDAO(manager)
    gamer.plan = planosDAO.recuperarPeloId(3)

    gamerDAO.agregar(gamer)


    val listadoGamersBanco = gamerDAO.getListado()
    println(listadoGamersBanco)

    manager.close()
}