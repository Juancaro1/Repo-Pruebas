CREATE DATABASE clientespedidos;
USE clientespedidos;

CREATE TABLE clientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) UNIQUE NOT NULL,
    direccion VARCHAR(40) NOT NULL,
    telefono VARCHAR(15) NOT NULL
);

CREATE TABLE pedidos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    clientes_id INT,
    fecha DATE NOT NULL,
    total FLOAT NOT NULL,
    FOREIGN KEY (clientes_id) REFERENCES clientes(id)
);

INSERT INTO clientes (nombre, direccion, telefono) VALUES 
('Miguel', 'Concepcion', '967834523'), 
('Angelo', 'Santiago', '956472937'), 
('Felipe', 'Temuco', '946727382'), 
('Maria', 'Maipu', '972401528'), 
('Patricio', 'Talca', '910263875');

INSERT INTO pedidos (clientes_id, fecha, total) VALUES
(1, '2024-10-28', 3200.00), 
(2, '2024-08-15', 1800.50), 
(3, '2024-09-12', 1850.00),
(4, '2024-09-15', 340.00), 
(5, '2024-02-09', 200.00), 
(1, '2024-03-01', 750.00),
(2, '2024-01-09', 10500.00),
(3, '2024-03-10', 120.00),
(4, '2024-12-04', 7800.00),
(5, '2024-01-19', 560.00);

SELECT c.id AS cliente_id, c.nombre, c.direccion, c.telefono, p.id AS pedido_id, p.fecha, p.total FROM clientes c LEFT JOIN pedidos p ON c.id = p.clientes_id;

SELECT p.id AS pedido_id, p.fecha, p.total FROM pedidos p WHERE p.clientes_id = 1;

SELECT c.id AS cliente_id, c.nombre, c.direccion, c.telefono, sum(p.total) AS total_pedido FROM clientes c LEFT JOIN pedidos p ON c.id = p.clientes_id GROUP BY c.id, 
c.nombre, c.direccion, c.telefono;

DELETE FROM pedidos WHERE clientes_id = 2;
DELETE FROM clientes WHERE id = 2;
SELECT * FROM clientes;

SELECT c.id AS cliente_id, c.nombre, COUNT(p.id) AS total_pedidos FROM clientes c LEFT JOIN pedidos p ON c.id = p.clientes_id GROUP BY c.id, c.nombre ORDER BY total_pedidos DESC LIMIT 3;




SELECT * FROM clientes;
SELECT * FROM pedidos;






