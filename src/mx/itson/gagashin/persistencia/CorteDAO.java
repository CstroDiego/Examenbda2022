package mx.itson.gagashin.persistencia;

import mx.itson.gagashin.entidades.Movimiento;
import mx.itson.gagashin.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class CorteDAO {
  public static List<Movimiento> obtenerPorId(int idCliente) {
    List<Movimiento> movimientos = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      DetachedCriteria criteria = DetachedCriteria.forClass(Movimiento.class);
      criteria.add(Restrictions.eq("idCliente", idCliente));
      criteria.addOrder(Order.desc("fecha"));
      movimientos = criteria.getExecutableCriteria(session).list();
    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return movimientos;
  }
}
