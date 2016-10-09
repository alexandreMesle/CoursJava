package variables;

import java.util.Scanner;

public class PermutationCinqValeurs
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis cinq valeurs\n* ");
		int a = scanner.nextInt();
		System.out.print("* ");
		int b = scanner.nextInt();
		System.out.print("* ");
		int c = scanner.nextInt();
		System.out.print("* ");
		int d = scanner.nextInt();
		System.out.print("* ");
		int e = scanner.nextInt();
		int temp = a;
		a = d;
		d = temp;
		temp = b;
		b = c;
		c = e;
		e = temp;
		System.out.println("Après permutation, les variables contiennent " + a + ", " 
				+ b + ", " + c + ", " + d + ", " + e + ".");
		scanner.close();
	}	
}
