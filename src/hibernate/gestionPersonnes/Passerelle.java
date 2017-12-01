package hibernate.gestionPersonnes;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

abstract class Passerelle
{
	private static Session session = null;

	static
	{
		SessionFactory sessionFactory = null;
		try
		{
			Configuration configuration = new Configuration()
					.configure("hibernate/hibernateManagePersonne/hibernateManagePersonne.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Probleme de configuration : "
					+ ex.getMessage(), ex);
		}
	}

	static void delete(Personne personne)
	{
		Transaction tx = session.beginTransaction();
		session.delete(personne);
		tx.commit();
	}

	static void save(Personne personne)
	{
		Transaction tx = session.beginTransaction();
		session.save(personne);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	static java.util.List<Personne> refreshList()
	{
		Query query = session.createQuery("from Personne");
		return query.list();
	}
}
