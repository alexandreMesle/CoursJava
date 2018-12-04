package conditions;

import java.util.Scanner;

public class Calculatrice {

	public static void main(String[] args) 
	{
		Scanner saisie = new Scanner(System.in);
		System.out.println("Saisis une valeur :");
		int a = saisie.nextInt();
		System.out.println("Saisis un opérateur :");
		char o = saisie.next().charAt(0);
		System.out.println("Saisis une valeur :");
		int b = saisie.nextInt();
		int resultat = 0;
		boolean erreur = false;
		switch (o)
		{
		case '+' : resultat = a + b;break;
		case '-' : resultat = a - b;break;
		case '*' : resultat = a * b;break;
		case '/' : resultat = a / b;break;
		default : erreur = true;
		}
		if (erreur)
			System.out.println("Operateur inconnu\n");
		else
			System.out.println("" + a + o + b + "=" + resultat);
		saisie.close();
	}

}
