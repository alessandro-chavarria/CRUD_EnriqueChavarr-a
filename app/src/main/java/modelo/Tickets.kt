package modelo

data class Tickets(
    val uuid: String,
    var tituloDeTicket: String,
    var descripcionDeTicket: String,
    var autorDeTicket: String,
    var emailDeAutor: String,
    var fechaDeCreacionDeTicket: String,
    var estadoDeTicket: String,
    var fechaDeFinalizacionDeTicket: String

)
