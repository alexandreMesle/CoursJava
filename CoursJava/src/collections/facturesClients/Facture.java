package collections.facturesClients;

import java.util.Date;

public class Facture
{
	private Client client;
	private int montant;
	private Date date;
	
	Facture(Client client, int montant)
	{
		this.client = client;
		this.montant = montant;
		this.date = new Date();
	}
	
	public Client getClient()
	{
		return client;
	}
	
	public int getMontant()
	{
		return montant;
	}
	
	public Date getDate()
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
		return "date = " + date.toString() + ", montant = " + montant + " euros";
	}
}