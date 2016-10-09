package variables;

import java.util.Scanner;

public class PermutationQuatreValeurs
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis quatre valeurs\n* ");
		int a = scanner.nextInt();
		System.out.print("* ");
		int b = scanner.nextInt();
		System.out.print("* ");
		int c = scanner.nextInt();
		System.out.print("* ");
		int d = scanner.nextInt();
		int temp = a;
		a = c;
		c = temp;
		temp = b;
		b = d;
		d = temp;
		System.out.println("Après permutation, les variables contiennent " + a + ", " 
				+ b + ", " + c + ", " + d + ".");
		scanner.close();
	}	
}
