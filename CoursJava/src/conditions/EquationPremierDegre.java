package conditions;

import java.util.Scanner;

public class EquationPremierDegre
{

	public static void main(String[] args)
	{
		System.out.println("Résolution de ax + b = 0 : ");
		Scanner scanner = new Scanner(System.in);
		System.out.print("a = ");
		double a = scanner.nextDouble();
		System.out.print("b = ");
		double b = scanner.nextDouble();
		scanner.close();
		if (a != 0)
			System.out.println("La solution est " + -b/a + ".");
		else
			if (b == 0)
				System.out.println("Tout réel est solution de l'équation.");
			else
				System.out.println("L'équation n'a aucune solution.");
	}
}
