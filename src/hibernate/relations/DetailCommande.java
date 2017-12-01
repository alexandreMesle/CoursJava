package hibernate.relations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
class DetailCommande implements Comparable<DetailCommande>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	@ManyToOne
	@Cascade(value = { CascadeType.ALL })
	private Commande commande;

	@ManyToOne
	@Cascade(value = { CascadeType.ALL })
	private Produit produit;

	private int quantite;

	@SuppressWarnings("unused")
	private DetailCommande()
	{
	}

	DetailCommande(Commande commande, Produit produit, int quantite)
	{
		this.commande = commande;
		this.produit = produit;
		produit.add(this);
		this.quantite = quantite;
	}

	int getQuantite()
	{
		return quantite;
	}

	Commande getCommande()
	{
		return commande;
	}

	Produit getProduit()
	{
		return produit;
	}

	@Override
	public String toString()
	{
		return "" + quantite + " * " + produit.getNom();
	}

	void delete()
	{
		if (commande != null)
		{
			Commande commande = this.commande;
			this.commande = null;
			commande.remove(this.getProduit());
		}
		if (produit != null)
		{
			Produit produit = this.produit;
			this.produit = null;
			produit.remove(this);
		}
		Passerelle.delete(this);
	}

	@Override
	public int compareTo(DetailCommande autre)
	{
		return this.getProduit().compareTo(autre.getProduit());
	}
}
