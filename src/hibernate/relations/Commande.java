package hibernate.relations;

import java.util.Date;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.SortNatural;

@Entity
public class Commande implements Comparable<Commande>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private Date date;

	@ManyToOne
	@Cascade(value = { CascadeType.SAVE_UPDATE})
	private Client client;

	@OneToMany(mappedBy = "commande")
	@Cascade(value = { CascadeType.ALL })
	@SortNatural
	@MapKey(name = "produit")
	private SortedMap<Produit, DetailCommande> detailsCommandes = new TreeMap<>();

	@SuppressWarnings("unused")
	private Commande()
	{
	}

	Commande(Client client)
	{
		this.date = new Date();
		this.client = client;
	}

	int getNum()
	{
		return num;
	}
	
	public Client getClient()
	{
		return client;
	}

	public Date getDate()
	{
		return date;
	}

	public void delete()
	{
		client.remove(this);
		Passerelle.delete(this);
	}

	public void save()
	{
		Passerelle.save(this);
	}

	public void add(Produit produit, int quantite)
	{
		detailsCommandes.put(produit, new DetailCommande(this, produit,
				quantite));
	}

	public void remove(Produit produit)
	{
		detailsCommandes.remove(produit);
	}

	public SortedSet<Produit> getProduits()
	{
		return new TreeSet<Produit>(detailsCommandes.keySet());
	}

	SortedSet<DetailCommande> getDetailsCommande()
	{
		return new TreeSet<DetailCommande>(detailsCommandes.values());
	}

	public int getNbProduits()
	{
		return detailsCommandes.size();
	}

	public int getQuantite(Produit produit)
	{
		return detailsCommandes.get(produit).getQuantite();
	}

	@Override
	public String toString()
	{
		String s = client.getNom() + "::" + num + " ";
		for (DetailCommande detailCommande : detailsCommandes.values())
			s += detailCommande + " -> ";
		s += "\n";
		return s;
	}

	@Override
	public int compareTo(Commande autre)
	{
		return getDate().compareTo(autre.getDate());
	}
}
