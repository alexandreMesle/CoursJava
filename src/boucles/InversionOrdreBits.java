package boucles;

import java.util.Scanner;

public class InversionOrdreBits 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Saisis un entier : ");		
		int n = scanner.nextInt();
		System.out.println("Sa représentation binaire est : ");
		int masque = 1;
		masque <<= 31;
		while(masque != 0)
		{
			System.out.print((masque&n) > 0 ? 1 : 0);
			masque >>>= 1;
		}
		scanner.close();
	}
}
