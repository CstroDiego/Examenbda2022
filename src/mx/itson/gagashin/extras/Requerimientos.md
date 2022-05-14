El proyecto consiste en desarrollar un programa en Java con base de datos en MySQL y utilizando Hibernate, cuya función
es la **administración de movimientos y saldos de una tarjeta de crédito**. El proceso completo de una tarjeta real
abarca
varias cosas, pero para efectos de esta asignación solo se requiere lo siguiente:

- Administración de clientes (agregar, editar, eliminar, buscar).
- Administración de tarjetas. Cada cliente solo podrá tener una tarjeta.
- Administración de períodos. Para esta práctica tomaremos como períodos los meses naturales. La fecha de corte será la
  misma para todos los clientes y será el último día de cada mes.
- Administración de movimientos. Agregar, cancelar y consultar movimientos de cargo o abono, mismos que sólo pueden
  pertenecer a un estado de cuenta a la vez.
- Consultar estado de cuenta. Al terminar un período se tendrá que mostrar el estado de cuenta que consiste de lo
  siguiente:
    * Movimientos del período, cada uno con fecha, descripción, importe (ubicado en la columna cargo o abono, según
      corresponda) y el subtotal.
    * Intereses aplicados, calculados a partir del saldo promedio diario y multiplicado por la tasa de interés que podrá
      ser diferente para cada cliente.
- Poder seleccionar la fecha del sistema para cambiarla y crear movimientos en diferentes fechas.

---