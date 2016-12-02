package operateurs;

import java.util.Scanner;

public class PermutationSansTemp
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissiez deux entiers : ");
		System.out.print(" * ");
		int a = scanner.nextInt();
		System.out.print(" * ");
		int b = scanner.nextInt();
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("Après permutation, la valeur "
				+ "des variables sont " + a + " et " + b + ".");
		scanner.close();
	}

}
