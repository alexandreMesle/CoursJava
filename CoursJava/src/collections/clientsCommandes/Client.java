package collections.clientsCommandes;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class Client
{
	private String nom;
	private Set<Facture> factures = new HashSet<>();

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

	public Set<Facture> getFactures()
	{
		return Collections.unmodifiableSet(factures);
	}

	public static void main(String[] args)
	{
		Client joffrey = new Client("Joffrey");
		Facture bucher = joffrey.createFacture(500), arbalete = joffrey
				.createFacture(50);
		System.out.println(joffrey);
		System.out.println("Montant des factures : ");
		for (Facture f : joffrey.getFactures())
			System.out.println(f.getMontant() + " euros.");
		bucher.delete();
		System.out.println(joffrey);
	}
}
