package hibernate.hibernateManagePersonne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;

import org.hibernate.Query;

@Entity
class Personne
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private String nom;

	private String prenom;

	Personne()
	{
	}

	public Personne(String prenom, String nom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}

	int getNum()
	{
		return num;
	}

	void setNum(int num)
	{
		this.num = num;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	@Override
	public String toString()
	{
		return prenom + " " + nom;
	}
}

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

public abstract class HibernateManagePersonne
{
	private static java.util.List<Personne> personnes;;

	private static void refreshList()
	{
		personnes = Passerelle.refreshList();
	}

	private static Option getAfficher()
	{
		return new Option("Afficher", "l", 
				() -> 
				{
					refreshList();
					for (Personne personne : personnes)
						System.out.println(personne);
				}
			);
	}

	private static Option getAjouter()
	{
		return new Option("Ajouter", "a", 
				() -> 
				{
					Passerelle.save(new Personne(InOut
						.getString("Prénom : "), InOut
						.getString("Nom : ")));
					refreshList();
				}
			);
	}

	private static Option getSupprimer()
	{
		return new List<>("Supprimer", "s",
				() -> personnes,
				(indice, element) -> 
					{
						Passerelle.delete(element);
						refreshList();
					}
				);
	}

	private static Option getModifier()
	{
		return new List<>("Modifier", "m",
				() -> personnes,
				(indice, element) -> 
					{
						element.setPrenom(InOut
								.getString("Prénom : "));
						element.setNom(InOut.getString("Nom : "));
						Passerelle.save(element);
					}
				);
	}

	private static Menu menuPrincipal()
	{
		Menu menu = new Menu("Gestionnaire de contacts");
		menu.add(getAfficher());
		menu.add(getAjouter());
		menu.add(getSupprimer());
		menu.add(getModifier());
		menu.addQuit("q");
		return menu;
	}

	public static void main(String[] args)
	{
		menuPrincipal().start();
	}
}
