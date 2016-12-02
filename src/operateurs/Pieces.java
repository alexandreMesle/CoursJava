package operateurs;

import java.util.Scanner;

public class Pieces
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Saisissiez un nombre entre 0 et 1 : ");
		double somme = scanner.nextDouble();
		int nbPieces;
		double valeurPiece, epsilon = 1e-5;
		/*********/
		valeurPiece = 0.5;
		nbPieces = (int) (somme / valeurPiece);
		somme = somme - nbPieces * valeurPiece + epsilon;
		System.out.println(nbPieces + " pièce(s) de " + valeurPiece + "€");
		/*********/
		valeurPiece = 0.2;
		nbPieces = (int) (somme / valeurPiece);
		somme = somme - nbPieces * valeurPiece + epsilon;
		System.out.println(nbPieces + " pièce(s) de " + valeurPiece + "€");
		/*********/
		valeurPiece = 0.1;
		nbPieces = (int) (somme / valeurPiece);
		somme = somme - nbPieces * valeurPiece + epsilon;
		System.out.println(nbPieces + " pièce(s) de " + valeurPiece + "€");
		/*********/
		valeurPiece = 0.05;
		nbPieces = (int) (somme / valeurPiece);
		somme = somme - nbPieces * valeurPiece + epsilon;
		System.out.println(nbPieces + " pièce(s) de " + valeurPiece + "€");
		/*********/
		valeurPiece = 0.02;
		nbPieces = (int) (somme / valeurPiece);
		somme = somme - nbPieces * valeurPiece + epsilon;
		System.out.println(nbPieces + " pièce(s) de " + valeurPiece + "€");
		/*********/
		valeurPiece = 0.01;
		nbPieces = (int) (somme / valeurPiece);
		somme = somme - nbPieces * valeurPiece + epsilon;
		System.out.println(nbPieces + " pièce(s) de " + valeurPiece + "€");
		/*********/
		scanner.close();	
	}

}
