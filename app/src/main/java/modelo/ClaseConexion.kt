package modelo

import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection? {
        try {
            val url = "jdbc:oracle:thin:@10.10.0.54:1521:xe"
            val usurio = "system"
            val contrasena = "ITR2024"

            val connection = DriverManager.getConnection(url, usurio, contrasena)
            return connection
        }catch (e: Exception){
            println("error. $e")
            return null
        }

    }
}