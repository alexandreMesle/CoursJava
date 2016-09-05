package boucles;

import java.util.Scanner;

public class CompteAReboursRepeter
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		do
		{
				System.out.println(n);
				n--;
		}
		while (n >= 0);
	}

}
