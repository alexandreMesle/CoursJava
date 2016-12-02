package boucles;

import java.util.Scanner;

public class Puissance
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez la base : ");
		int base = scanner.nextInt();
		System.out.println("Saisissez l'exposant : ");
		int exposant = scanner.nextInt();
		scanner.close();
		int puissance = 1;
		for (int i = 1 ; i <= exposant ; i++)
			puissance *= base;
		System.out.println(base + "^" + exposant + " = " + puissance);
	}

}
