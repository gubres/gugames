package es.com.gugames.datos

import es.com.gugames.modelo.Juego
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {

//    fun obtenerConexion(): Connection? {
//        return try {
//            DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/gugames",
//                "root",
//                "gisbadm28ABC!")
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("gugames")
        return factory.createEntityManager()
    }
}