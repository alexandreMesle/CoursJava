package exceptions.rationel;

public class Rationnel
{
	@SuppressWarnings("serial")
	public static class CannotSetZeroToDenominator 
		extends RuntimeException {}

	private int num, den;

	/**
	 * Retourne chaine de la forme num/den 
	 */	

	public String toString()
	{
		return getNum() + "/" + getDen();
	}

	public Rationnel(int num, int den)
	{
		this.num = num;
		this.setDen(den);
		this.reduit();
	}

	/**
	 * Retourne un Rationnel contenant un 1 au dénominateur
	 */
	
	public Rationnel(int num)
	{
		this(num, 1);
	}

	public int getNum()
	{
		return num;
	}

	public int getDen()
	{
		return den;
	}

	public void setNum(int num)
	{
		this.num = num;
		this.reduit();
	}

	/**
	 * Setter pour le dénominateur, 
	 * ne fait rien si cela entraîne une division par zéro.
	 */
	
	public void setDen(int den)
	{
		if (den != 0)
		{
			this.den = den;
			this.reduit();
		}
		else
			throw new CannotSetZeroToDenominator();
	}

	public Rationnel copie()
	{
		return new Rationnel(getNum(), getDen());
	}

	/**
	 * Retourne le rationnel qu'il faut additioner
	 * à this pour obtenir 0.
	 */
	
	public Rationnel oppose()
	{
		return new Rationnel(-getNum(), getDen());
	}

	/**
	 * Retourne le rationnel par lequel il faut multiplier 
	 * this pour obtenir 1.
	 */

	public Rationnel inverse()
	{
		return new Rationnel(getDen(), getNum());
	}
	
	/**
	 * Retourne le plus grand commun diviseur de a et b
	 * Utilisez les propriétés suivantes :
	 * pgcd(a, 0) = a
	 * pgcd(a, b) = pgcd(b, a modulo b)
	 */
	
	private static int pgcd(int a, int b)
	{
		if (b == 0)
			return a;
		return pgcd(b, a % b);
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
		int p = pgcd(getNum(), getDen());
		num = getNum() / p;
		den = getDen() / p;
	}

	/**
	 * Retourne vrai ssi le rationnel est positif.
	 */

	public boolean estPositif()
	{
		return getNum() * getDen() >= 0;
	}


	public Rationnel plus(Rationnel other)
	{
		return new Rationnel(getNum() * other.getDen() + getDen()
				* other.getNum(), getDen() * other.getDen());
	}

	public Rationnel moins(Rationnel other)
	{
		return plus(other.oppose());
	}
	
	public Rationnel multiplie(Rationnel other)
	{
		return new Rationnel(getNum() * other.getNum(), 
				getDen() * other.getDen());
	}

	public Rationnel divise(Rationnel other)
	{
		return multiplie(other.inverse());
	}

	/**
	 * Retourne vrai ssi this 
	 * n'est ni supérieur ni inférieur à autre.
	 */
	
	@Override
	public boolean equals(Object object)
	{
		Rationnel autre = (Rationnel)object;
		return getNum() * autre.getDen() == getDen() * autre.getNum();
	}	

	/**
	 * Retourne :
	 * 1 si this > autre
	 * 0 si this est égal à autre
	 * -1 si this < autre 
	 */
	
	public int compareTo(Rationnel autre)
	{
		if (equals(autre))
			return 0;
		if (moins(autre).estPositif())
			return 1;
		else
			return -1;
	}
}
