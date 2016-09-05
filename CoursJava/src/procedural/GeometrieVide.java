package procedural;

import java.util.Scanner;

public class GeometrieVide
{

	/*
	 * Affiche le caractère c
	 */

	public static void afficheCaractere(char c)
	{
	}

	/* 
	 * Affiche n fois le caractère c, ne revient pas à la ligne 
	 * après le dernier caractère.
	 */

	public static void ligneSansReturn(int n, char c)
	{
	}

	/* 
	 * Affiche n fois le caractère c, revient à la 
	 * 	ligne après le dernier caractère.
	 */

	public static void ligneAvecReturn(int n, char c)
	{
	}

	/* 
	 * Affiche n espaces.
	 */

	public static void espaces(int n)
	{
	}

	/* 
	 * Affiche le caractère c à la colonne i, ne revient 
	 * pas à la ligne après.
	 */

	public static void unCaractereSansReturn(int i, char c)
	{
	}

	/*
	 *  Affiche le caractère c à la colonne i,
	 *  revient à la ligne après.
	 */

	public static void unCaractereAvecReturn(int i, char c)
	{
	}

	/* Affiche le caractère c aux colonnes i et j,
	 * revient à la ligne après.
	 */

	public static void deuxCaracteres(int i, int j, char c)
	{
	}

	/*
	 *  Affiche un carré de côté n.
	 */

	public static void carre(int n)
	{
	}

	/* Affiche un chapeau dont la pointe - 
	 * non affichée - est sur la colonne centre, 
	 * avec les caractères c.
	 */

	public static void chapeau(int centre, char c)
	{
	}

	/* 
	 * Affiche un chapeau à l'envers avec des caractères c, 
	 * la pointe - non affichée - est à la colonne centre.
	 */

	public static void chapeauInverse(int centre, char c)
	{
	}

	/* 
	 * Affiche un losange de côté n.
	 */

	public static void losange(int n)
	{
	}

	/*
	 *  Affiche une croix de côté n.
	 */

	public static void croix(int n)
	{
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
