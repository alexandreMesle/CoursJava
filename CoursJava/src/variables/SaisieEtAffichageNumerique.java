package variables;

import java.util.Scanner;

public class SaisieEtAffichageNumerique
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis un nombre : ");
		int nombre = scanner.nextInt();
		System.out.println("Tu as saisi " + nombre + ".");
		scanner.close();
	}

}
