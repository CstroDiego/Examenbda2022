package mx.itson.nu.persistencia;

import mx.itson.nu.entidades.Cliente;
import mx.itson.nu.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
  public static List<Cliente> obtenerTodos() {
    List<Cliente> clientes = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      CriteriaQuery<Cliente> criteriaQuery =
          session.getCriteriaBuilder().createQuery(Cliente.class);
      criteriaQuery.from(Cliente.class);
      clientes = session.createQuery(criteriaQuery).getResultList();
      session.close();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return clientes;
  }

  public static boolean guardar(
      String nombre, String apellido, String direccion, String telefono, String email) {
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
      session.save(c);
      session.getTransaction().commit();
      resultado = c.getId() != 0;
    } catch (HibernateException ex) {
      System.err.println("Error al guardar cliente: " + ex.getMessage());
    }
    return resultado;
  }

  public static boolean editar(
      int id, String nombre, String apellido, String direccion, String telefono, String email) {
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
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        resultado = c.getId() != 0;
      }
    } catch (HibernateException ex) {
      System.err.println("Error al editar cliente: " + ex.getMessage());
    }
    return resultado;
  }

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
}
