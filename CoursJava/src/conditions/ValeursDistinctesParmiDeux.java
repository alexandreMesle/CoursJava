package conditions;

import java.util.Scanner;

public class ValeursDistinctesParmiDeux
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("a = ");
		int a = scanner.nextInt();
		System.out.println("b = ");
		int b = scanner.nextInt();
		scanner.close();
		if (a == b)
			System.out.println("Les deux valeurs saisies sont identiques.");
		else
			System.out.println("Les deux valeurs saisies sont différrentes.");			
	}
}
