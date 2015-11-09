package tableaux;

public class ExempleCubique
{
	public static void main(String[] args)
	{
		final int T = 3;
		int[][][] u = new int[T][T][T];
		for (int i = 0; i < T; i++)
			for (int j = 0; j < T; j++)
				for (int k = 0; k < T; k++)
				{
					u[i][j][k] = 100 * i + 10 * j + k;
					System.out.println(u[i][j][k]);
				}

	}
}
