package variables;

import java.util.Scanner;

public class SaisieEtAffichageFloat
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis un nombre : ");
		float nombre = scanner.nextFloat();
		System.out.println("Tu as saisi " + nombre + ".");
		scanner.close();
	}
}

