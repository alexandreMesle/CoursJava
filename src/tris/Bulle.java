package tris;

import java.util.Random;

public class Bulle
{

	public static void main(String[] args)
	{
		int taille = 20;
		int[] t = new int[taille];
		Random random = new Random();
		for (int i = 0 ; i < t.length ; i++)
			t[i] = random.nextInt(100);
		for (int i = 0 ; i < t.length ; i++)
			System.out.print(t[i] + " ");
		System.out.println();
		// TRI
		boolean estTrie = false;
		for (int i = t.length - 1; !estTrie && i >= 1; i--)
		{
			estTrie = true;
			for (int j = 0 ; j < i; j++)
				if (t[j] > t[j + 1])
				{
					int temp = t[j];
					t[j] = t[j + 1];
					t[j + 1] = temp;
					estTrie = false;
				}
			for (int k = 0 ; k < t.length ; k++)
				System.out.print(t[k] + " ");
			System.out.println();

		}
		// FIN TRI
	}

}
