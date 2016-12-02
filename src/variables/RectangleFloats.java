package variables;

import java.util.Scanner;

public class RectangleFloats
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Largeur : ");
		double largeur = scanner.nextDouble();
		System.out.print("Largeur : ");
		double longueur = scanner.nextDouble();
		System.out.println("la surface du rectangle est " + largeur * longueur + ".");
		scanner.close();
	}
}
