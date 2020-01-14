package programmationDynamique;

import java.util.*;

public class Exemples 
{
	public static int fibonacci(int n) // O(2^n)
	{
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static int fibonacciProgDyn(int n, Map<Integer, Integer> valeurs)
	{
		if (valeurs.containsKey(n))
			return valeurs.get(n);
		int result;
		if (n <= 1)
			result = n;
		else
			result = fibonacciProgDyn(n - 1, valeurs) + fibonacciProgDyn(n - 2, valeurs);
		valeurs.put(n, result);
		return result;
	}

	public static int fibonacciProgDyn(int n) // O(n)
	{
		return fibonacciProgDyn(n, new HashMap<>());
	}

	public static int combinaison(int p, int n)
	{
		if (p == 0 || p == n)
			return 1;
		if (p < 0 || n < 0)
			return 0;
		return combinaison(p - 1, n - 1) + combinaison(p, n - 1);		
	}

	public static int combinaisonProgDyn(int p, int n, int [][] valeurs)
	{
		if (p == 0 || p == n)
			return 1;
		if (p < 0 || n < 0)
			return 0;
		if (valeurs[p][n] == -1)
			valeurs[p][n] = combinaisonProgDyn(p - 1, n - 1, valeurs) + combinaisonProgDyn(p, n - 1, valeurs);		
		return valeurs[p][n];		
	}

	public static int combinaisonProgDyn(int p, int n)
	{
		int valeurs[][] = new int[p+1][n+1];
		for (int i = 0 ; i <= p ; i++)
			for (int j = 0 ; j <= n ; j++)
				valeurs[i][j] = -1;
		return combinaisonProgDyn(p, n, valeurs);
	}
	
	public static void main(String[] args) 
	{
		for (int i = 0 ; i <= 100 ; i ++)
			System.out.println(fibonacciProgDyn(i) + " ");
		System.out.println();
		for (int n = 0 ; n < 40 ; n ++)
		{
			for (int p = 0 ; p <= n ; p ++)
				System.out.print(combinaisonProgDyn(p, n) + " ");
			System.out.println();
		}		
	}
}
