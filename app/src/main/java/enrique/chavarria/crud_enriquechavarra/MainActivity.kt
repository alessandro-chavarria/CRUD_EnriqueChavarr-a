package enrique.chavarria.crud_enriquechavarra

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Llamar a todos los elemtos de la vista
        val txtnumeroDeTicket = findViewById<TextView>(R.id.txtnumeroDeTicket)
        val txttituloDeTicket = findViewById<TextView>(R.id.txttituloDeTicket)
        val txtdescripcionDeTicket = findViewById<TextView>(R.id.txtdescripcionDeTicket)
        val txtautorDeTicket = findViewById<TextView>(R.id.txtautorDeTicket)
        val txtemailDeAutor = findViewById<TextView>(R.id.txtemailDeAutor)
        val txtfechaDeCreacionDeTicket = findViewById<TextView>(R.id.txtfechaDeCreacionDeTicket)
        val txtestadoDeTicket = findViewById<TextView>(R.id.txtestadoDeTicket)
        val txtfechaDeFinalizacionDeTicket = findViewById<TextView>(R.id.txtfechaDeFinalizacionDeTicket)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        //Programar el boton de guardar
        btnGuardar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                //Crear objeto de la clase conexion
                val objConexion = ClaseConexion().cadenaConexion()

                //Crear una variable que contenga un PrepareStatement
                val addTicket = objConexion?.prepareStatement("insert into TB_Ticket (UUID, numeroDeTicket, tituloDeTicket, descripcionDeTicket, autorDeTicket, emailDeAutor, fechaDeCreacionDeTicket, estadoDeTicket, fechaDeFinalizacionDeTicket) values(?, ?, ?, ?, ?, ?, ?, ?, ?)")!!
                addTicket.setString(1, UUID.randomUUID().toString())
                addTicket.setInt(2,txtnumeroDeTicket.text.toString().toInt())
                addTicket.setString(3, txttituloDeTicket.text.toString())
                addTicket.setString(4, txtdescripcionDeTicket.text.toString())
                addTicket.setString(5, txtautorDeTicket.text.toString())
                addTicket.setString(6, txtemailDeAutor.text.toString())
                addTicket.setString(7, txtfechaDeCreacionDeTicket.text.toString())
                addTicket.setString(8, txtestadoDeTicket.text.toString())
                addTicket.setString(9, txtfechaDeFinalizacionDeTicket.text.toString())
                addTicket.executeUpdate()
            }
        }
    }
}