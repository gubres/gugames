package es.com.gugames.datos

import es.com.gugames.modelo.Juego
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {

    fun obtenerConexion(): Connection? {
        return try {
            DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gugames",
                "root",
                "gisbadm28ABC!")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

}