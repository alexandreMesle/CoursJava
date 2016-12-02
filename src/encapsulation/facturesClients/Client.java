package encapsulation.facturesClients;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Client
{
	private String nom;
	private ArrayList<Facture> factures = new ArrayList<>();

	public Client(String nom)
	{
		this.nom = nom;
	}

	@Override
	public String toString()
	{
		return nom + " : " + factures.toString();
	}

	public Facture createFacture(int montant)
	{
		Facture facture = new Facture(this, montant);
		add(facture);
		return facture;
	}

	void add(Facture commande)
	{
		factures.add(commande);
	}

	void remove(Facture commande)
	{
		factures.remove(commande);
	}

	public List<Facture> getFactures()
	{
		return Collections.unmodifiableList(factures);
	}

	public static void main(String[] args)
	{
		Client joffrey = new Client("Joffrey");
		Facture bucher = joffrey.createFacture(500), 
				arbalete = joffrey.createFacture(50);
		System.out.println(joffrey);
		System.out.println("Montant des factures : ");
		for (Facture f : joffrey.getFactures())
			System.out.println(f.getMontant() + " euros.");
		bucher.delete();
		System.out.println(joffrey);
	}
}
