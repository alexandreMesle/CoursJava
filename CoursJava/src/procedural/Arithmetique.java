package procedural;

class Arithmetique
{
	static int puissance(int b, int n)
	{
		int res = 1;
		for (int i = 1; i <= n; i++)
			res *= b;
		return res;
	}

	static int unites(int n)
	{
		return n % 10;
	}

	static int dizaines(int n)
	{
		return (n % 100) / 10;
	}

	static int extrait(int n, int p)
	{
		return (n % puissance(10, p)) / puissance(10, p - 1);
	}

	public static int nbChiffres(int n)
	{
		int res = 0;
		while (n != 0)
		{
			res++;
			n /= 10;
		}
		return res;
	}

	static int sommeChiffres(int n)
	{
		int nbC = nbChiffres(n);
		int somme = 0;
		for (int i = 1; i <= nbC; i++)
			somme += extrait(n, i);
		return somme;
	}

	static boolean divise(int a, int b)
	{
		return b % a == 0;
	}

	static int sommeDiviseursStricts(int n)
	{
		int somme = 0;
		for (int i = 1; i < n; i++)
			if (divise(i, n))
				somme += i;
		return somme;
	}

	static boolean sontAmis(int a, int b)
	{
		return sommeDiviseursStricts(a) == b && a == sommeDiviseursStricts(b);
	}

	static boolean estParfait(int n)
	{
		return n == sommeDiviseursStricts(n);
	}

	static int sommeParties(int n, int p)
	{
		return n % puissance(10, p) + n / puissance(10, p);
	}

	static boolean estKaprekar(int n)
	{
		int carre = n * n;
		int nbc = nbChiffres(n * n);
		for (int i = 1; i < nbc; i++)
			if (sommeParties(carre, i) == n)
				return true;
		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(estKaprekar(3456789));
		System.out.println(estKaprekar(45));
		System.out.println(estKaprekar(4879));
	}
}
