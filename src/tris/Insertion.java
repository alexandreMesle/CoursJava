package tris;

import java.util.Random;

public class Insertion
{

	public static void main(String[] args)
	{
		int taille = 10;
		int[] t = new int[taille];
		Random random = new Random();
		for (int i = 0 ; i < t.length ; i++)
			t[i] = random.nextInt(100);
		for (int i = 0 ; i < t.length ; i++)
			System.out.print(t[i] + " ");
		System.out.println();
		// TRI
		for (int i = 1 ; i < t.length ; i++)
		{
			int j = i;
			while(j >= 1 && t[j] < t[j - 1])
			{
				int temp = t[j];
				t[j] = t[j - 1];
				t[j - 1] = temp;
				j--;
			}
		}
		// FIN TRI
			for (int k = 0 ; k < t.length ; k++)
				System.out.print(t[k] + " ");
			System.out.println();
	}

}
