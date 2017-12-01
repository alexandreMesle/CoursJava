package hibernate.relations;

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

class Passerelle
{
	private static Session session = null;
	private static SessionFactory sessionFactory = null;
	private static final String CONF_FILE = "hibernate/relations/relations.cfg.xml";
	private static Transaction transaction = null;
	
	static void initHibernate()
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
		if (sessionFactory == null)
			initHibernate();
		if (!isOpened())
			session = sessionFactory.openSession();
	}

	public static boolean isOpened()
	{
		return session != null && session.isOpen();
	}
	
	public static void close()
	{
		if (isOpened())
			session.close();
	}

	static void delete(Object o)
	{
		transaction = session.beginTransaction();
		session.delete(o);
		transaction.commit();
		transaction = null;
		session.flush();
	}

	static void save(Object o)
	{
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();
		session.flush();
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
}
