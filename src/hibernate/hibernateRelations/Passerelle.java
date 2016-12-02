package hibernate.hibernateRelations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Passerelle
{
	private static Session session = null;
	private static SessionFactory sessionFactory = null;
	private static final String CONF_FILE = "hibernate/hibernateRelations/hibernateRelations.cfg.xml";

	static
	{
		try
		{
			Configuration configuration = new Configuration()
					.configure(CONF_FILE);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Probleme de configuration : "
					+ ex.getMessage(), ex);
		}
	}

	public static void open()
	{
		session = sessionFactory.openSession();
	}

	public static void close()
	{
		session.close();
	}

	static void delete(Object o)
	{
		Transaction tx = session.beginTransaction();
		session.delete(o);
		tx.commit();
	}

	static void save(Object o)
	{
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getData(String className)
	{
		Query query = session.createQuery("from " + className);
		return new ArrayList<T>((List<T>) query.list());
	}

	@SuppressWarnings("unchecked")
	public static <T> T getData(String className, int id)
	{
		Query query = session.createQuery("from " + className + " where num = "
				+ id);
		return (T) (query.list().get(0));
	}

	public static int count(String className)
	{
		Query query = session.createQuery("from " + className);
		return query.list().size();
	}

	public static void printAllData()
	{
		System.out.println("****************************");
		System.out.println(Passerelle.getData("Client"));
		System.out.println(Passerelle.getData("Produit"));
		System.out.println(Passerelle.getData("Commande"));
		System.out.println(Passerelle.getData("DetailCommande"));
	}
}
