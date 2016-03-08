package boucles;

import java.util.Scanner;

public class JoliCarre
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("n = ");
		int n = scanner.nextInt();
		scanner.close();
		for (int i = 1 ; i <= n ; i++)
		{
			for (int j = 1 ; j <= n ; j++)
				System.out.print("* ");
			System.out.println();
		}
	}

}
