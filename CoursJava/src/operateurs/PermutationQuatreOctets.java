package operateurs;

import java.util.Scanner;

public class PermutationQuatreOctets
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisissez un entier : ");
		int x = scanner.nextInt();
		int masque = 255; 
		int d = (x & masque) << 8 * 3;
		masque <<= 8;
		int c = (x & masque) << 8;
		masque <<= 8;
		int b = (x & masque) >> 8;
		masque <<= 8;
		int a = (x & masque) >> 8 * 3;
		x = a | b | c | d; 
		System.out.println("Après permutation des quatre "
				+ "octets, on obtient " + x + ".");
		masque = 255;
		d = (x & masque) << 8 * 3;
		masque <<= 8;
		c = (x & masque) << 8;
		masque <<= 8;
		b = (x & masque) >> 8;
		masque <<= 8;
		a = (x & masque) >> 8 * 3;
		x = a | b | c | d;		
		System.out.println("Le nombre de départ était " + x + ".");
		scanner.close();
	}

}
