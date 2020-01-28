package boucles;

import java.util.Scanner;

public class RacineCarree 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisis un nombre : ");
		double nombre = scanner.nextDouble();
		scanner.close();
		double precision = 1e-14;
		double inf = 0, sup = nombre;
		if (nombre < 1)
			sup = 1;
		while(sup - inf > precision)
		{
			System.out.println("[" + inf + ", " + sup + "]");
			double milieu = (inf + sup) / 2;
			if (milieu * milieu < nombre)
				inf = milieu;
			else
				sup = milieu;					
		}
		System.out.println("Racine(" + nombre + ") = " + (inf + sup)/2);
	}

}
