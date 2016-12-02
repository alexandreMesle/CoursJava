package variables;

import java.util.Scanner;

public class MoyenneTroisFloats
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisis trois valeurs\n* ");
		int i = scanner.nextInt();
		System.out.print("* ");
		int j = scanner.nextInt();
		System.out.print("* ");
		int k = scanner.nextInt();
		System.out.println("La moyenne de ces valeurs est " + (i + j + k) / 3 + ".");
		scanner.close();
	}	
}
