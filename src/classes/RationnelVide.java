package classes;

public class RationnelVide
{
	public int num, den;

	/**
	 * Retourne chaine de la forme num/den 
	 */
	
	public String toString()
	{
		return null;
	}
	
	static RationnelVide cree(int num, int den)
	{
		return null;
	}
	
	public RationnelVide copie()
	{
		return null;
	}

	/**
	 * Retourne le rationnel qu'il faut additioner
	 * à this pour obtenir 0.
	 */
	
	public RationnelVide oppose()
	{
		return null;
	}

	/**
	 * Retourne le rationnel par lequel il faut multiplier 
	 * this pour obtenir 1.
	 */
	public RationnelVide inverse()
	{
		return null;
	}

	/**
	 * Retourne le plus grand commun diviseur de a et b
	 * Utilisez les propriétés suivantes :
	 * pgcd(a, 0) = a
	 * pgcd(a, b) = pgcd(b, a modulo b)
	 * 
	 *  Modifier ensuite la méthode "cree(int, int)" 
	 *  pour que les rationnels soient toujours créés 
	 *  sous forme irréductible. 
	 */
	
	public static int pgcd(int a, int b)
	{
		return 0;
	}

	/**
	 * Retourne vrai ssi le rationnel est positif.
	 */
	public boolean estPositif()
	{
		return true;
	}

	public RationnelVide plus(RationnelVide autre)
	{
		return null;
	}

	public RationnelVide moins(RationnelVide autre)
	{
		return null;
	}

	public RationnelVide multiplie(RationnelVide autre)
	{
		return null;
	}

	public RationnelVide divise(RationnelVide autre)
	{
		return null;
	}

	/**
	 * Retourne vrai ssi this - autre vaut zéro.
	 */
	
	@Override
	public boolean equals(Object object)
	{
		RationnelVide autre = (RationnelVide)object;
		return true;
	}
	
	/**
	 * Retourne :
	 * 1 si this > autre
	 * 0 si this est égal à autre
	 * -1 si this < autre 
	 */
	
	public int compareTo(RationnelVide autre)
	{
		return 0;
	}
}
