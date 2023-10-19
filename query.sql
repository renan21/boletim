create database boletim;

use boletim;

-- ----------------------------------------------------------

-- drop table notas;
create table nota(
	id_nota int primary key auto_increment,
    materia varchar(25) not null,
	nota int not null
);

select* from boletim.nota;

-- ----------------------------------------------------------

 -- drop table usuario;
create table usuario(
	id_usuario int primary key auto_increment,
	usuario varchar(25) not null,
    login varchar(25) not null,
	senha varchar(100) not null,
	admin boolean not null
);

select* from boletim.usuario;