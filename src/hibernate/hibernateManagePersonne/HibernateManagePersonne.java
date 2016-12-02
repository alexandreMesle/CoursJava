package hibernate.hibernateManagePersonne;

import java.util.List;

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
import org.hibernate.Query;

import utilitaires.EntreesSorties;
import utilitaires.ligneDeCommande.*;

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

	public static void delete(Personne personne)
	{
		Transaction tx = session.beginTransaction();
		session.delete(personne);
		tx.commit();
	}

	public static void save(Personne personne)
	{
		Transaction tx = session.beginTransaction();
		session.save(personne);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	static List<Personne> refreshList()
	{
		Query query = session.createQuery("from Personne");
		return query.list();
	}
}

public abstract class HibernateManagePersonne
{
	private static List<Personne> personnes;;

	private static void refreshList()
	{
		personnes = Passerelle.refreshList();
	}

	private static Option getAfficher()
	{
		return new Option("Afficher", "l", new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				refreshList();
				for (Personne personne : personnes)
					System.out.println(personne);
			}
		});
	}

	private static Option getAjouter()
	{
		return new Option("Ajouter", "a", new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				Passerelle.save(new Personne(EntreesSorties
						.getString("Prénom : "), EntreesSorties
						.getString("Nom : ")));
				refreshList();
			}
		});
	}

	private static Option getSupprimer()
	{
		Liste<Personne> supprimer = new Liste<>("Supprimer", "s",
				new ActionListe<Personne>()
				{
					@Override
					public void elementSelectionne(int indice, Personne element)
					{
						Passerelle.delete(element);
						refreshList();
					}

					@Override
					public List<Personne> getListe()
					{
						return personnes;
					}
				});
		return supprimer;
	}

	private static Option getModifier()
	{
		Liste<Personne> modifier = new Liste<>("Modifier", "m",
				new ActionListe<Personne>()
				{
					@Override
					public void elementSelectionne(int indice, Personne element)
					{
						element.setPrenom(EntreesSorties
								.getString("Prénom : "));
						element.setNom(EntreesSorties.getString("Nom : "));
						Passerelle.save(element);
					}

					@Override
					public List<Personne> getListe()
					{
						return personnes;
					}
				});
		return modifier;
	}

	private static Menu menuPrincipal()
	{
		Menu menu = new Menu("Gestionnaire de contacts");
		menu.ajoute(getAfficher());
		menu.ajoute(getAjouter());
		menu.ajoute(getSupprimer());
		menu.ajoute(getModifier());
		menu.ajouteQuitter("q");
		return menu;
	}

	public static void main(String[] args)
	{
		menuPrincipal().start();
	}
}
