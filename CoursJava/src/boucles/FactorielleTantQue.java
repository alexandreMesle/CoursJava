package boucles;

import java.util.Scanner;

public class FactorielleTantQue
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		int fact = 1;
		int i = 1 ; 
		while (i <= n)
		{
				fact *= i;
				i++;
		}
		System.out.println(n + "! = " + fact);	
	}

}
