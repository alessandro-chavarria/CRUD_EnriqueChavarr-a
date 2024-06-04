create table TB_Usuario (
UUID varchar2(40),
nombreUsuario varchar2(100),
contrasenaUsuario varchar2(100)
);

create table TB_Ticket (
UUID varchar2(40),
numeroDeTicket int,
tituloDeTicket varchar2(75),
descripcionDeTicket varchar2(150),
autorDeTicket varchar2(100),
emailDeAutor varchar2(100),
fechaDeCreacionDeTicket varchar2(10),
estadoDeTicket varchar2(10),
fechaDeFinalizacionDeTicket varchar2(10)
);