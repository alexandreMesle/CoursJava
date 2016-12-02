package variables;

import java.util.Scanner;

public class OperationsEntiers
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis deux valeurs\n* ");
		int i = scanner.nextInt();
		System.out.print("* ");
		int j = scanner.nextInt();
		System.out.println("La somme de ces nombres est " + (i + j)
				+ " et leur quotient est " + (double)i/j + ".");
		scanner.close();
	}	
}
