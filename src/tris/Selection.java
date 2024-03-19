package tris;

import java.util.Random;

public class Selection
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
		for(int i = 0 ; i < t.length - 1 ; i++)
		{
			int min = i ;
			for (int j = i + 1 ; j < t.length ; j++)
				if(t[j] < t[min])
					min = j;
			int temp = t[i];
			t[i] = t[min];
			t[min] = temp;
		}
		// FIN TRI
		for (int k = 0 ; k < t.length ; k++)
			System.out.print(t[k] + " ");
		System.out.println();
	}

}
