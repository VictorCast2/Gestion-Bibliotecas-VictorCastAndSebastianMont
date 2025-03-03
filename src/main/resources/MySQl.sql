// Crear base de datos
create database db_proyect;

// Eliminar base de datos
drop database db_proyect;

// Seleccionar base de datos
SELECT * FROM db_proyect.roles;

// Usar la base de datos
use db_proyect;

// Crear tabla usuario
insert into usuario (username, password) values ('admin','$2a$10$Qtr0NG8HujfTz8sCaa5Kku9G81zj.04t0nT5AYQ2.33HAZwBh0HGm');
// Crear tabla roles
insert into roles (usuario_id, rol) values ('1','ROLE_Admin');
// Crear tabla usuario
insert into usuario (username, password) values ('user','$2a$10$oSnJTpGXDQQPLkNApJ6.sOEd7IStF8uaOpjs6wDhlSDW6la8yBlrm');
// Crear tabla roles
insert into roles (usuario_id, rol) values ('2','ROLE_User');