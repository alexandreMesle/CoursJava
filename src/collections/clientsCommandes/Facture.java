package collections.clientsCommandes;

import java.time.LocalDate;

public class Facture
{
	private Client client;
	private int montant;
	private LocalDate date;

	Facture(Client client, int montant)
	{
		this.client = client;
		this.montant = montant;
		this.date = LocalDate.now();
	}

	public Client getClient()
	{
		return client;
	}

	public int getMontant()
	{
		return montant;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void delete()
	{
		client.remove(this);
	}

	@Override
	public String toString()
	{
		return "date = " + date.toString() + ", montant = " + montant
				+ " euros";
	}
}