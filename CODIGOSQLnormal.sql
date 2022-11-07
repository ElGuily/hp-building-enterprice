create database HPBE;
use HPBE;

create table Usuario(
	id_usuario int auto_increment primary key,
    nombre_usuario varchar(30),
	contraseña varchar(30)
);

create table Cliente(
	id_cliente int auto_increment primary key,
    Email_cliente varchar(255) not null,
    DNI_Cliente int unsigned not null,
    CantidadDeCompras int unsigned not null,
    Nombre_cliente varchar(45),
    Direccion varchar(45),
    MetodoDePago varchar(45),
    usuario int,
	foreign key(usuario) references Usuario(id_usuario)
);


create table Categoria(
	id_categoria int auto_increment primary key,
    nombre_cat varchar(40)
);

create table Empleado(
	id_empleado int auto_increment primary key,
    user_empleado varchar(45),
    email_empleado varchar(255),
    password_empleado varchar(32),
    DNI_empleado int unsigned not null,
    nombre_empleado varchar(45),
    facturado float(10,2)
    
);
SET GLOBAL log_bin_trust_function_creators = 1;
create table Ventas(
	ID_ventas int auto_increment primary key,
    id_empleado int,
    id_pc int,
    id_cliente int,
    precio_total float(10,2),
    foreign key(id_empleado) references Empleado(id_empleado),
    foreign key(id_pc) references PC(id_pc),
    foreign key(id_cliente) references Cliente(id_cliente)
);


create table PC(
	id_pc int auto_increment primary key,
    nombre_pc varchar(40),
    modelo varchar(40),
    id_categoria int,
    precio float(10,2),
    cant_comp_importados int,
	foreign key(id_categoria) references Categoria(id_categoria)
);
select * from Usuario;
delete from Usuario where nombre_usuario = "facunare";
select * from Empleado;
call registrarUsuario("admin", "admin");
select loginEmpleado("facunare", "1234");

/*

CREATE DEFINER=`root`@`localhost` FUNCTION `loginUsuario`(
	nom_us varchar(30),
    passw_us varchar(30)
) RETURNS int
BEGIN
IF EXISTS (select * from usuario where nombre_usuario = nom_us and contraseña = passw_us) THEN
		RETURN 1;
	ELSE
		RETURN 0;
	END IF;

END

CREATE DEFINER=`root`@`localhost` FUNCTION `loginEmpleado`(
	nom_us varchar(30),
    passw_us varchar(30)
) RETURNS int
BEGIN
IF EXISTS (select * from Empleado where user_empleado = nom_us and password_empleado = passw_us) THEN
		RETURN 1;
	ELSE
		RETURN 0;
	END IF;

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarEmpleado`(
	user_n varchar(45),
    email varchar(255),
    passw varchar(32),
    DNI int,
    nombre varchar(45)
)
BEGIN
	insert into Empleado(user_empleado, email_empleado, password_empleado, DNI_empleado, nombre_empleado) values(user_n, email, passw, DNI, nombre);
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarUsuario`(
	in nom_us varchar(50),
    in passw_us varchar(50)
)
BEGIN
	insert into Usuario(nombre_usuario, contraseña) values(nom_us, passw_us);
END





*/
