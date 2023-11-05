package encapsulation.tp.facturesClients.corrige;

import java.time.LocalDate;

public class Facture
{
	private Client client;
	private int montant;
	private boolean reglee;
	private LocalDate date = LocalDate.now();
	
	Facture(Client client, int montant, boolean reglee)
	{
		if (montant <= 0)
			throw new IllegalArgumentException("Le montant d'une facture ne peut pas être négatif.");
		this.montant = montant;
		this.client = client;
		this.reglee = reglee;
	}
	
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */		
	
	public Client getClient()
	{
		return client;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */
	
	public int getMontant()
	{
		return montant;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */
	
	public boolean estReglee()
	{
		return reglee; 
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */
	
	public LocalDate getDate()
	{
		return date;
	}

	/**
	 * Supprime la facture
	 */
	
	public void delete()
	{
		getClient().remove(this);
	}
	
	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */
	
	public Facture copie()
	{
		return getClient().createFacture(getMontant(), estReglee());
	}
}