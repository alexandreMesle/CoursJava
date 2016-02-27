package boucles;

import java.util.Scanner;

public class CompteAReboursPour
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		for (int i = n ; i >= 0 ; i--)
				System.out.println(i);
	}

}
