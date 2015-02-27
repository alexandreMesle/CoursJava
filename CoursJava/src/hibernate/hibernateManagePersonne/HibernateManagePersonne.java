package hibernate.hibernateManagePersonne;


import java.util.ArrayList;
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

@Entity
class Personne
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int num;

	private String nom;
	
	private String prenom;

	Personne(){}
	
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
			Configuration configuration = new Configuration().
					configure("hibernate/hibernateManagePersonne/hibernateManagePersonne.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties()).build();
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
		return new ArrayList<Personne>((List<Personne>)query.list());
	}
}

public abstract class HibernateManagePersonne
{
	private static List<Personne> personnes;
	
	private final static int SUPPRIMER = 1, MODIFIER = 2, 
			AJOUTER = 3, QUITTER = 4;
	
	private static void refreshList()
	{
		personnes = Passerelle.refreshList();
	}

	public static void print()
	{
		int i = 1;
		refreshList();
		for (Personne personne : personnes)
			System.out.println(i++ + " : " + personne);
	}
	
	public static int chooseOption()
	{
		print();
		String msg = "* " + SUPPRIMER + " pour supprimer\n"
			+ "* " + MODIFIER + " pour modifier\n"
			+ "* " + AJOUTER + " pour ajouter\n"
			+ "* " + QUITTER + " pour quitter\n";
		return EntreesSorties.getInt(msg);
	}
			
	public static void go()
	{
		int option;
		while((option = chooseOption()) != QUITTER)
		{
			switch(option)
			{
				case AJOUTER : add() ; break;
				case SUPPRIMER : delete() ; break;
				case MODIFIER : update() ; break;
			}
		}
	}

	public static void delete()
	{
		int index = EntreesSorties.getInt("Indice : ");
		Personne personne = personnes.get(index - 1);
		Passerelle.delete(personne);
	}
	
	public static void update()
	{
		int index = EntreesSorties.getInt("Indice : ");
		Personne personne = personnes.get(index - 1);
		personne.setPrenom(EntreesSorties.getString("Prénom : "));
		personne.setNom(EntreesSorties.getString("Nom : "));
		Passerelle.save(personne);
	}
	
	public static void add()
	{
		Personne personne = new Personne(
				EntreesSorties.getString("Prénom : "), 
				EntreesSorties.getString("Nom : "));
		Passerelle.save(personne);
	}
	
	public static void main(String[] args)
	{
		go();
	}
}
