package variables;

import java.util.Scanner;

public class SaisieEtAffichage
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis ton nom : ");
		String nom = scanner.next();
		System.out.println("Bonjour, " + nom + ".");
		scanner.close();
	}	
}
