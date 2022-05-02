-- Fecha de corte
-- Fecha de pago
-- Monto minimo (genera intereses)
-- Pago para no generar intereses
-- Ajustar credito
-- Bloquear tarjeta

CREATE TABLE tlbCliente
(
    id        INT NOT NULL auto_increment primary Key,
    nombre    VARCHAR(30),
    apellido  VARCHAR(50),
    direccion VARCHAR(80),
    telefono  INT(10)
);

CREATE TABLE tblCuenta
(
    id                INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
    cuentaClave       VARCHAR(14),
    credito           VARCHAR(9),
    creditoDisponible VARCHAR(9),
    idCliente         INT NOT NULL
);
-- tipo enum('credito', 'debito')

CREATE TABLE tlbMovimientos
(
    id       INT                     NOT NULL AUTO_INCREMENT  PRIMARY KEY,
    tipo     ENUM ('abono', 'gasto') NOT NULL,
    concepto VARCHAR(80),
    fecha    DATE,
    monto    VARCHAR(9),
    idCuenta INT                     NOT NULL
);


