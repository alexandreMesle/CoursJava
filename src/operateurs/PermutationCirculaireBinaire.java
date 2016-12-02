package operateurs;

import java.util.Scanner;

public class PermutationCirculaireBinaire
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisissez un entier : ");
		int i = scanner.nextInt();
		int dernier = i & 1 << Integer.SIZE - 1;
		i >>= 1;
		i |= dernier;
		System.out.println("Après permutation cirulaire des "
				+ "bits vers la droite, on a " + i + ".");
		int premier = i & 1 << Integer.SIZE - 1;
		i <<= 1;
		i |= premier;
		System.out.println("Le nombre saisi était " + i + ".");
		scanner.close();
	}

}
