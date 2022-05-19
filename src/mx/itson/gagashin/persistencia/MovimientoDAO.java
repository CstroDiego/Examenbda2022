package mx.itson.gagashin.persistencia;

import mx.itson.gagashin.entidades.Cuenta;
import mx.itson.gagashin.entidades.Movimiento;
import mx.itson.gagashin.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovimientoDAO {

  public static List<Movimiento> obtenerTodos(int idCliente) {
    List<Movimiento> movimientos = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      CriteriaQuery<Movimiento> criteriaQuery =
          session.getCriteriaBuilder().createQuery(Movimiento.class);
      criteriaQuery.from(Movimiento.class, idCliente);
      movimientos = session.createQuery(criteriaQuery).getResultList();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return movimientos;
  }

  public static Movimiento obtenerPorId(int id) {
    Movimiento m = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      m = session.get(Movimiento.class, id);

    } catch (HibernateException ex) {
      System.err.println("Error al obtener movimiento: " + ex.getMessage());
    }
    return m;
  }

  public static boolean guardar(
      Date fecha, float monto, String tipo, String concepto, Cuenta cuenta) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Movimiento m = new Movimiento();
      m.setFecha(fecha);
      m.setMonto(monto);
      m.setTipo(tipo);
      m.setConcepto(concepto);
      session.save(m);
      session.getTransaction().commit();
      resultado = m.getId() != 0;
    } catch (HibernateException ex) {
      System.err.println("Error al guardar movimiento: " + ex.getMessage());
    }
    return resultado;
  }

  public static boolean eliminar(int id) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Movimiento m = (Movimiento) obtenerPorId(id);

      if (m != null) {
        session.delete(m);
        session.getTransaction().commit();
        resultado = m.getId() != 0;
      }

    } catch (HibernateException ex) {
      System.err.println("Error al eliminar movimiento: " + ex.getMessage());
    }
    return resultado;
  }
}
