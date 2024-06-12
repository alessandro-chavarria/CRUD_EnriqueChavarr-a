package enrique.chavarria.crud_enriquechavarra

import RecyclerViewHelper.Adaptador
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import modelo.Tickets
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

        val txttituloDeTicket = findViewById<TextView>(R.id.txttituloDeTicket)
        val txtdescripcionDeTicket = findViewById<TextView>(R.id.txtdescripcionDeTicket)
        val txtautorDeTicket = findViewById<TextView>(R.id.txtautorDeTicket)
        val txtemailDeAutor = findViewById<TextView>(R.id.txtemailDeAutor)
        val txtfechaDeCreacionDeTicket = findViewById<TextView>(R.id.txtfechaDeCreacionDeTicket)
        val txtestadoDeTicket = findViewById<TextView>(R.id.txtestadoDeTicket)
        val txtfechaDeFinalizacionDeTicket = findViewById<TextView>(R.id.txtfechaDeFinalizacionDeTicket)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val rcvTickets = findViewById<RecyclerView>(R.id.rcvTicket)

        rcvTickets.layoutManager = LinearLayoutManager(this)

        fun obtenerTickets(): List<Tickets> {
            val objCon = ClaseConexion().Conexion()
            val statement = objCon?.createStatement()
            val resulSet = statement?.executeQuery("SELECT * FROM TB_Ticket")!!

            val listTickets = mutableListOf<Tickets>()

            while (resulSet.next()) {
                val uuid = resulSet.getString("UUID")
                val titulo = resulSet.getString("tituloDeTicket")
                val descripcion = resulSet.getString("descripcionDeTicket")
                val autor = resulSet.getString("autorDeTicket")
                val email = resulSet.getString("emailDeAutor")
                val creacion = resulSet.getString("fechaDeCreacionDeTicket")
                val estado = resulSet.getString("estadoDeTicket")
                val finalizacion = resulSet.getString("fechaDeFinalizacionDeTicket")

                val values = Tickets(uuid, titulo, descripcion, autor, email, creacion, estado, finalizacion)
                listTickets.add(values)
            }

            return listTickets
        }

        CoroutineScope(Dispatchers.IO).launch {
            val tickets = obtenerTickets()
            withContext(Dispatchers.Main)
            {
                val adp = Adaptador(tickets)
                rcvTickets.adapter = adp
            }
        }

        //Programar el boton de guardar
        btnGuardar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                //Crear objeto de la clase conexion
                val objConexion = ClaseConexion().Conexion()

                //Crear una variable que contenga un PrepareStatement
                val addTicket = objConexion?.prepareStatement("insert into TB_Ticket (UUID, tituloDeTicket, descripcionDeTicket, autorDeTicket, emailDeAutor, fechaDeCreacionDeTicket, estadoDeTicket, fechaDeFinalizacionDeTicket) values(?, ?, ?, ?, ?, ?, ?, ?)")!!
                addTicket.setString(1, UUID.randomUUID().toString())
                addTicket.setString(2, txttituloDeTicket.text.toString())
                addTicket.setString(3, txtdescripcionDeTicket.text.toString())
                addTicket.setString(4, txtautorDeTicket.text.toString())
                addTicket.setString(5, txtemailDeAutor.text.toString())
                addTicket.setString(6, txtfechaDeCreacionDeTicket.text.toString())
                addTicket.setString(7, txtestadoDeTicket.text.toString())
                addTicket.setString(8, txtfechaDeFinalizacionDeTicket.text.toString())
                addTicket.executeUpdate()

                val nuevosTicket = obtenerTickets()
                withContext(Dispatchers.Main){
                    (rcvTickets.adapter as? Adaptador)?.actualizarLista(nuevosTicket)
            }   }
        }
    }
}