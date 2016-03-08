package conditions;

import java.util.Scanner;

public class EquationSecondDegre
{

	public static void main(String[] args)
	{
		System.out.println("Résolution de ax^2 + bx + c = 0 : ");
		Scanner scanner = new Scanner(System.in);
		System.out.print("a = ");
		double a = scanner.nextDouble();
		System.out.print("b = ");
		double b = scanner.nextDouble();
		System.out.print("c = ");
		double c = scanner.nextDouble();
		scanner.close();
		if (a != 0)
		{
			double discriminant = b * b - 4 * a * c;
			if (discriminant > 0)
				System.out.println("Les solutions sont " + (-b + Math.sqrt(discriminant)) / (2 * a) + 
									" et " + (-b - Math.sqrt(discriminant)) / (2 * a) + ".");
			if (discriminant == 0)
				System.out.println("La solution est " + -b / (2 * a) + ".");
			if (discriminant < 0)
				System.out.println("L'équation n'a pas de solution réelle.");
		}
		else
			if (b != 0)
				System.out.println("La solution est " + -c/b + ".");
			else
				System.out.println("L'équation n'a aucne solution réelle.");
	}
}
