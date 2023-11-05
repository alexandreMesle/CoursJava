package encapsulation.tp.facturesClients.corrige;

import java.util.ArrayList;
import java.util.List;

public class Client
{
	// variables d'instances
	private String nom;
	private List<Facture> factures = new ArrayList<>();
	// variable de classe
	private static List<Client> clients = new ArrayList<>();
	
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */
	
	public Client(String nom)
	{
		clients.add(this);
		this.nom = nom;
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant)
	{
		return createFacture(montant, false);
	}
	
	/**
	 * Retourne une copie de la liste des factures du client. 
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		return new ArrayList<>(factures);
	}
	
	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */
	
	public int sommeMontants()
	{
		int somme = 0;
		for (Facture facture : factures)
			somme += facture.getMontant();
		return somme;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant, boolean reglee)
	{
		Facture facture = new Facture(this, montant, reglee);
		factures.add(facture);
		return facture;
	}	
	
	void remove(Facture facture)
	{
		factures.remove(facture);
	}
	
	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{
		List<Facture> facturesReglees = new ArrayList<>();
		for (Facture facture : factures)
			if(facture.estReglee())
				facturesReglees.add(facture);
		return facturesReglees;
	}
	

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	public static List<Client> tous()
	{
		return new ArrayList<>(clients);
	}
	
	/**
	 * Supprime le client.
	 */
	
	public void delete()
	{
		clients.remove(this);
	}
}
