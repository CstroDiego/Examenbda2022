package mx.itson.gagashin.entidades;

import javax.persistence.*;

/**
 * Representa los clientes del banco.
 *
 * @author Andrés Uriel López Castillo
 */
@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombre;
  private String apellido;
  private String direccion;
  private String telefono;
  private String email;

  private String credito;
  private String intereses;

  /**
   * Obtiene el valor del atributo Crédito.
   *
   * @return El valor del atributo Crédito.
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
   * @return El valor del atributo intereses.
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
   * Obtiene el valor del atributo nombre.
   *
   * @return El atributo nombre.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Asigna el valor del atributo nombre.
   *
   * @param nombre Valor a asignar al atributo nombre.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Obtiene el valor del atributo apellido.
   *
   * @return El atributo apellido.
   */
  public String getApellido() {
    return apellido;
  }

  /**
   * Asigna el valor del atributo apellido.
   *
   * @param apellido Valor a asignar al atributo apellido.
   */
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  /**
   * Obtiene el valor del atributo direccion.
   *
   * @return El atributo direccion.
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Asigna el valor del atributo direccion.
   *
   * @param direccion Valor a asignar al atributo direccion.
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * Obtiene el valor del atributo telefono.
   *
   * @return El atributo telefono.
   */
  public String getTelefono() {
    return telefono;
  }

  /**
   * Asigna el valor del atributo telefono.
   *
   * @param telefono Valor a asignar al atributo telefono.
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Obtiene el valor del atributo email.
   *
   * @return El atributo email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Asigna el valor del atributo email.
   *
   * @param email Valor a asignar al atributo email.
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
