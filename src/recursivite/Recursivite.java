package recursivite;

public class Recursivite 
{
	
	public static void compteARebours(int n)
	{
		if (n >= 0)
		{
			System.out.println(n);
			compteARebours(n - 1);
		}		
	}
	
	/* S_n = 1 + 2 + 3 + ... + n
	 * S_n = [1 + 2 + 3 + ... + (n-1)] + n
	 * S_n = S_(n-1) + n
	 */
	public static int serieArithmetique(int n)
	{
		if (n == 0)
			return 0;
		return serieArithmetique(n - 1) + n;
	}

	public static int serieArithmetiqueTerm(int n, int acc)
	{
		if (n == 0)
			return acc;
		return serieArithmetiqueTerm(n - 1, acc + n);
	}

	public static int serieArithmetiqueBis(int n)
	{
		return serieArithmetiqueTerm(n, 0);
	}

	/* n! = 1 * 2 * 3 * ... * n 
	 * n! = [1 * 2 * 3 * ... * (n-1)] * n
	 * n! = (n - 1)! * n
	 * */
	public static int factorielle(int n)
	{
		if (n == 0)
			return 1;
		return factorielle(n - 1) * n;

	}

	/* b^n 
	 * avec 
	 * b^n = b^(n-1) * b
	 * et 
	 * b^(2n) = (b*b)^n */
	public static int puissance(int b, int n)
	{
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return puissance(b * b, n / 2);
		return puissance(b, n - 1) * b;
	}

	/* sommeChiffres(12345) = 1 + 2 + 3 + 4 + 5 */
	public static int sommeChiffres(int n){return 0;}

	/* Shadows of the Knight episode 1 */

	public static void main(String[] args) 
	{
		compteARebours(1000);
	}

}

