package boucles;

public class ExerciceDeux
{
	public static void main(String[] args)
	{
		int a = 0, b = 0, c = 0, d = 0, m = 3, n = 4;
		for (; a < m; a++)
		{
			d = 0;
			for (b = 0; b < n; b++)
				d += b;
			c += d;
		}
		System.out.println(a + ", " + b + ", " + c + ", " + d + ".");
	}
}
