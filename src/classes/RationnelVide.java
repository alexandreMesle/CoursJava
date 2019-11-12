package classes;

public class RationnelVide
{
	public int num, den;

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

	public RationnelVide oppose()
	{
		return null;
	}

	public RationnelVide inverse()
	{
		return null;
	}

	private static int pgcd(int a, int b)
	{
		return 0;
	}

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

	public boolean egale(RationnelVide autre)
	{
		return true;
	}
	
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
