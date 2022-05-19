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

  private int idCuenta;

  @Temporal(TemporalType.DATE)
  private Date fecha;

  private float monto;
  private String tipo;
  private String concepto;

  public int getIdCuenta() {
    return idCuenta;
  }

  public void setIdCuenta(int idCuenta) {
    this.idCuenta = idCuenta;
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
   * Obtiene el valor del atributo fecha.
   *
   * @return El atributo fecha.
   */
  public Date getFecha() {
    return fecha;
  }

  /**
   * Asigna el valor del atributo fecha.
   *
   * @param fecha Valor a asignar al atributo fecha.
   */
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   * Obtiene el valor del atributo monto.
   *
   * @return El atributo monto.
   */
  public float getMonto() {
    return monto;
  }

  /**
   * Asigna el valor del atributo monto.
   *
   * @param monto Valor a asignar al atributo monto.
   */
  public void setMonto(float monto) {
    this.monto = monto;
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
