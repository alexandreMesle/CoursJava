package encapsulation.rationnel;

public class RationnelVide
{
	private int num, den;

	/**
	 * Retourne chaine de la forme num/den 
	 */	

	public String toString()
	{
		return null;
	}

	public RationnelVide(int num, int den)
	{
	}

	/**
	 * Retourne un Rationnel contenant un 1 au dénominateur
	 */
	
	public RationnelVide(int num)
	{
	}

	public int getNum()
	{
		return 0;
	}

	public int getDen()
	{
		return 0;
	}

	public void setNum(int num)
	{
	}

	/**
	 * Setter pour le dénominateur, 
	 * ne fait rien si cela entraîne une division par zéro.
	 */
	
	public void setDen(int den)
	{
	}

	public Rationnel copie()
	{
		return null;
	}

	/**
	 * Retourne le rationnel qu'il faut additioner
	 * à this pour obtenir 0.
	 */
	
	public Rationnel oppose()
	{
		return null;
	}

	/**
	 * Retourne le rationnel par lequel il faut multiplier 
	 * this pour obtenir 1.
	 */

	public Rationnel inverse()
	{
		return null;
	}
	
	/**
	 * Retourne le plus grand commun diviseur de a et b
	 * Utilisez les propriétés suivantes :
	 * pgcd(a, 0) = a
	 * pgcd(a, b) = pgcd(b, a modulo b)
	 */
	
	private static int pgcd(int a, int b)
	{
		return 0;
	}

	/**
	 * Met le rationnel courant sous forme irréductible.
	 * 
	 * Modifier ensuite constructeurs et setters   
	 * pour que les rationnels soient toujours 
	 * sous forme irréductible. 
	 */
	
	private void reduit()
	{
	}

	/**
	 * Retourne vrai ssi le rationnel est positif.
	 */

	public boolean estPositif()
	{
		return true;
	}


	public Rationnel plus(Rationnel other)
	{
		return null;
	}

	public Rationnel moins(Rationnel other)
	{
		return null;
	}
	
	public Rationnel multiplie(Rationnel other)
	{
		return null;
	}

	public Rationnel divise(Rationnel other)
	{
		return null;
	}

	/**
	 * Retourne vrai ssi this 
	 * n'est ni supérieur ni inférieur à autre.
	 */
	
	@Override
	public boolean equals(Object object)
	{
		Rationnel autre = (Rationnel)object;
		return true;
	}	

	/**
	 * Retourne :
	 * 1 si this > autre
	 * 0 si this est égal à autre
	 * -1 si this < autre 
	 */
	
	public int compareTo(Rationnel autre)
	{
		return 0;
	}
}
