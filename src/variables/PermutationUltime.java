package variables;

import java.util.Scanner;

public class PermutationUltime
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis six valeurs\n* ");
		int a = scanner.nextInt();
		System.out.print("* ");
		int b = scanner.nextInt();
		System.out.print("* ");
		int c = scanner.nextInt();
		System.out.print("* ");
		int d = scanner.nextInt();
		System.out.print("* ");
		int e = scanner.nextInt();
		System.out.print("* ");
		int f = scanner.nextInt();
		int temp = a;
		a = c;
		c = e;
		e = f;
		f = b;
		b = d;
		d = temp;
		System.out.println("Après permutation, les variables contiennent " + a + ", " 
				+ b + ", " + c + ", " + d + ", " + e + ", " + f + ".");
		scanner.close();
	}
}
