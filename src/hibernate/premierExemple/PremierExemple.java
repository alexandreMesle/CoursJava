package hibernate.premierExemple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Entity
@Table(name = "personne")
class Personne
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num")
	private int num;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	public Personne(String prenom, String nom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}
}

public class PremierExemple
{
	private static Session getSession() throws HibernateException
	{
		Configuration configuration = new Configuration()
				.configure("hibernate/premierExemple/PremierExemple.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}

	public static void main(String[] args)
	{
		try
		{
			Session s = getSession();
			Personne joffrey = new Personne("Joffrey", "Baratheon");
			Transaction t = s.beginTransaction();
			s.persist(joffrey);
			t.commit();
			s.close();
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Probleme de configuration : "
					+ ex.getMessage(), ex);
		}
	}
}
