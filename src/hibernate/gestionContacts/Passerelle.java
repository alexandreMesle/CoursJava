package hibernate.gestionContacts;

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
					.configure("hibernate/gestionContacts/GestionContacts.cfg.xml");
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

	static void delete(Contact personne)
	{
		Transaction tx = session.beginTransaction();
		session.delete(personne);
		tx.commit();
	}

	static void save(Contact personne)
	{
		Transaction tx = session.beginTransaction();
		session.save(personne);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	static java.util.List<Contact> refreshList()
	{
		Query query = session.createQuery("from Contact");
		return query.list();
	}
}
