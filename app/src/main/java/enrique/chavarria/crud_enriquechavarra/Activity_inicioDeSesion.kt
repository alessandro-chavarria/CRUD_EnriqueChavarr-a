package enrique.chavarria.crud_enriquechavarra

import android.content.Intent
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import java.sql.Connection

class Activity_inicioDeSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_de_sesion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtUsuario = findViewById<TextView>(R.id.txtnombreUsuario)
        val txtContrasena = findViewById<TextView>(R.id.txtcontrasenaUsuario)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRegistrarme = findViewById<TextView>(R.id.btnRegistrarme)

        btnRegistrarme.setOnClickListener {
            val intent = Intent(this@Activity_inicioDeSesion, Activity_Registro::class.java)
            startActivity(intent)
        }

        fun Limpiar(){
            txtUsuario.setText("")
            txtContrasena.setText("")
        }

        btnIngresar.setOnClickListener{
            GlobalScope.launch (Dispatchers.IO ) {
                try
                {
                    if(txtUsuario.text.isEmpty() || txtContrasena.text.isEmpty())
                    {
                        GlobalScope.launch (Dispatchers.IO) {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(this@Activity_inicioDeSesion, "Complete los campos", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    else
                    {
                        val objCon = ClaseConexion().Conexion()

                        val login = objCon?.prepareStatement("SELECT * FROM TB_Usuario WHERE nombreUsuario = ? AND contrasenaUsuario = ?")!!
                        login.setString(1, txtUsuario.text.toString())
                        login.setString(2, txtContrasena.text.toString())
                        val result = login.executeQuery()

                        if(result.next())
                        {
                            val intent = Intent(this@Activity_inicioDeSesion, MainActivity::class.java)
                            startActivity(intent)
                            Limpiar()

                        }
                        else
                        {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(this@Activity_inicioDeSesion, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }


                }
                catch(e: Exception) {
                    println("Error: $e")
                }
            }
        }
    }
}