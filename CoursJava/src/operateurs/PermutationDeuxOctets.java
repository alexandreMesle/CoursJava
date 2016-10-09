package operateurs;

import java.util.Scanner;

public class PermutationDeuxOctets
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisissez un entier : ");
		short x = scanner.nextShort();
		short masque = 255, 
			deuxieme = (short) (x & masque),
			premier = (short) (x & masque << 8);
		x = (short) (premier >> 8 | deuxieme << 8);
		System.out.println("Après échange des deux "
				+ "octets, on obtient " + x + ".");				
		masque = 255; 
		deuxieme = (short) (x & masque);
		premier = (short) (x & masque << 8);
			x = (short) (premier >> 8 | deuxieme << 8);
		System.out.println("Le nombre de départ était " + x + ".");
		scanner.close();
	}

}
