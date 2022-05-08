package mx.itson.nu.entidades;

import javax.persistence.*;

/**
 * The type Corte.
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
   * Gets id.
   *
   * @return the id
   */
public int getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets periodo.
   *
   * @return the periodo
   */
public String getPeriodo() {
    return periodo;
  }

  /**
   * Sets periodo.
   *
   * @param periodo the periodo
   */
public void setPeriodo(String periodo) {
    this.periodo = periodo;
  }

  /**
   * Gets monto.
   *
   * @return the monto
   */
public float getMonto() {
    return monto;
  }

  /**
   * Sets monto.
   *
   * @param monto the monto
   */
public void setMonto(float monto) {
    this.monto = monto;
  }

  /**
   * Gets cuenta.
   *
   * @return the cuenta
   */
public Cuenta getCuenta() {
    return cuenta;
  }

  /**
   * Sets cuenta.
   *
   * @param cuenta the cuenta
   */
public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
  }
}
