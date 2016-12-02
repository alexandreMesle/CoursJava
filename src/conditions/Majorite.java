package conditions;

import java.util.Scanner;

public class Majorite
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisis ton âge : ");
		int age = scanner.nextInt();
		scanner.close();
		if (age >= 18)
			System.out.println("Tu es majeur.");
		else
			System.out.println("Tu es mineur.");			
	}
}
