package recursivite;

public class Liste 
{
	private int valeur;
	private Liste suivant;
	
	public Liste(int valeur, Liste suivant)
	{
		this.valeur = valeur;
		this.suivant = suivant;
	}
	
	public int getValeur()
	{
		return valeur;
	}
	
	public Liste getSuivant()
	{
		return suivant;
	}
	
	public void setValeur(int valeur)
	{
		this.valeur = valeur;
	}
	
	public void setSuivant(Liste suivant)
	{
		this.suivant = suivant;
	}

	@Override
	public String toString()
	{
		String res = "" + getValeur();
		if (getSuivant() != null)
			res += " -> " + getSuivant().toString();
		return res;
	}
	
	public static Liste compteARebours(int n)
	{
		if (n < 0)
			return null;
		return new Liste(n, compteARebours(n - 1));
	}
	
	/**
	 * Recherche x dans la liste.
	 * @return true ssi x est dans la liste
	 */
	
	public boolean recherche(int x)
	{
		return true;
	}
	
	/**
	 * Recherche le plus grand élément de la liste.
	 * @return le plus grand élément de la liste
	 */
	
	public int max()
	{
		return 0;
	}
	
	/**
	 * Calcule la somme des éléments de la liste.
	 * @return la somme des éléments de la liste
	 */
	
	public int somme()
	{
		return 0;
	}
	
	/**
	 * Calcule la somme des éléments de la liste avec une fonction récursive terminale.
	 * @return la somme des éléments de la liste
	 */
	
	public int sommeTerm()
	{
		return sommeAccumulateur(0);
	}

	private int sommeAccumulateur(int accumulateur)
	{
		return 0;
	}

	/** Supprime la tête de la liste
	 * @return la liste sans le premier élément
	 **/
	public Liste pop()
	{
		return null;
	}

	/** Retourne le dernier élément de la liste
	 **/
	public int tail()
	{
		return 0;
	}

	/** 
	 * Ne garde que les éléments pairs
	 * @return la liste sans les éléments impairs
	 **/
	public Liste even()
	{
		return null;
	}

	/** 
	 * Effectue une copie de la liste
	 * @return la copie de la liste
	 **/
	public Liste copie()
	{
		return null;
	}

	/** 
	 * Insère l dans la liste, en supposant qu'elle est triée
	 * @return la liste avec l'élément l
	 **/
	private Liste insere(Liste l)
	{
		return null;
	}

	/**
	 * Effectue un tri par insertion de la liste 
	 * @return la liste triée
	 */
	
	public Liste triInsertion()
	{
		return null;
	}
	
	/**
	 * Inverse l'ordre des éléments de la liste en utilisant un accumulateur
	 * @return la liste dont l'ordre des éléments a été inversé
	 */
	private Liste inverseAcc(Liste accumulateur) {return null;}
	
	public Liste inverse()
	{
		return inverseAcc(null);
	}
	
	public static void main(String[] args) 
	{
		System.out.println(compteARebours(10));
	}

}
