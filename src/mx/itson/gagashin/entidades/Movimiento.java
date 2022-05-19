package mx.itson.gagashin.entidades;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa los movimientos de una cuenta, ya sea gasto o abono.
 *
 * @author Diego Castro Arce
 * @author Andrés Uriel López Castillo
 */
@Entity
@Table(name = "movimientos")
public class Movimiento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String fecha;
  private String monto;
  private String tipo;
  private String concepto;
  private int idCliente;

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public String getMonto() {
    return monto;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

  /**
   * Obtiene el valor del atributo id.
   *
   * @return El atributo id.
   */
  public int getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo id.
   *
   * @param id Valor a asignar al atributo id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Obtiene el valor del atributo tipo.
   *
   * @return El atributo tipo.
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Asigna el valor del atributo tipo.
   *
   * @param tipo Valor a asignar al atributo tipo.
   */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  /**
   * Obtiene el valor del atributo concepto.
   *
   * @return El atributo concepto.
   */
  public String getConcepto() {
    return concepto;
  }

  /**
   * Asigna el valor del atributo concepto.
   *
   * @param concepto Valor a asignar al atributo concepto.
   */
  public void setConcepto(String concepto) {
    this.concepto = concepto;
  }
}
