package modelo

data class Tickets(
    val uuid: String,
    val tituloDeTicket: String,
    val descripcionDeTicket: String,
    val autorDeTicket: String,
    val emailDeAutor: String,
    val fechaDeCreacionDeTicket: String,
    val estadoDeTicket: String,
    val fechaDeFinalizacionDeTicket: String

)
