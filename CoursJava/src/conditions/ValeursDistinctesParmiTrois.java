package conditions;

import java.util.Scanner;

public class ValeursDistinctesParmiTrois
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("a = ");
		int a = scanner.nextInt();
		System.out.println("b = ");
		int b = scanner.nextInt();
		System.out.println("c = ");
		int c = scanner.nextInt();
		scanner.close();
		int vd = 2;
		if (a == b && b == c)
			vd = 1;
		if (a!=b && b != c && a!=c)
			vd = 3;
		System.out.println("Le nombre de valeurs distinctes saisies est " + vd + ".");
	}
}
