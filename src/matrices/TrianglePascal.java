package matrices;

public class TrianglePascal
{
	public static int[][] trianglePascal(int n)
	{
		int[][] r = new int[n+1][];
		for(int i = 0 ; i <= n ; i++)
		{
			r[i] = new int[i + 1];
			r[i][0] = 1;
			r[i][i] = 1;
		}
		for (int i = 1 ; i <= n ; i++)
			for (int j = 1 ; j < i ; j++)
				r[i][j] = r[i - 1][j - 1] + r[i - 1][j];
		return r;
	}
	
	public static void main(String[] args)
	{
		Operations.afficheMatrice(trianglePascal(15));
	}

}
