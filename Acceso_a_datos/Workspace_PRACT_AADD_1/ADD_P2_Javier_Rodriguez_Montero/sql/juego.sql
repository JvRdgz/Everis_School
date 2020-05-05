-- PARA EJECUTAR EL SCRIPT DE LA CREACION DE LA BASE DE DATOS
-- QUE SE ENCUENTRA EN UN FICHERO, UTILIZAR EL SIGUIENTE COMANDO:
-- source /ruta/del/fichero/fichero.sql

-- 					MODO BATCH
-- TAMBIEN SE PUEDE EJECUTAR EL FICHERO .sql MEDIANTE LA SHELL CON
-- EL SIGUIENTE COMANDO:
-- mysql -u nombreUsuario -pContraseñaUsuario < fichero.sql
-- (Como has podido comprobar, la opcion -p va sin espacios junto con la contraseña)

-- ----------------------------------------------------------------------------------------

-- SELECCIONAMOS EL JUEGO DE CARACTERES A UTILIZAR: WE8ISO8859P15 (incluye €, acentos y 'ñ') Y LA COLACIÓN.

-- DROP DATABASE juego;

CREATE DATABASE IF NOT EXISTS juego CHARACTER SET latin1 COLLATE latin1_spanish_ci;

USE juego;

CREATE TABLE IF NOT EXISTS preguntas (
	preguntaId int NOT NULL AUTO_INCREMENT,
	pregunta VARCHAR(1024),
    respuesta1 VARCHAR(1024),
    respuesta2 VARCHAR(1024),
    respuesta3 VARCHAR(1024),
    respuesta_correcta VARCHAR(1024),
	PRIMARY KEY (preguntaID)
);

-- INSERT INTO preguntas (pregunta, respuesta1, respuesta2, respuesta3, respuesta_correcta)
-- VALUES('En que anio se produjo la catastrofe de Chernobyl?','1992','1986','1989','1986');
-- DELETE FROM preguntas;

SELECT * FROM preguntas;

-- USE dam;

-- SELECT * FROM alumno;