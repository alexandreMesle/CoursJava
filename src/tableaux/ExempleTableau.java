package tableaux;

public class ExempleTableau
{
	public static void main(String[] args)
	{
		final int T = 20;
		int[] t = new int[T];
		for (int i = 0; i < T; i++)
			t[i] = i;
		for (int i = 0; i < T; i++)
			System.out.println(t[i]);
	}
}
