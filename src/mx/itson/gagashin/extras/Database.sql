DROP TABLE IF EXISTS cliente;
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


DROP TABLE IF EXISTS cuenta;
-- CREATE TABLE cuenta
-- (
--    id              INT NOT NULL auto_increment primary Key,
--    idCliente       INT,
--    credito         DECIMAL(10, 2),
--    ajusteCredito   DECIMAL(10, 2),
--    intereses       DECIMAL(10, 2),
--    bloquearTarjeta BOOLEAN,
--    constraint cuenta_cliente_id_fk
--        foreign key (idCliente) references cliente (id) on delete cascade
-- );

DROP TABLE IF EXISTS movimientos;
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

DROP TABLE IF EXISTS corte;
-- CREATE TABLE corte
-- (
--    id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    periodo  VARCHAR(20),
--    monto    DECIMAL(10, 2),
--    idCuenta INT NOT NULL,
--    constraint corte_cuenta_id_fk foreign key (idCuenta) references cuenta (id) on delete cascade
-- );
