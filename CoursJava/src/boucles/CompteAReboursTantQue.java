package boucles;

import java.util.Scanner;

public class CompteAReboursTantQue
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		scanner.close();
		int n = scanner.nextInt();
		while (n >= 0)
		{
				System.out.println(n);
				n--;
		}
	}

}
