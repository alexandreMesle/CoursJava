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

	private static int pgcd(int a, int b)
	{
		if (b == 0)
			return a;
		return pgcd(b, a % b);
	}

	public boolean estPositif()
	{
		return num > 0 && den > 0 || num < 0 && den < 0;
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

	public boolean egale(Rationnel autre)
	{
		return num * autre.den == den * autre.num;
	}
	
	public int compareTo(Rationnel autre)
	{
		if (egale(autre))
			return 0;
		if (moins(autre).estPositif())
			return 1;
		else
			return -1;
	}

	public static void main(String[] args)
	{
		Rationnel a, b;
		a = new Rationnel();
		b = new Rationnel();
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
