package variables;

import java.util.Scanner;

public class PermutationDeuxValeurs
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis deux valeurs\n* ");
		int i = scanner.nextInt();
		System.out.print("* ");
		int j = scanner.nextInt();
		int temp = i;
		i = j;
		j = temp;
		System.out.println("Après permutation, les variables contiennent " + i + " et " + j + ".");
		scanner.close();
	}	
}
