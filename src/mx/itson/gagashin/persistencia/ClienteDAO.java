package mx.itson.gagashin.persistencia;

import mx.itson.gagashin.entidades.Cliente;

import mx.itson.gagashin.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene los atributos y métodos correspondientes al cliente
 *
 * @author Diego Castro Arce
 */
public class ClienteDAO {

  /**
   * Obtiene todos los registros de la tabla cliente.
   *
   * @param filtro Define el criterio de búsqueda.
   * @return Una lista con los registros obtenidos.
   */
  public static List<Cliente> obtenerTodos(String filtro) {
    List<Cliente> clientes = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      String q =
          "select * from cliente where nombre like '%"
              + filtro
              + "%' or apellido like '%"
              + filtro
              + "%'";
      Query query = session.createSQLQuery(q);
      ((NativeQuery<?>) query).addEntity(Cliente.class);
      clientes = query.list();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return clientes;
  }

  /**
   * Guarda un nuevo registro de cliente en la base de datos.
   *
   * @param nombre Nombre del cliente.
   * @param apellido Apellido del cliente.
   * @param direccion Dirección del cliente.
   * @param telefono Teléfono del cliente.
   * @param email Correo electrónico del cliente.
   * @param credito Limte de crédito del cliente.
   * @param intereses Tasa de interés del cliente.
   * @return Un entero que indica si el registro fue guardado o no.
   */
  public static boolean guardar(
      String nombre,
      String apellido,
      String direccion,
      String telefono,
      String email,
      String credito,
      String intereses) {
    boolean resultado = false;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Cliente c = new Cliente();
      c.setNombre(nombre);
      c.setApellido(apellido);
      c.setDireccion(direccion);
      c.setTelefono(telefono);
      c.setEmail(email);
      c.setCredito(credito);
      c.setIntereses(intereses);

      session.save(c);
      session.getTransaction().commit();
      resultado = c.getId() != 0;
    } catch (HibernateException ex) {
      System.err.println("Error al guardar cliente: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Guarda los cambios hechos a un cliente existente.
   *
   * @param id Identificador del cliente.
   * @param nombre Nombre del cliente.
   * @param apellido Apellido del cliente.
   * @param direccion Dirección del cliente.
   * @param telefono Teléfono del cliente.
   * @param email Correo electrónico del cliente.
   * @param credito Limte de crédito del cliente.
   * @param intereses Tasa de interés del cliente.
   * @return Un entero que indica si el registro fue guardado o no.
   */
  public static boolean editar(
      int id,
      String nombre,
      String apellido,
      String direccion,
      String telefono,
      String email,
      String credito,
      String intereses) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Cliente c = obtenerPorId(id);
      if (c != null) {
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setDireccion(direccion);
        c.setTelefono(telefono);
        c.setEmail(email);
        c.setCredito(credito);
        c.setIntereses(intereses);
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        resultado = c.getId() != 0;
      }
    } catch (HibernateException ex) {
      System.err.println("Error al editar cliente: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Elimina un registro de cliente de la base de datos.
   *
   * @param id Identificador del cliente.
   * @return Un entero que indica si el registro fue eliminado o no.
   */
  public static boolean eliminar(int id) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Cliente c = obtenerPorId(id);
      if (c != null) {
        session.delete(c);
        session.getTransaction().commit();
        resultado = c.getId() != 0;
      }
    } catch (HibernateException ex) {
      System.err.println("Error al eliminar cliente: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Obtiene los registros de la base de datos con base al criterio id.
   *
   * @param id Identificador del cliente.
   * @return Un objeto de tipo Cliente.
   */
  public static Cliente obtenerPorId(int id) {
    Cliente c = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      c = session.get(Cliente.class, id);
      session.close();
    } catch (HibernateException ex) {
      System.err.println("Error al obtener cliente: " + ex.getMessage());
    }
    return c;
  }

  /**
   * Obtiene la tasa de intereses fija de un cliente.
   *
   * @param idCliente Identificador del cliente.
   * @return Un objeto de tipo Float.
   */
  public static float intereses(int idCliente) {
    float interes = 0;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      String sql = "select intereses from cliente where id = " + idCliente;
      Query query = session.createSQLQuery(sql);
      interes = Float.parseFloat(query.uniqueResult().toString());
    } catch (HibernateException ex) {
      System.err.println("Error al obtener movimientos: " + ex.getMessage());
    }
    return interes;
  }

  /**
   * Obtiene el limite de crédito de un cliente.
   *
   * @param idCliente Identificador del cliente.
   * @return Un objeto de tipo String.
   */
  public static String credito(int idCliente) {
    String credito = "";
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      String sql = "select credito from cliente where id = " + idCliente;
      Query query = session.createSQLQuery(sql);
      credito = query.uniqueResult().toString();
    } catch (HibernateException ex) {
      System.err.println("Error al obtener movimientos: " + ex.getMessage());
    }
    return credito;
  }
}
