package modelo

import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): Connection? {
        try {
            val url = "jdbc:oracle:thin:@192.168.1.6:1521:xe"
            val usurio = "system"
            val contrasena = "JHtt4Vtq"

            val connection = DriverManager.getConnection(url, usurio, contrasena)
            return connection
        }catch (e: Exception){
            println("error. $e")
            return null
        }

    }
}