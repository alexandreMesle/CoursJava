package conditions;

import java.util.Scanner;

public class Franchise
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisir le montant des dommages : ");
		double dommages = scanner.nextDouble();
		scanner.close();
		double franchise = dommages / 10;
		if (franchise > 4000)
			franchise = 4000;
		double remboursement = dommages - franchise;
		System.out.println("Prise en charge = " + remboursement + ".");
		System.out.println("Franchise = " + franchise + ".");
	}
}
