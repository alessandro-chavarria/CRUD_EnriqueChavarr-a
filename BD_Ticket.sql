create table TB_Usuario (
UUID varchar2(40),
nombreUsuario varchar2(100),
contrasenaUsuario varchar2(100)
);

create table TB_Ticket (
UUID varchar2(40),
tituloDeTicket varchar2(75),
descripcionDeTicket varchar2(150),
autorDeTicket varchar2(100),
emailDeAutor varchar2(100),
fechaDeCreacionDeTicket varchar2(10),
estadoDeTicket varchar2(10),
fechaDeFinalizacionDeTicket varchar2(10)
);

SELECT * FROM TB_Ticket;
SELECT * FROM TB_Usuario
commit

drop table TB_Usuario

insert into TB_Ticket(UUID, tituloDeTicket, descripcionDeTicket, autorDeTicket, emailDeAutor, fechaDeCreacionDeTicket, estadoDeTicket, fechaDeFinalizacionDeTicket) 
values ('1212','Monitor danado', 'El monitor no prende', 'Hugo', 'hugo@gmail.com', '15/01/2024', 'Activo', '20/01/2024');

UPDATE tb_ticket SET UUID = ?, tituloDeticket = ?, descripcionDeTicket = ?, autorDeTicket = ?, emailDeAutor = ?, fechaDeCreacionDeTicket = ?, estadoDeTicket = ?, fechaDeFinalizacionDeTicket = ?

delete from TB_Ticket where tituloDeTicket = ?;

insert into TB_Usuario(UUID, nombreUsuario, contrasenaUsuario) 
values (?, ?, ?)

truncate table TB_Ticket 