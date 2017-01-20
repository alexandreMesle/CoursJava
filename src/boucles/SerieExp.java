package boucles;

import java.util.Scanner;

public class SerieExp
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Saisissez un réel : ");
		double x = scan.nextDouble();
		scan.close();
		double somme = 0, terme = 1, eps = 1e-26, i = 0;
		while (Math.abs(terme) > eps)
		{
			somme += terme;
			i++;
			terme *= x/i;			
		}
		System.out.println(somme);		
	}
}
