-- Fecha de corte
-- Fecha de pago
-- Monto minimo (genera intereses)
-- Pago para no generar intereses
-- Ajustar credito
-- Bloquear tarjeta

CREATE TABLE cliente
(
    id        INT         NOT NULL auto_increment primary Key,
    nombre    VARCHAR(50) NOT NULL,
    apellido  VARCHAR(50) NOT NULL,
    direccion VARCHAR(50),
    telefono  VARCHAR(15),
    email     VARCHAR(50)
);

CREATE TABLE cuenta
(
    id              INT NOT NULL auto_increment primary Key,
    idCliente       INT,
    saldo           DECIMAL(10, 2),
    fechaCorte      DATE,
    fechaPago       DATE,
    montoMinimo     DECIMAL(10, 2),
    pagoNoInteres   DECIMAL(10, 2),
    ajusteCredito   DECIMAL(10, 2),
    intereses       DECIMAL(10, 2),
    bloquearTarjeta BOOLEAN
);

CREATE TABLE movimiento
(
    id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idCuenta INT,
    fecha    DATE,
    monto    DECIMAL(10, 2),
    tipo     VARCHAR(10),
    concepto VARCHAR(50)
);


CREATE TABLE corte
(
    id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fecha    DATE,
    monto    DECIMAL(10, 2),
    idCuenta INT NOT NULL
);
