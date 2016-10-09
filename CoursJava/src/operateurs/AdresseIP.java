package operateurs;

import java.util.Scanner;

public class AdresseIP
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int a, b, c, d;
		System.out.println("Saisissez les quatre chiffres de l'adresse IP :");
		System.out.print(" * ");
		a = scanner.nextInt();
		System.out.print(" * ");
		b = scanner.nextInt();
		System.out.print(" * ");
		c = scanner.nextInt();
		System.out.print(" * ");
		d = scanner.nextInt();
		int adresseIP = a;
		adresseIP <<= 8;
		adresseIP |= b;
		adresseIP <<= 8;
		adresseIP |= c;
		adresseIP <<= 8;
		adresseIP |= d;
		System.out.println("L'adresse IP codée sur un int est " + adresseIP);
		int mask = 255;
		d = adresseIP & mask;
		adresseIP >>= 8;
		c = adresseIP & mask;
		adresseIP >>= 8;
		b = adresseIP & mask;
		adresseIP >>= 8;
		a = adresseIP & mask;
		System.out.println("Les quatre nombres saisis sont :");
		System.out.print(a + "." + b + "." + c + "." + d);
		scanner.close();		
	}

}
