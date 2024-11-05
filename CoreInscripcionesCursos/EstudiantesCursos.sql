CREATE DATABASE estudiantescursos;
USE estudiantescursos;

CREATE TABLE estudiantes(
	id INT AUTO_INCREMENT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(15) not null,
    edad INT NOT NULL
);

CREATE TABLE cursos(
	id INT AUTO_INCREMENT PRIMARY KEY UNIQUE NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    duracion VARCHAR(30) NOT NULL
);

CREATE TABLE libros(
	id INT AUTO_INCREMENT PRIMARY KEY UNIQUE NOT NULL,
    titulo VARCHAR(30) NOT NULL,
    genero VARCHAR(20) NOT NULL
);

CREATE TABLE inscripciones(
	estudiante_id INT,
    curso_id INT,
    PRIMARY KEY (estudiante_id, curso_id),
	FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);

INSERT INTO estudiantes (nombre, edad) VALUES ('Felipe', 24), ('Antonia', 23),
('Andres', 20),('Andrea', 28),('Alondra', 27);

INSERT INTO libros (titulo, genero) VALUES ('1984', 'Distopia'), ('Orgullo y Prejuicio', 'Romance'),
('El señor de los anillos', 'Fantasia'),('Matar a un ruiseñor', 'Drama');

INSERT INTO cursos(nombre, duracion) VALUES 
('JAVA','2 MESES'), ('PYTHON','3 MESES'),('C#','2 MESES'),('JS','1 MES');
SELECT * FROM cursos;

INSERT INTO inscripciones (estudiante_id, curso_id) VALUES 
(1, 1),(1, 2),(2, 1),(2 , 3),(3 , 2),(3, 4),(4 , 1),(4, 3);
SELECT * FROM inscripciones;

SELECT e.nombre AS nombre, c.nombre AS curso FROM estudiantes e INNER JOIN inscripciones i ON e.id = i.estudiante_id INNER JOIN cursos c ON i.curso_id = c.id;

SELECT e.nombre AS nombre, c.nombre AS curso FROM estudiantes e JOIN inscripciones i ON e.id = i.estudiante_id JOIN cursos c ON i.curso_id = c.id WHERE c.nombre = 'JAVA';
SELECT e.nombre AS nombre, c.nombre AS curso FROM estudiantes e JOIN inscripciones i ON e.id = i.estudiante_id JOIN cursos c ON i.curso_id = c.id WHERE c.nombre = 'PYTHON';

SELECT e.nombre AS nombre, c.nombre AS curso FROM estudiantes e JOIN inscripciones i ON e.id = i.estudiante_id JOIN cursos c ON i.curso_id = c.id WHERE e.nombre = 'Andres';
SELECT e.nombre AS nombre, c.nombre AS curso FROM estudiantes e JOIN inscripciones i ON e.id = i.estudiante_id JOIN cursos c ON i.curso_id = c.id WHERE e.nombre = 'Felipe';
SELECT e.nombre AS nombre, c.nombre AS curso FROM estudiantes e JOIN inscripciones i ON e.id = i.estudiante_id JOIN cursos c ON i.curso_id = c.id WHERE e.nombre = 'Antonia';

SELECT c.nombre AS curso, COUNT(i.estudiante_id) AS cantidad_estudiantes FROM cursos c JOIN inscripciones i ON c.id = i.curso_id GROUP BY c.nombre;

SELECT e.nombre AS estudiante FROM estudiantes e LEFT JOIN inscripciones i ON e.id = i.estudiante_id WHERE i.curso_id IS NULL;



