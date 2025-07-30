package es.com.gugames.datos

import es.com.gugames.modelo.Juego

class JuegosDAO {

   fun adicionarJuego(juego: Juego) {
        val conexion = Banco.obtenerConexion()
        val insert = "INSERT INTO JUEGOS (TITULO, PORTADA, PRECIO, DESCRIPCION) VALUES (?, ?, ?, ?)"

        if (conexion != null) {
            try {
                val statement = conexion.prepareStatement(insert)
                statement.setString(1,juego.titulo)
                statement.setString(2, juego.portada)
                statement.setDouble(3,juego.precio)
                statement.setString(4, juego.descripcion)

                statement.executeUpdate()
                statement.close()

            } finally {
                conexion.close()
            }
        }

    }

    companion object {
        fun getJuegos(): List<Juego> {
            val listadoJuegos = mutableListOf<Juego>()
            val conexion = Banco.obtenerConexion()

            if (conexion != null) {
                try{
                    val statement = conexion.createStatement()
                    val resultado = statement.executeQuery("SELECT * FROM JUEGOS")

                    while (resultado.next()) {
                        val titulo = resultado.getString("titulo")
                        val portada = resultado.getString("portada")
                        val precio = resultado.getDouble("precio")
                        val descripcion = resultado.getString("descripcion")
                        val id = resultado.getInt("id")

                        val juego = Juego(titulo, portada, precio, descripcion, id)
                        listadoJuegos.add(juego)
                    }

                    statement.close()
                } finally {
                    conexion.close()
                }
            }
            return listadoJuegos
        }
    }
}