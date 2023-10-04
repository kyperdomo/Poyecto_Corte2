USE montañoDanna;
CREATE TABLE personas(
id INT PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(100)  NOT NULL,
fechanacimiento DATE  NOT NULL,
cedula INT(10) UNIQUE  NOT NULL,
ciudadnacimiento VARCHAR(100)  NOT NULL
);

CREATE TABLE alcoholicos(
id INT PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(100)  NOT NULL,
fechanacimiento DATE  NOT NULL,
cedula INT(10) UNIQUE NOT NULL,
ciudadnacimiento VARCHAR(100)  NOT NULL,
Sesionesparticipadas INT  NOT NULL,
Apodo VARCHAR(100)  NOT NULL
);

CREATE TABLE psicologos(
id INT PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(100) NOT NULL,
fechanacimiento DATE NOT NULL,
cedula INT(10) UNIQUE NOT NULL, 
ciudadnacimiento VARCHAR(100) NOT NULL,
añograduacion YEAR NOT NULL,
díasservicio INT NOT NULL, 
Sesionesapoyadas INT NOT NULL,
salario BIGINT NOT NULL
);

CREATE TABLE serviciosgenrales(
id INT PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(100) NOT NULL,
fecha DATE NOT NULL,
cedula INT(10) UNIQUE NOT NULL,
ciudadorigen VARCHAR(100) NOT NULL,
Sesioneslimpiadas INT NOT NULL,
salario BIGINT NOT NULL
);

CREATE TABLE administradores(
id INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(100) UNIQUE NOT NULL,
contraseña VARCHAR(100) NOT NULL
);

INSERT INTO alcoholicos (Nombre, fechanacimiento, cedula, ciudadnacimiento,Sesionesparticipadas,
Apodo) VALUES ('Karen','2005-09-21','1111111111','Bogota','3','prini');
INSERT INTO alcoholicos (Nombre, fechanacimiento, cedula, ciudadnacimiento,Sesionesparticipadas,
Apodo) VALUES ('Danna','2005-04-12','1111132323','Bogota','4','roko');

INSERT INTO psicologos (Nombre,fechanacimiento,cedula, ciudadnacimiento,añograduacion,díasservicio, Sesionesapoyadas,
salario) VALUES ('Yishet','1996-06-20','1234325678','Bogota','2018','100','50','2300000');
INSERT INTO psicologos (Nombre,fechanacimiento,cedula, ciudadnacimiento,añograduacion,díasservicio, Sesionesapoyadas,
salario) VALUES ('Valentina','1999-06-20','1234525678','Bogota','2020','58','40','2300000');

INSERT INTO serviciosgenrales (Nombre,fecha,cedula,ciudadorigen,Sesioneslimpiadas,salario) 
VALUES ('roman','2000-09-21','1341111111','Bogota','4','1000000');
INSERT INTO serviciosgenrales (Nombre,fecha,cedula,ciudadorigen,Sesioneslimpiadas,salario) 
VALUES ('estela','2000-11-25','1341113121','Bogota','4','700000');

INSERT INTO administradores(usuario,contraseña) VALUES ('cristianjb','cris153');
INSERT INTO administradores (usuario,contraseña) VALUES ('ValeryN2','val_03');

SELECT *FROM alcoholicos;
SELECT *FROM psicologos;
SELECT *FROM serviciosgenrales;
SELECT *FROM administradores;

