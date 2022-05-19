package mx.itson.gagashin.persistencia;

import mx.itson.gagashin.entidades.Movimiento;
import mx.itson.gagashin.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MovimientoDAO {

  public static List<Movimiento> obtenerTodos() {
    List<Movimiento> movimientos = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      CriteriaQuery<Movimiento> criteriaQuery =
          session.getCriteriaBuilder().createQuery(Movimiento.class);
      criteriaQuery.from(Movimiento.class);
      movimientos = session.createQuery(criteriaQuery).getResultList();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return movimientos;
  }

  public static List<Movimiento> obtenerPorId(int idCliente) {
    List<Movimiento> movimientos = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      DetachedCriteria criteria = DetachedCriteria.forClass(Movimiento.class);
      criteria.add(Restrictions.eq("id", idCliente));
      criteria.addOrder(Order.desc("fecha"));
      movimientos = criteria.getExecutableCriteria(session).list();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return movimientos;
  }

  public Collection<String> buscarPorId(int id) {
    DetachedCriteria criteria = DetachedCriteria.forClass(Movimiento.class);
    criteria.add(Restrictions.eq("estado.id", id));
    criteria.addOrder(Order.desc("fecha"));
    return criteria.getExecutableCriteria(HibernateUtil.getSessionFactory().openSession()).list();
  }

  public static boolean guardar(Date fecha, float monto, String tipo, String concepto) {
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
