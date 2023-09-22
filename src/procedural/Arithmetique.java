package procedural;

class Arithmetique
{
	/*
	 * Retourne b élevé à la puissance n. 
	 */
	
	static long puissance(long b, int n)
	{
		long res = 1;
		for (int i = 1; i <= n; i++)
			res *= b;
		return res;
	}

	/*
	 * Retourne le chiffre des unités de n
	 */
	
	static int unites(long n)
	{
		return (int) (n % 10);
	}

	/*
	 * Retourne le chiffre des dizaines de n
	 */
	
	static int dizaines(long n)
	{
		return unites(n / 10);
	}
	
	/*
	 * Retourne le p-ème chiffre de n en partant de 
	 * la droite. Le chiffre des unités est à la
	 * position 1.
	 */

	static int extrait(long n, int p)
	{
		return (int)((n % puissance(10, p)) / puissance(10, p - 1));
	}

	/*
	 * Retourne le nombre de chiffres de n.
	 */
	
	public static int nbChiffres(long n)
	{
		int res = 1;
		while (n > 9)
		{
			res++;
			n /= 10;
		}
		return res;
	}

	/*
	 * Retourne la somme des chiffres de n.
	 */
	
	static int sommeChiffres(long n)
	{
		int nbC = nbChiffres(n);
		int somme = 0;
		for (int i = 1; i <= nbC; i++)
			somme += extrait(n, i);
		return somme;
	}

	/*
	 * Retourns vrai ssi a divise b.
	 */
	
	static boolean divise(long a, long b)
	{
		return b % a == 0;
	}

	/*
	 * Retourne la somme des diviseurs de n
	 * (sans compter n).
	 * Par exemple, la somme des diviseurs de 
	 * 6 est 1 + 2 + 3 = 6
	 */
	
	static int sommeDiviseursStricts(long n)
	{
		int somme = 0;
		for (int i = 1; i < n; i++)
			if (divise(i, n))
				somme += i;
		return somme;
	}

	/*
	 * Retourne vrai ssi la somme des diviseurs stricts 
	 * de a est égale à b et la somme des diviseurs stricst 
	 * de b est égale à a. 
	 */
	
	static boolean sontAmis(long a, long b)
	{
		return sommeDiviseursStricts(a) == b && a == sommeDiviseursStricts(b);
	}

	/*
	 * Retourne vrai ssi n est égal à la somme de 
	 * ses diviseurs stricts.
	 */
	
	static boolean estParfait(long n)
	{
		return n == sommeDiviseursStricts(n);
	}

	/*
	 * Retourne la somme 
	 * * du nombre formé par les p derniers chiffres de n  
	 * * et du avec le nombre formé par les autres chiffres
	 * 
	 * Si par exemple n = 494 209 et p = 3
	 * La fonction retourne 494 + 209 = 703 
	 */
	
	static long sommeParties(long n, int p)
	{
		return n % puissance(10, p) + n / puissance(10, p);
	}

	/*
	 * Retourne vrai ssi il est possible de trouver a et b 
	 * tels que 
	 * * a + b = n
	 * * b != 0
	 * * la concaténation de a et b vaut n     
	 */
	
	static boolean estKaprekar(long n)
	{
		long carre = n * n;
		long nbc = nbChiffres(carre);
		for (int i = 1 ; i < nbc ; i++)
			if (n % puissance(10, i) != 0 
				&& sommeParties(carre, i) == n)
				return true;
		return false;
	}
}
