package procedural;

import java.util.Scanner;

public class Geometrie
{

	/*
	 * Affiche le caractère c
	 */

	public static void afficheCaractere(char c)
	{
		System.out.print(c + " ");
	}

	/* 
	 * Affiche n fois le caractère c, ne revient pas à la ligne 
	 * après le dernier caractère.
	 */

	public static void ligneSansReturn(int n, char c)
	{
		for(int i = 1 ; i <= n ; i++)
			afficheCaractere(c);
	}

	/* 
	 * Affiche n fois le caractère c, revient à la 
	 * 	ligne après le dernier caractère.
	 */

	public static void ligneAvecReturn(int n, char c)
	{
		ligneSansReturn(n, c);
		System.out.println();
	}

	/* 
	 * Affiche n espaces.
	 */

	public static void espaces(int n)
	{
		ligneSansReturn(n, ' ');
	}

	/* 
	 * Affiche le caractère c à la colonne i, ne revient 
	 * pas à la ligne après.
	 */

	public static void unCaractereSansReturn(int i, char c)
	{
		espaces (i - 1);
		afficheCaractere(c);
	}

	/*
	 *  Affiche le caractère c à la colonne i,
	 *  revient à la ligne après.
	 */

	public static void unCaractereAvecReturn(int i, char c)
	{
		unCaractereSansReturn(i, c);
		System.out.println();
	}

	/* Affiche le caractère c aux colonnes i et j,
	 * revient à la ligne après.
	 */

	public static void deuxCaracteres(int i, int j, char c)
	{
		unCaractereSansReturn(i, c);
		unCaractereAvecReturn(j - i, c);
	}

	/*
	 *  Affiche un carré de côté n.
	 */

	public static void carre(int n)
	{
		ligneAvecReturn(n, '*');
		for (int i = 1 ; i <= n-1 ; i++)
			deuxCaracteres(1, n, '*');
		ligneAvecReturn(n, '*');
	}

	/* Affiche un chapeau dont la pointe - 
	 * non affichée - est sur la colonne centre, 
	 * avec les caractères c.
	 */

	public static void chapeau(int centre, char c)
	{
		int i = centre - 1;
		int j = centre + 1;
		while (i >= 2)
		{		
			deuxCaracteres(i, j, c);
			i--;
			j++;
		}
	}

	/* 
	 * Affiche un chapeau à l'envers avec des caractères c, 
	 * la pointe - non affichée - est à la colonne centre.
	 */

	public static void chapeauInverse(int centre, char c)
	{
		int i = 2;
		int j = 2*(centre - 1);
		while(i+1 < j)
		{
			deuxCaracteres(i, j, c);
			i++;
			j--;
		}
	}

	/* 
	 * Affiche un losange de côté n.
	 */

	public static void losange(int n)
	{
		unCaractereAvecReturn(n, '*');
		chapeau(n, '*');
		deuxCaracteres(1, 2*n - 1, '*');
		chapeauInverse(n, '*');
		unCaractereAvecReturn(n, '*');
	}

	/*
	 *  Affiche une croix de côté n.
	 */

	public static void croix(int n)
	{
		deuxCaracteres(1, 2*n - 1, '*');			
		chapeauInverse(n, '*');
		unCaractereAvecReturn(n, '*');
		chapeau(n, '*');
		deuxCaracteres(1, 2*n - 1, '*');			
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int taille;
		System.out.println("Saisissez la taille des figures : ");
		taille = scanner.nextInt();
		scanner.close();
		carre(taille);
		losange(taille);
		croix(taille);
	}
}		
