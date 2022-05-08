package mx.itson.nu.entidades;

import javax.persistence.*;

/**
 * Representa los clientes del banco.
 *
 * @author Diego Castro Arce
 * @author Andrés Uriel López Castillo
 * @author Alan Fernando Romero Hernandez
 */
@Entity
@Table(name = "tblCliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nombre;
  private String apellido;
  private String direccion;
  private String telefono;
  private String email;

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
