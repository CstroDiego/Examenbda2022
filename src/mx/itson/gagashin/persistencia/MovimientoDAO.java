package mx.itson.gagashin.persistencia;

import mx.itson.gagashin.entidades.Movimiento;
import mx.itson.gagashin.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;

import java.util.List;

public class MovimientoDAO {

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

  public static List<Movimiento> obtenerPorFecha(int periodo, int idCliente) {
    List<Movimiento> movimientos = new ArrayList<>();
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      switch (periodo) {
        case 1:
          String enero =
              "select * from movimientos where fecha like '%-01-%' and idCliente = " + idCliente;
          Query queryEnero = session.createSQLQuery(enero);
          ((NativeQuery<?>) queryEnero).addEntity(Movimiento.class);
          movimientos = queryEnero.list();

          break;
        case 2:
          String febrero =
              "select * from movimientos where fecha like '%-02-%' and idCliente = " + idCliente;
          Query queryFebrero = session.createSQLQuery(febrero);
          ((NativeQuery<?>) queryFebrero).addEntity(Movimiento.class);
          movimientos = queryFebrero.list();

          break;
        case 3:
          String marzo =
              "select * from movimientos where fecha like '%-03-%' and idCliente = " + idCliente;
          Query queryMarzo = session.createSQLQuery(marzo);
          ((NativeQuery<?>) queryMarzo).addEntity(Movimiento.class);
          movimientos = queryMarzo.list();

          break;
        case 4:
          String abril =
              "select * from movimientos where fecha like '%-04-%' and idCliente = " + idCliente;
          Query queryAbril = session.createSQLQuery(abril);
          ((NativeQuery<?>) queryAbril).addEntity(Movimiento.class);
          movimientos = queryAbril.list();

          break;
        case 5:
          String mayo =
              "select * from movimientos where fecha like '%-05-%' and idCliente = " + idCliente;
          Query queryMayo = session.createSQLQuery(mayo);
          ((NativeQuery<?>) queryMayo).addEntity(Movimiento.class);
          movimientos = queryMayo.list();

          break;
        case 6:
          String junio =
              "select * from movimientos where fecha like '%-06-%' and idCliente = " + idCliente;
          Query queryJunio = session.createSQLQuery(junio);
          ((NativeQuery<?>) queryJunio).addEntity(Movimiento.class);
          movimientos = queryJunio.list();

          break;
        case 7:
          String julio =
              "select * from movimientos where fecha like '%-07-%' and idCliente = " + idCliente;
          Query queryJulio = session.createSQLQuery(julio);
          ((NativeQuery<?>) queryJulio).addEntity(Movimiento.class);
          movimientos = queryJulio.list();

          break;
        case 8:
          String agosto =
              "select * from movimientos where fecha like '%-08-%' and idCliente = " + idCliente;
          Query queryAgosto = session.createSQLQuery(agosto);
          ((NativeQuery<?>) queryAgosto).addEntity(Movimiento.class);
          movimientos = queryAgosto.list();

          break;
        case 9:
          String septiembre =
              "select * from movimientos where fecha like '%-09-%' and idCliente = " + idCliente;
          Query querySeptiembre = session.createSQLQuery(septiembre);
          ((NativeQuery<?>) querySeptiembre).addEntity(Movimiento.class);
          movimientos = querySeptiembre.list();

          break;
        case 10:
          String octubre =
              "select * from movimientos where fecha like '%-10-%' and idCliente = " + idCliente;
          Query queryOctubre = session.createSQLQuery(octubre);
          ((NativeQuery<?>) queryOctubre).addEntity(Movimiento.class);
          movimientos = queryOctubre.list();

          break;
        case 11:
          String noviembre =
              "select * from movimientos where fecha like '%-11-%' and idCliente = " + idCliente;
          Query queryNoviembre = session.createSQLQuery(noviembre);
          ((NativeQuery<?>) queryNoviembre).addEntity(Movimiento.class);
          movimientos = queryNoviembre.list();

          break;
        case 12:
          String diciembre =
              "select * from movimientos where fecha like '%-12-%' and idCliente = " + idCliente;
          Query queryDiciembre = session.createSQLQuery(diciembre);
          ((NativeQuery<?>) queryDiciembre).addEntity(Movimiento.class);
          movimientos = queryDiciembre.list();

          break;
      }

    } catch (HibernateException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return movimientos;
  }

  public static boolean guardar(
      String fecha, String monto, String tipo, String concepto, int idCliente) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Movimiento m = new Movimiento();
      m.setIdCliente(idCliente);
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

  public static boolean editar(
      int id, String fecha, String monto, String tipo, String concepto, int idCliente) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Movimiento m = new Movimiento();
      m.setId(id);
      m.setIdCliente(idCliente);
      m.setFecha(fecha);
      m.setMonto(monto);
      m.setTipo(tipo);
      m.setConcepto(concepto);
      session.update(m);
      session.getTransaction().commit();
      resultado = m.getId() != 0;
    } catch (HibernateException ex) {
      System.err.println("Error al actualizar movimiento: " + ex.getMessage());
    }
    return resultado;
  }

  public static Movimiento eliminarPorId(int id) {
    Movimiento m = null;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      m = session.get(Movimiento.class, id);
    } catch (HibernateException ex) {
      System.err.println("Error al obtener movimientos: " + ex.getMessage());
    }
    return m;
  }

  public static boolean eliminar(int id) {
    boolean resultado = false;
    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      Movimiento m = eliminarPorId(id);

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
