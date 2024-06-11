package RecyclerViewHelpers

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import enrique.chavarria.crud_enriquechavarra.R

class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
    val lbtituloDeTicket = vista.findViewById<TextView>(R.id.lbtituloDeTicket)
    val lbdescripcionDeTicket = vista.findViewById<TextView>(R.id.lbdescripcionDeTicket)
    val lbautorDeTicket = vista.findViewById<TextView>(R.id.lbautorDeTicket)
    val lbemailDeAutor = vista.findViewById<TextView>(R.id.lbemailDeAutor)
    val lbfechaDeCreacionDeTicket = vista.findViewById<TextView>(R.id.lbfechaDeCreacionDeTicket)
    val lbestadoDeTicket = vista.findViewById<TextView>(R.id.lbestadoDeTicket)
    val lbfechaDeFinalizacionDeTicket = vista.findViewById<TextView>(R.id.lbfechaDeFinalizacionDeTicket)
        val imgEliminar = vista.findViewById<ImageButton>(R.id.imgEliminar)
        val imgEditar = vista.findViewById<ImageButton>(R.id.imgEditar)
}