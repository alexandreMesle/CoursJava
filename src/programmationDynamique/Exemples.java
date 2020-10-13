package programmationDynamique;

public class Exemples 
{
	static void compteARebours(int n)
	{
		if (n <= 0)
		{
			System.out.println(n);
			compteARebours(n - 1);
		}
	}
	
	/*
	 * factorielle n = n ! = 1 * 2 * 3 * ... * (n - 1) * n
	 * = (n - 1)! * n
	 * 
	 * u_n est  1 si n = 0
	 * 			u_(n-1) * n sinon
	 * 		
	 */
	
	static long factorielle(int n) // O(n) temps linéaire
	{
		if (n == 0)
			return 1;
		else
			return n * factorielle(n - 1);
	}

	static long factorielleProgrammationDynamique(int n, long[] cache)
	{
		if (cache[n] == -1)
		{
			if (n == 0)
				cache[n] = 1; 
			else
				cache[n] = n * factorielleProgrammationDynamique(n - 1,cache);
		}
		return cache[n];
	}
	
	static long factorielleProgrammationDynamique(int n) // O(n)
	{
		long[] cache = new long[n + 1];
		for (int i = 0 ; i <= n ; i++)
			cache[i] = -1;
		return factorielleProgrammationDynamique(n, cache);
	}

	
	/*
	 * 0 1 1 2 3 5 8 13 21 34 55 89 ...
	 * f_n = f_(n-1) + f_(n-2) si n > 1
	 * 		= n sinon 
	 */
	
	static long fibonacci(int n) // O(phi^n) pourri
	{
		if (n > 1)
			return fibonacci(n - 1) + fibonacci(n - 2) + 1;
		return 1;
	}
	
	/*
	 f_7
	 = f_5 							+ f_6
	 = f_3 			+ f_4			+ f_4 			+ f_5
	 = f_1 + f_2	+ (f_2 + f_3)	+ _				+ f_3 + _
	 ..
	 = "plein" (O(f_n) = O(phi^n) avec phi = 1,618) de f_0 et de f_1
	 */
	static long fibonacciProgrammationDynamique(int n, long[] cache)
	{
		if (cache[n] == -1)
		{
			if (n <= 1)
				cache[n] = n;
			else
				cache[n] = fibonacciProgrammationDynamique(n - 1, cache)
						+ fibonacciProgrammationDynamique(n - 2, cache);
		}
		return cache[n];
	}
	static long fibonacciProgrammationDynamique(int n) 
	// O(n) temps linéaire
	// 2n - 1 appels de fonction	
	{
		long [] cache = new long[n + 1];
		for (int i = 0 ; i <= n ; i++)
			cache[i] = -1;
		long resultat = fibonacciProgrammationDynamique(n, cache);
		return resultat;
	}

	
/*	 
Triangle de Pascal :
1	
1	1	
1	2	1 
1	3	3	1
1	4	6	4	1
1	5	10	10	5	1
1	6	15	20	15	6	1

C(p, n) le terme à la colonne p et la ligne n
ex C(3, 6) = 20
comment calculer C(p, n) ?
C(p, n) = 1 sur les bords du triangle
		= 0 à l'extérieur du triangle
		= C(p-1, n-1) + C(p, n-1) sinon
*/

	static long combinaisons(int p, int n, long[][] cache)
	{
		if (cache[p][n] == -1)
		{
			if (p == 0 || p == n)
				cache[p][n] = 1;
			else if (p < 0 || n < 0)
				cache[p][n] = 0;
			else 
				cache[p][n] = combinaisons(p - 1, n - 1, cache) + combinaisons(p, n - 1, cache);
		}
		return cache[p][n];
	}

	static long combinaisons(int p, int n) 
	// sans programmation dynamique O(C(p, n))
	// avec programmation dynamique O(n * p)
	{
		long[][] cache = new long[p + 1][n + 1];
		for (int i = 0 ; i <= p ; i++)
			for (int j = 0 ; j <= n ; j++)
				cache[i][j] = -1;
		return combinaisons(p, n, cache);
	}

	static void trianglePascal(int nbLignes)
	{
		for (int n = 0 ; n <= nbLignes ; n++)
		{
			System.out.print("n = " + n + " :");
			for (int p = 0 ; p <= n ; p++)
				System.out.print("\t" + combinaisons(p, n));
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		trianglePascal(100);
	}
	
	/*
	 * Pour aller plus loin :
	 * https://www.codingame.com/training/medium/robbery-optimisation
	 * https://www.codingame.com/training/medium/the-grand-festival---i
	 * https://www.codingame.com/training/medium/the-grand-festival---ii
	 * https://www.codingame.com/training/medium/chained-matrix-products
	 * https://www.codingame.com/training/hard/levenshtein-distance
	 * https://www.codingame.com/training/hard/google-interview---the-two-egg-problem
	 * https://www.codingame.com/training/hard/x-egg-problem
	 */
}
