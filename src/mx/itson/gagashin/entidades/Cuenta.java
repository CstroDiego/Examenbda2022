package mx.itson.gagashin.entidades;

import javax.persistence.*;

/**
 * Representa la cuenta de los usuarios.
 *
 * @author Diego Castro Arce
 * @author Andrés Uriel López Castillo
 * @author Alan Fernando Romero Hernandez
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "idCliente")
  private Cliente cliente;

  private float credito;
  private float ajusteCredito;
  private float intereses;
  private boolean bloquearTarjeta;

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
   * Obtiene el valor del atributo cliente.
   *
   * @return El atributo cliente.
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * Asigna el valor del atributo cliente.
   *
   * @param cliente Valor a asignar al atributo cliente.
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * Obtiene el valor del atributo credito.
   *
   * @return El atributo credito.
   */
  public float getCredito() {
    return credito;
  }

  /**
   * Asigna el valor del atributo credito.
   *
   * @param credito Valor a asignar al atributo credito.
   */
  public void setCredito(float credito) {
    this.credito = credito;
  }

  /**
   * Obtiene el valor del atributo ajusteCredito.
   *
   * @return El atributo ajusteCredito.
   */
  public float getAjusteCredito() {
    return ajusteCredito;
  }

  /**
   * Asigna el valor del atributo ajusteCredito.
   *
   * @param ajusteCredito Valor a asignar al atributo ajusteCredito.
   */
  public void setAjusteCredito(float ajusteCredito) {
    this.ajusteCredito = ajusteCredito;
  }

  /**
   * Obtiene el valor del atributo intereses.
   *
   * @return El atributo intereses.
   */
  public float getIntereses() {
    return intereses;
  }

  /**
   * Asigna el valor del atributo intereses.
   *
   * @param intereses Valor a asignar al atributo intereses.
   */
  public void setIntereses(float intereses) {
    this.intereses = intereses;
  }

  /**
   * Obtiene el valor del atributo bloquearTarjeta.
   *
   * @return El atributo bloquearTarjeta.
   */
  public boolean isBloquearTarjeta() {
    return bloquearTarjeta;
  }

  /**
   * Asigna el valor del atributo bloquearTarjeta.
   *
   * @param bloquearTarjeta Valor a asignar al atributo bloquearTarjeta.
   */
  public void setBloquearTarjeta(boolean bloquearTarjeta) {
    this.bloquearTarjeta = bloquearTarjeta;
  }
}
