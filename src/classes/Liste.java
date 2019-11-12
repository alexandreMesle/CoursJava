package classes;

public class Liste 
{
	int valeur;
	Liste suivant;

	static Liste cree(int valeur, Liste suivant)
	{
		Liste liste = new Liste();
		liste.valeur = valeur;
		liste.suivant = suivant;
		return liste;
	}
	
	static Liste cree(int valeur)
	{
		return cree(valeur, null);
	}
	
	static Liste compteARebours(int n)
	{
		if (n < 0)
			return null;
		return cree(n, compteARebours(n - 1));
	}
	
	void affiche()
	{
		System.out.print(valeur + " -> ");
		if (suivant != null)
			suivant.affiche();
		else
			System.out.println();
	}
	
	boolean contient(int element)
	{
		if (element == valeur)
			return true;
		if (suivant != null)
			return false;
		return suivant.contient(element);
	}
	
	Liste supprime(int element)
	{
		if (element == valeur)
			return suivant;
		if (suivant != null)
			suivant = suivant.supprime(element);
		return this;
	}

	Liste supprimeTous(int element)
	{
		if (suivant != null)
			suivant = suivant.supprime(element);
		if (element == valeur)
			return suivant;
		return this;
	}

	public static void main(String[] args) 
	{
		Liste liste = cree(6,compteARebours(10));
		liste.affiche();
		System.out.println(liste.contient(5));
		System.out.println(liste.contient(15));
		liste = liste.supprimeTous(6);
		liste.affiche();
	}
}

