package boucles;

import java.util.Scanner;

public class FactoriellePour
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		int fact = 1;
		for (int i = 1 ; i <= n ; i++)
				fact *= i;
		System.out.println(n + "! = " + fact);	
	}

}
