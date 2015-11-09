package hibernate.hibernateRelations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Produit implements Comparable<Produit>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private String nom;

	private double prix;

	@OneToMany(mappedBy = "produit")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private Set<DetailCommande> detailsCommandes = new HashSet<>();

	void add(DetailCommande detailCommande)
	{
		detailsCommandes.add(detailCommande);
	}

	void remove(DetailCommande detailCommande)
	{
		detailsCommandes.remove(detailCommande);
	}

	public int getNbCommandes()
	{
		return detailsCommandes.size();
	}

	@SuppressWarnings("unused")
	private Produit()
	{
	}

	public Produit(String nom, double prix)
	{
		this.nom = nom;
		this.prix = prix;
	}

	public String getNom()
	{
		return nom;
	}

	public void delete()
	{
		for (Iterator<DetailCommande> it = detailsCommandes.iterator(); it
				.hasNext();)
		{
			DetailCommande detailCommande = it.next();
			it.remove();
			detailCommande.delete();
		}
		Passerelle.delete(this);
	}

	public void save()
	{
		Passerelle.save(this);
	}

	@Override
	public String toString()
	{
		return nom + "(" + prix + " euros)";
	}

	@Override
	public int compareTo(Produit autre)
	{
		return getNom().compareTo(autre.getNom());
	}
}
