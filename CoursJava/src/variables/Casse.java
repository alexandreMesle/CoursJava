package variables;

import java.util.Scanner;

public class Casse
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisissez une minuscule : ");
		char minuscule = scanner.next().charAt(0);
		char majuscule = (char)((int)minuscule + (int)'A' - (int)'a');
		System.out.println("La majuscule correspondante est " + majuscule + ".");
		scanner.close();
	}	
}
