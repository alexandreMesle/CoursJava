package boucles;

import java.util.Scanner;

public class CompteAReboursTantQue
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		while (n >= 0)
		{
				System.out.println(n);
				n--;
		}
	}

}
