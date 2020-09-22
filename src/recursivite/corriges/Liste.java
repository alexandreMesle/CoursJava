package recursivite.corriges;

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
		if (getValeur() == x)
			return true;
		if (getSuivant() == null)
			return false;
		return getSuivant().recherche(x);
	}
	
	/**
	 * Recherche le plus grand élément de la liste.
	 * @return le plus grand élément de la liste
	 */
	
	private static int max (int x, int y)
	{
		return (x < y) ? y : x; 
	}
	
	public int max()
	{
		if (getSuivant() == null)
			return getValeur();
		return max(getValeur(), getSuivant().max());
	}
	
	/**
	 * Calcule la somme des éléments de la liste.
	 * @return la somme des éléments de la liste
	 */
	
	public int somme()
	{
		if (getSuivant() == null)
			return getValeur();
		return getValeur() + getSuivant().somme();
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
		if (getSuivant() == null)
			return accumulateur + getValeur();
		return getSuivant().sommeAccumulateur(getValeur() + accumulateur);
	}

	/** Supprime la tête de la liste
	 * @return la liste sans le premier élément
	 **/
	public Liste deuxieme()
	{
		return getSuivant();
	}

	/** Retourne le dernier élément de la liste
	 **/
	public int dernier()
	{
		if (getSuivant() == null)
			return getValeur();
		return getSuivant().dernier();
	}

	/** 
	 * Ne garde que les éléments pairs, supprime les éléments pairs.
	 * @return la liste sans les éléments impairs
	 **/
	public Liste pairs()
	{
		if (getSuivant() != null)
			setSuivant(getSuivant().pairs());
		if (getValeur() % 2 == 0)
			return this;
		else
			return getSuivant();
	}

	/** 
	 * Effectue une copie de la liste
	 * @return la copie de la liste
	 **/
	public Liste copie()
	{
		return new Liste(getValeur(), 
			(getSuivant() != null) ? getSuivant().copie() : null
			);
	}

	/** 
	 * Insère l dans la liste, en supposant qu'elle est triée
	 * @return la liste avec l'élément l
	 **/
	private Liste insere(Liste l)
	{
		if (l.getValeur() < getValeur())
		{
			l.setSuivant(this);
			return l;
		}
		if (getSuivant() == null)
		{
			setSuivant(l);
			l.setSuivant(null);
			return this;
		}
		setSuivant(getSuivant().insere(l));
		return this;
	}

	/**
	 * Effectue un tri par insertion de la liste 
	 * @return la liste triée
	 */
	
	private Liste triInsertionAccumulateur(Liste accumulateur)
	{
		Liste suivant = getSuivant();
		this.setSuivant(null);
		if (accumulateur == null)
			accumulateur = this;
		else
			accumulateur = accumulateur.insere(this);
		if (suivant == null)	
			return accumulateur;
		else
			return suivant.triInsertionAccumulateur(accumulateur);
	}
	
	public Liste triInsertion()
	{
		return triInsertionAccumulateur(null);
	}
	
	/**
	 * Inverse l'ordre des éléments de la liste en utilisant un accumulateur
	 * @return la liste dont l'ordre des éléments a été inversé
	 */
	private Liste inverseAcc(Liste accumulateur) 
	{
		Liste suivant = getSuivant();
		setSuivant(accumulateur);
		accumulateur = this;
		if (suivant == null)
			return accumulateur;
		else
			return suivant.inverseAcc(accumulateur);
	}
	
	public Liste inverse()
	{
		return inverseAcc(null);
	}
	
	public static void main(String[] args) 
	{
		Liste car = compteARebours(10);
		System.out.println(car);					
		car = car.triInsertion();
		System.out.println(car);					
	}

}
