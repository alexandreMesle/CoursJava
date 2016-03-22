package tableaux;

import java.util.Scanner;

public class RechercheSequentielle
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Scanner s = new Scanner(System.in);
		System.out.println("Saisissez une valeur");
		int r = s.nextInt();
		s.close();
		boolean trouve = false;
		for (int i = 0 ; i < tab.length ; i++)
			trouve = trouve || tab[i] == r;
		System.out.print(r + " ");
		if (trouve)
			System.out.print("se trouve");
		else
			System.out.print("ne se trouve pas");
		System.out.println(" dans le tableau.");
	}
}
