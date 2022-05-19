package mx.itson.gagashin.utilerias;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 *
 * @author Diego Castro Arce
 */
public class HibernateUtil {
  private static SessionFactory factory;
  private static ServiceRegistry serviceRegistry;

  static {
    try {
      Configuration configuration = new Configuration();
      configuration.configure();
      factory = configuration.buildSessionFactory();
    } catch (HibernateException ex) {
      System.out.println("No se pudo crear la sesión de Hibernate debido al error: " + ex);
    }
  }

  /**
   * Gets session factory.
   *
   * @return the session factory
   */
  public static SessionFactory getSessionFactory() {
    return factory;
  }

  /**
   * Sets session factory.
   *
   * @param factory the factory
   */
  public static void setSessionFactory(SessionFactory factory) {
    HibernateUtil.factory = factory;
  }

  /**
   * Gets service registry.
   *
   * @return the service registry
   */
  public static ServiceRegistry getServiceRegistry() {
    return serviceRegistry;
  }

  /**
   * Sets service registry.
   *
   * @param serviceRegistry the service registry
   */
  public static void setServiceRegistry(ServiceRegistry serviceRegistry) {
    HibernateUtil.serviceRegistry = serviceRegistry;
  }
}
