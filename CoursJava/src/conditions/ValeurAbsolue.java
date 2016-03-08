package conditions;

import java.util.Scanner;

public class ValeurAbsolue
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis un nombre : ");
		int nombre = scanner.nextInt();
		scanner.close();
		System.out.print("|" + nombre + "| = ");
		if (nombre < 0)
			nombre *= -1;
		System.out.print(nombre + ".");		
	}
}
