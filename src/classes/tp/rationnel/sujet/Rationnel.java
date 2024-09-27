package classes.tp.rationnel.sujet;

public class Rationnel
{
	public int num, den;

	/**
	 * Retourne une chaine de la forme num/den 
	 */
	
	public String toString()
	{
		return null;
	}
	
	static Rationnel cree(int num, int den)
	{
		return null;
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
	 * Retourne vrai ssi le rationnel est positif ou nul.
	 */
	public boolean estPositif()
	{
		return true;
	}

	public Rationnel plus(Rationnel autre)
	{
		return null;
	}

	public Rationnel moins(Rationnel autre)
	{
		return null;
	}

	public Rationnel multiplie(Rationnel autre)
	{
		return null;
	}

	public Rationnel divise(Rationnel autre)
	{
		return null;
	}

	/**
	 * Retourne vrai ssi this - autre vaut zéro.
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
