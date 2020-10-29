CREATE TABLE PROFESOR13(
    ID NUMBER PRIMARY KEY,
    NOMBRE NVARCHAR2(50),
    APP NVARCHAR2(50),
    APM NVARCHAR2(50),
    EDAD NUMBER,
    MATERIA NVARCHAR2(30),
    GANANCIA NUMBER
);

INSERT INTO PROFESOR13 VALUES(1, 'RODRIGO', 'HERNANDEZ', 'FLORES', 55, 'PROGRAMACIÓN', 20000);
INSERT INTO PROFESOR13 VALUES(2, 'NATELLA', 'ANTONIAN', NULL, 55 , 'MATEMATICAS', 60000);
INSERT INTO PROFESOR13 VALUES(3, 'Antonio', 'Hernandez', 'Blass', 34, 'Programación L.C.', 20000);
INSERT INTO PROFESOR13 VALUES(4, 'Ana Patricia', 'Cervantes', 'Marquez', 50, 'Sistemas Operativos', 40000);
INSERT INTO PROFESOR13 VALUES(5, 'Francisco', 'Hernandez', 'Jimenez', 65, 'Base de Datos', 20000);
INSERT INTO PROFESOR13 VALUES(6, 'Gudelia Pilar', 'Perez', 'Conde', 35, 'Analisis y Diseño de Proyecto',30000);

select * from profesor13;
--1.-buscar los profesores que su nombre empieze con una "A" o una "G".
SELECT * FROM PROFESOR13 WHERE NOMBRE LIKE 'A%' OR NOMBRE LIKE 'G%';

--2.-ordenar los registros en base a su app paterno y luego a su app materno y asu ganancia agregarla $
SELECT ID, NOMBRE, APP, APM, EDAD, MATERIA, CONCAT ('$', GANANCIA) AS GANANCIA FROM PROFESOR13 ORDER BY APP;
SELECT ID, NOMBRE, APP, APM, EDAD, MATERIA, CONCAT ('$', GANANCIA) AS GANANCIA FROM PROFESOR13 ORDER BY APM;

--3.-contart cuantos profesores su ganacia esta entre 20000 y 40000
SELECT GANANCIA, 
COUNT(GANANCIA) AS CANTIDAD
FROM PROFESOR13
WHERE GANANCIA BETWEEN 20000 AND 40000
GROUP BY GANANCIA;

--4.-buscar a los profesores que su apm sea NULL
SELECT * FROM PROFESOR13 WHERE APM IS NULL;

--5.-buscar el precio mas elevado de ganacia de un profesor
SELECT MAX(GANANCIA) GANACIA_ALTA FROM PROFESOR13;