package mx.itson.nu.entidades;

import javax.persistence.*;

/**
 * Representa los cortes de una tarjeta de crédito.
 *
 * @author Diego Castro Arce
 * @author Andrés Uriel López Castillo
 * @author Alan Fernando Romero Hernandez
 */
@Entity
@Table(name = "corte")
public class Corte {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String periodo;
  private float monto;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "idCuenta")
  private Cuenta cuenta;

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
   * Obtiene el valor del atributo periodo.
   *
   * @return El atributo periodo.
   */
  public String getPeriodo() {
    return periodo;
  }

  /**
   * Asigna el valor del atributo periodo.
   *
   * @param periodo Valor a asignar al atributo periodo.
   */
  public void setPeriodo(String periodo) {
    this.periodo = periodo;
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
   * Obtiene el valor del atributo cuenta.
   *
   * @return El atributo cuenta.
   */
  public Cuenta getCuenta() {
    return cuenta;
  }

  /**
   * Asigna el valor del atributo cuenta.
   *
   * @param cuenta Valor a asignar al atributo cuenta.
   */
  public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
  }
}
