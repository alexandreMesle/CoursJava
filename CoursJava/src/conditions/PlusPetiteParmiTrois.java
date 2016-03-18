package conditions;

import java.util.Scanner;

public class PlusPetiteParmiTrois
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
		int min = a;
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		System.out.println("La plus petite des trois valeurs est " + min + ".");
	}
}
