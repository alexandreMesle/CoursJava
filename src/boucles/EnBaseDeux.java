package boucles;

import java.util.Scanner;

public class EnBaseDeux
{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Saisissez un entier : ");
		int x = scan.nextInt();
		scan.close();
		int sup = 1;
		while (sup*2 <= x)
			sup *= 2 ;
		while (sup != 0)
		{
			if (x >= sup)
			{
				System.out.print(1);
				x -= sup;
			}
			else
				System.out.print(0);
			sup /= 2;
		}
		System.out.println();
	}
}
