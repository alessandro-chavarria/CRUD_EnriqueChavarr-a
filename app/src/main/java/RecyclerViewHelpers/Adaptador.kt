package RecyclerViewHelper

import RecyclerViewHelpers.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import enrique.chavarria.crud_enriquechavarra.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import modelo.ClaseConexion
import modelo.Tickets


class Adaptador(private var Datos: List<Tickets>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item_card, parent, false)

        return ViewHolder(vista)
    }
    override fun getItemCount() = Datos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket = Datos[position]
        holder.lbtituloDeTicket.text = ticket.tituloDeTicket
        holder.lbdescripcionDeTicket.text = ticket.descripcionDeTicket
        holder.lbautorDeTicket.text = ticket.autorDeTicket
        holder.lbemailDeAutor.text = ticket.emailDeAutor
        holder.lbfechaDeCreacionDeTicket.text = ticket.fechaDeCreacionDeTicket
        holder.lbestadoDeTicket.text = ticket.estadoDeTicket
        holder.lbfechaDeFinalizacionDeTicket.text = ticket.fechaDeFinalizacionDeTicket
    }

}
