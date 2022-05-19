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

  @Column(name = "idCliente")
  private int idCliente;

  @Column(name = "credito")
  private String credito;

  @Column(name = "intereses")
  private String intereses;

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
  public int getIdCliente() {
    return idCliente;
  }

  /**
   * Asigna el valor del atributo cliente.
   *
   * @param idCliente Valor a asignar al atributo cliente.
   */
  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  /**
   * Obtiene el valor del atributo credito.
   *
   * @return El atributo credito.
   */
  public String getCredito() {
    return credito;
  }

  /**
   * Asigna el valor del atributo credito.
   *
   * @param credito Valor a asignar al atributo credito.
   */
  public void setCredito(String credito) {
    this.credito = credito;
  }

  /**
   * Obtiene el valor del atributo intereses.
   *
   * @return El atributo intereses.
   */
  public String getIntereses() {
    return intereses;
  }

  /**
   * Asigna el valor del atributo intereses.
   *
   * @param intereses Valor a asignar al atributo intereses.
   */
  public void setIntereses(String intereses) {
    this.intereses = intereses;
  }
}
