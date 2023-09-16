package classes;

public class Rationnel
{
	public int num, den;

	public String toString()
	{
		return num + "/" + den;
	}

	static Rationnel cree(int num, int den)
	{
		Rationnel r = new Rationnel();
		int p = pgcd(num, den);
		r.num = num/p;
		r.den = den/p;
		return r;
	}
	
	public Rationnel copie()
	{
		return cree(num, den);
	}

	public Rationnel oppose()
	{
		return cree(-num, den);
	}

	public Rationnel inverse()
	{
		return cree(den, num);
	}

	public static int pgcd(int a, int b)
	{
		if (b == 0)
			return a;
		return pgcd(b, a % b);
	}

	public boolean estPositif()
	{
		return num >= 0 && den > 0 || num <= 0 && den < 0;
	}

	public Rationnel plus(Rationnel autre)
	{
		return  cree(num * autre.den + den * autre.num, autre.den = den * autre.den);
	}

	public Rationnel moins(Rationnel autre)
	{
		return plus(autre.oppose());
	}

	public Rationnel multiplie(Rationnel autre)
	{
		return cree(num * autre.num, den * autre.den);
	}

	public Rationnel divise(Rationnel autre)
	{
		return multiplie(autre.inverse());
	}

	@Override
	public boolean equals(Object object)
	{
		Rationnel autre = (Rationnel)object;
		return num * autre.den == den * autre.num;
	}
	
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
