CREATE TABLE Usuario (
   id_usuario SERIAL PRIMARY KEY,
   nombre varchar(50) not null,
   apellido varchar(50) not null,
   fecha_nacimiento date not null,
   correo varchar(50) unique not null,
   contrasena varchar(60) not null,
   fecha_registro date not null
);

CREATE TABLE Tipo_Servicio (
   id_tipo_servicio SERIAL PRIMARY KEY,
   descripcion varchar(50) not null,
   tarifa decimal(4,2) not null
);

CREATE TABLE Estacion (
   id_estacion SERIAL PRIMARY KEY,
   descripcion varchar(50) not null,
   id_tipo_servicio integer references Tipo_Servicio(id_tipo_servicio) not null
);

CREATE TABLE Servicio (
   id_servicio SERIAL PRIMARY KEY,
   descripcion varchar(50) not null,
   id_tipo_servicio integer references Tipo_Servicio(id_tipo_servicio) not null
);

CREATE TABLE Horario (
   id_horario SERIAL PRIMARY KEY,
   hora time not null
);

CREATE TABLE Destino (
   id_destino SERIAL PRIMARY KEY,
   descripcion varchar(50) not null
);

CREATE TABLE Programacion (
   id_programacion SERIAL PRIMARY KEY,
   id_estacion integer references Estacion(id_estacion) not null,
   id_servicio integer references Servicio(id_servicio) not null,
   id_horario integer references Horario(id_horario) not null,
   id_destino integer references Destino(id_destino) not null,
   activa boolean not null default true
);

CREATE TABLE Reserva (
   id_reserva SERIAL PRIMARY KEY,
   id_usuario integer references Usuario(id_usuario) not null,
   id_programacion integer references Programacion(id_programacion) not null,
   fecha_hora timestamp not null,
   cuenta_bancaria varchar(50) not null
);

INSERT INTO Tipo_Servicio(descripcion,tarifa)
VALUES ('Metropolitano',2.0),
('Tren Electrico',1.5);

INSERT INTO Estacion(descripcion,id_tipo_servicio)
VALUES ('Naranjal',1),
('Izaguirre',1),
('Pacifico',1),
('Independencia',1),
('Loz Jazmines',1),
('Tomas Valle',1),
('El Milagro',1),
('Honorio Delgado',1),
('UNI',1),
('Parque del Trabajo',1),
('Caqueta',1),
('Ramon Castilla',1),
('Tacna',1),
('Jiron de la Union',1),
('Colmena',1),
('Dos de Mayo',1),
('Quilca',1),
('Espana',1),
('Estacion Central',1),
('Estadio Nacional',1),
('Mexico',1),
('Canada',1),
('Javier Prado',1),
('Carnaval Moreyra',1),
('Aramburu',1),
('Domingo Orue',1),
('Angamos',1),
('Ricardo Palma',1),
('Benavides',1),
('28 de Julio',1),
('Plaza de Flores',1),
('Balta',1),
('Bulevar',1),
('Estado Union',1),
('Escuela Militar',1),
('Teran',1),
('Rosario de Villa',1),
('Matellini',1),
('Bayovar',2),
('Santa Rosa',2),
('San Martin',2),
('San Carlos',2),
('Los Postes',2),
('Los Jardines',2),
('Piramide de Sol',2),
('Caja de Agua',2),
('Presbitero Maestro',2),
('El Angel',2),
('Miguel Grau',2),
('Gamarra',2),
('Arriola',2),
('La Cultura',2),
('San Borja Sur',2),
('Angamos',2),
('Cabitos',2),
('Ayacucho',2),
('Jorge Chavez',2),
('Atocongo',2),
('San Juan',2),
('Maria Auxiliadora',2),
('Villa Maria',2),
('Pumacachua',2),
('Parque Industrial',2),
('Villa el Salvador',2);

INSERT INTO Servicio(descripcion,id_tipo_servicio)
VALUES ('Expreso 1',1),
('Expreso 2',1),
('Expreso 3',1),
('Expreso 4',1),
('Expreso 5',1),
('Expreso 6',1),
('Expreso 7',1),
('Linea 1',2);

INSERT INTO Horario(hora)
VALUES ('19:00:00'),
('19:30:00'),
('20:00:00'),
('20:30:00'),
('21:00:00'),
('21:30:00'),
('22:00:00'),
('22:30:00'),
('23:00:00');

INSERT INTO Destino(descripcion)
VALUES ('Norte'),
('Sur');

INSERT INTO Programacion(id_estacion,id_servicio,id_horario,id_destino)
VALUES (23,5,3,1),
(23,5,3,2),
(23,5,5,1),
(23,5,5,2),
(23,5,7,1),
(23,5,7,2),
(23,4,1,1),
(23,4,1,2),
(23,4,2,1),
(23,4,2,2),
(23,7,3,1),
(23,7,3,2),
(23,7,4,1),
(23,7,4,2),
(23,6,1,1),
(23,6,1,2),
(23,6,2,1),
(23,6,2,2),
(23,6,3,1),
(23,6,3,2),
(23,6,4,1),
(23,6,4,2),
(53,8,1,1),
(53,8,1,2),
(53,8,2,1),
(53,8,2,2),
(53,8,3,1),
(53,8,3,2),
(53,8,4,1),
(53,8,4,2),
(53,8,5,1),
(53,8,5,2),
(57,8,1,1),
(57,8,1,2),
(57,8,2,1),
(57,8,2,2),
(57,8,3,1),
(57,8,3,2),
(61,8,4,1),
(61,8,4,2),
(61,8,5,1),
(61,8,5,2),
(61,8,6,1),
(61,8,6,2);

INSERT INTO Usuario( nombre, apellido, correo, contrasena, fecha_nacimiento, fecha_registro)
VALUES ('Paolo', 'Guerrero', 'p.guerrero@gmail.com', '$2a$10$BvLsJkYQ/SDHqMLyfe5ubuzOrWa0EVGTzdzW2jyQ5M5ahn6hwpDXG', '1995-02-14 19:00:00', '2022-09-29 23:18:05.685');

INSERT INTO Reserva(id_usuario, id_programacion, cuenta_bancaria, fecha_hora)
VALUES (1, 6, '76767878', '2022-08-15'),
(1, 6, '76767878', '2022-08-15'),
(1, 10, '645645645', '2022-08-16'),
(1, 8, '23467878', '2022-08-17'),
(1, 3, '98234234', '2022-08-18'),
(1, 9, '32477889', '2022-08-19');