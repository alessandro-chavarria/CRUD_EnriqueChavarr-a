package enrique.chavarria.crud_enriquechavarra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import modelo.ClaseConexion
import java.util.UUID

class Activity_Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtUsuarioRegistro = findViewById<TextView>(R.id.txtUsuarioRegistro)
        val txtContrasenaRegistro = findViewById<TextView>(R.id.txtContrasenaRegistro)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)
        val btnYaTengoCuenta = findViewById<TextView>(R.id.btnYaTengoCuenta)

        btnYaTengoCuenta.setOnClickListener {
            val intent = Intent(this@Activity_Registro, Activity_inicioDeSesion::class.java)
            startActivity(intent)
        }

        btnRegistrarse.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {

                //Crear objeto de la clase conexion
                val objConexion = ClaseConexion().Conexion()

                //Crear una variable que contenga un PrepareStatement
                val agregarUsuario = objConexion?.prepareStatement("insert into TB_Usuario(UUID, nombreUsuario, contrasenaUsuario) values (?, ?, ?)")!!
                agregarUsuario.setString(1, UUID.randomUUID().toString())
                agregarUsuario.setString(2, txtUsuarioRegistro.text.toString())
                agregarUsuario.setString(3, txtContrasenaRegistro.text.toString())
                agregarUsuario.executeUpdate()
                startActivity(Intent(this@Activity_Registro, Activity_inicioDeSesion::class.java))
            }
        }
    }
}