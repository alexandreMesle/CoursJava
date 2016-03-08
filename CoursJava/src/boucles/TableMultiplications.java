package boucles;

import java.util.Scanner;

public class TableMultiplications
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		for (int i = 1 ; i <= 10 ; i++)
			System.out.println(n + " * " + i + " = " + n * i);
	}

}
