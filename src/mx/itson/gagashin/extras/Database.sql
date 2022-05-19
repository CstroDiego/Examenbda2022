CREATE DATABASE gagashindb;
USE gagashindb;

CREATE TABLE cliente
(
    id        INT         NOT NULL auto_increment primary Key,
    nombre    VARCHAR(50) NOT NULL,
    apellido  VARCHAR(50) NOT NULL,
    direccion VARCHAR(50),
    telefono  VARCHAR(15),
    email     VARCHAR(50),
    cuenta    tinyint(1)  not null default 0,
    credito   DECIMAL(10, 2),
    intereses DECIMAL(10, 2)
);

CREATE TABLE movimientos
(
    id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    fecha     DATE,
    monto     DECIMAL(10, 2),
    tipo      VARCHAR(10),
    concepto  VARCHAR(50),
    constraint movimientos_cuenta_id_fk foreign key (idCliente) references cliente (id) on delete cascade
);

