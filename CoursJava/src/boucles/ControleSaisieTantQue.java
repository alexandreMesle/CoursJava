package boucles;

import java.util.Scanner;

public class ControleSaisieTantQue
{
	public static void main(String[] args)
	{
		Scanner saisie = new Scanner(System.in);
		int i;
		do
		{
			System.out.print("Saisissez un entier positif ou nul : ");
			i = saisie.nextInt();
			if (i < 0)
				System.out.println("J'ai dit positif ou nul !");
		}
		while (i < 0);
		saisie.close();
		System.out.println("Vous avez saisi " + i + ".");
	}

}
