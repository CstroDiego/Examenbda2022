package mx.itson.gagashin.persistencia;

import mx.itson.gagashin.entidades.Cliente;
import mx.itson.gagashin.entidades.Cuenta;
import mx.itson.gagashin.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

  public static List<Cuenta> obtenerTodos() {
    List<Cuenta> cuentas = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      CriteriaQuery<Cuenta> criteriaQuery = session.getCriteriaBuilder().createQuery(Cuenta.class);
      criteriaQuery.from(Cuenta.class);
      cuentas = session.createQuery(criteriaQuery).getResultList();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return cuentas;
  }

  public static boolean guardar(String credito, String intereses, int idCliente) {

    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Cuenta c = new Cuenta();
      c.setCredito(credito);
      c.setIntereses(intereses);
      c.setIdCliente(idCliente);
      session.save(c);
      session.getTransaction().commit();
      resultado = c.getId() != 0;
    } catch (HibernateException ex) {
      System.err.println("Error al guardar cuenta: " + ex.getMessage());
    }
    return resultado;
  }

  public static boolean editar(int id, String credito, String intereses, int idCliente) {

    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Cuenta c = obtenerPorId(id);
      if (c != null) {
        c.setCredito(credito);
        c.setIntereses(intereses);
        c.setIdCliente(idCliente);
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        resultado = c.getId() != 0;
      }
    } catch (HibernateException ex) {
      System.err.println("Error al editar cuenta: " + ex.getMessage());
    }
    return resultado;
  }

  public static boolean eliminar(int id) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Cuenta c = obtenerPorId(id);
      if (c != null) {
        session.delete(c);
        session.getTransaction().commit();
        resultado = c.getId() != 0;
      }
    } catch (HibernateException ex) {
      System.err.println("Error al eliminar cuenta: " + ex.getMessage());
    }
    return resultado;
  }

  public static Cuenta obtenerPorId(int id) {
    Cuenta c = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      c = session.get(Cuenta.class, id);
    } catch (HibernateException ex) {
      System.err.println("Error al obtener cuenta: " + ex.getMessage());
    }
    return c;
  }
}
