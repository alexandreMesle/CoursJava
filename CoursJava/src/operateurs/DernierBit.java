package operateurs;

import java.util.Scanner;

public class DernierBit
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisissez un entier : ");
		int a = scanner.nextInt();
		a ^= 1;
		System.out.println("En changeant le dernier bit, "
				+ "on a " + a);
		scanner.close();
	}

}
