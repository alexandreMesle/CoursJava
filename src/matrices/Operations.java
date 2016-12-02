package matrices;

public class Operations
{
	public static int[][] somme(int[][] a, int[][] b)
	{
		int n = a.length, p = a[0].length;
		int [][] c = new int[n][p];
		for (int i = 0 ; i < n ; i++)
			for (int j = 0 ; j < p ; j++)
				c[i][j] = a[i][j] + b[i][j];
		return c;
	}

	public static void echange (int[][] m, int i1, int j1, int i2, int j2)
	{
		int temp = m[i1][j1];
		m[i1][j1] = m[i2][j2];
		m[i2][j2] = temp;
	}
	
	public static void transpose(int[][] m)
	{
		int n = m.length, p = m[0].length;
		for (int i = 1; i < n ; i++)
			for (int j = 0 ; j < i ; j++)
				echange(m, i, j, j, i);
	}

	public static int[][] retournertTransposee(int[][] m)
	{
		int n = m.length, p = m[0].length;
		int[][] c = new int[p][n];
		for (int i = 0 ; i < n ; i++)
			for (int j = 0 ; j < p ; j++)
				c[j][i] = m[i][j];
		return c;
	}

	public static void echangeLignes (int[][] m, int i1, int i2)
	{
		for (int j = 0 ; j < m[0].length ; j++)
			echange(m, i1, j, i2, j);
	}

	/*
	ou bien 
	*/
	
	public static void echangeLignesParReference (int[][] m, int i1, int i2)
	{
		int[] tmp = m[i1];
		m[i1] = m[i2];
		m[i2] = tmp;
	}
	
	public static int[][] produit(int[][] a, int[][] b)
	{
		int n = a.length, p = b.length, q = b[0].length;
		int [][] c = new int[n][q];
		for (int i = 0 ; i < n ; i++)
			for (int j = 0 ; j < q ; j++)
			{
				c[i][j] = 0;
				for (int k = 0 ; j < p ; j++)
					c[i][j] += a[i][k] * b[k][j];
			}
		return c;
	}
	
	public static int sommeCol(int[][] m, int j)
	{
		int somme = 0 ; 
		for (int i = 0 ; i < m.length ; i++)
			somme += m[i][j];
		return somme;
	}
	
	public static int plusGrandeColonne(int[][] m)
	{
		int p = m[0].length;
		int maxSomme = 0, maxcol = -1;
		for (int j = 0 ; j < p ; j++)
			{
				int somme = sommeCol(m, j);
				if (maxcol == -1 || somme > maxSomme )
				{
					maxcol = j;
					maxSomme = somme;
				}
			}
		return maxcol;
	}
	
	public static void afficheMatrice(int[][] matrice)
	{
		for(int i = 0 ; i < matrice.length ; i++)
		{
			for (int j = 0 ; j < matrice[i].length ; j++)
				System.out.format("%6d", matrice[i][j]);
			System.out.println();
		}
	}
}
