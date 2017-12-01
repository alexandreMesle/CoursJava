package hibernate.relations;

import java.util.Collections;
import java.util.TreeSet;
import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SortNatural;

@Entity
public class Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private String nom;

	@OneToMany(mappedBy = "client")
	@Cascade(value = { CascadeType.ALL })
	@SortNatural
	private SortedSet<Commande> commandes = new TreeSet<>();

	@SuppressWarnings("unused")
	private Client()
	{
	}

	public Client(String nom)
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	int getNum()
	{
		return num;
	}
	
	public void delete()
	{
		Passerelle.delete(this);
	}

	public void save()
	{
		Passerelle.save(this);
	}

	@Override
	public String toString()
	{
		return nom + "(" + getCommandes().size() + " commande(s))";
	}

	public Commande createCommande()
	{
		Commande commande = new Commande(this);
		commandes.add(commande);
		return commande;
	}

	void remove(Commande commande)
	{
		commandes.remove(commande);
	}

	public SortedSet<Commande> getCommandes()
	{
		return Collections.unmodifiableSortedSet(commandes);
	}
}
