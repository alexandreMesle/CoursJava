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
	
	static int pgcd(int a, int b)
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
	
	public boolean egale(RationnelVide autre)
	{
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

	public static void main(String[] args)
	{
		RationnelVide a, b;
		a = new RationnelVide();
		b = new RationnelVide();
		a.num = 1;
		a.den = 2;
		b.num = 4;
		b.den = 3;
		System.out.println("a = 1/2 = " + a);
		System.out.println("b = 4/3 = " + b);
		System.out.println("compareTo(" + a + ", " + b + ") = -1 = "
				+ a.compareTo(b));
		System.out.println("1/2 = " + a.copie());
		System.out.println("-1/2 = " + a.oppose());
		System.out.println("11/6 = " + a.plus(b));
		System.out.println("2/3 = " + a.multiplie(b));
		System.out.println("3/8 = " + a.divise(b));
	}
}
