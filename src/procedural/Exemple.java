package procedural;

public class Exemple
{
	/*
	 * Retourne le nombre b eleve a la puissance n.
	 */
	static int puissance(int b, int n)
	{
		int res = 1;
		for (int i = 1; i <= n; i++)
			res *= b;
		return res;
	}

	/*
	 * Affiche {2^k | k = 0, ..., 30}.
	 */
	public static void main(String[] args)
	{
		for (int k = 0; k <= 30; k++)
			System.out.println("2^" + k + " = " + puissance(2, k));
	}
}
