CREATE TABLE REST.CLIENTES(
	ID INTEGER,
    NOMBRE NVARCHAR(50),
    APP NVARCHAR(50),
    APM NVARCHAR(50)
);

SELECT * FROM REST.CLIENTES;

INSERT INTO REST.CLIENTES VALUES (1, 'MARIO', 'GOMEZ', 'DE LA ROSA');