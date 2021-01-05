package jeux;

import java.util.Scanner;

public class Allumettes
{
	static int nbNoeuds = 0;
	static int[] scoresIA ; 
	static int[] scoresJoueur ; 
	
	static int tour(int nbRestant, int max, boolean dernierGagne)
	{	
		if (!dernierGagne)
			return tour(nbRestant - 1, max, !dernierGagne);
		int nb = nbRestant % (max + 1);
		if (nb != 0)
		{
			System.out.println(":-)");
			return nb;
		}
		System.out.println(":-(");
		return 1;
	}
	
	static int minMax_(int nbRestant, int max, boolean IA)
	{
		if (IA && scoresIA[nbRestant] == -2
			|| !IA && scoresJoueur[nbRestant] == -2)
		{
			nbNoeuds++;
			if (nbRestant == 0)
			{
				int bestScore;
				if (IA)
					bestScore = -1;
				else
					bestScore = 1;
				return bestScore;
			}
			if (max > nbRestant)
				max = nbRestant;
			int bestScore = 0;
			for (int i = 1 ; i <= max ; i++)
			{
				int score = minMax_(nbRestant - i, max, !IA);
				if (i == 1)
					bestScore = score;
				else if (IA && score > bestScore)
					bestScore = score;	
				else if (!IA && score < bestScore)
					bestScore = score;
			}
			if (IA)
				scoresIA[nbRestant] = bestScore;
			else
				scoresJoueur[nbRestant] = bestScore;
		}
		if (IA)
			return scoresIA[nbRestant];
		else
			return scoresJoueur[nbRestant];
	}

	static int minMax(int nbRestant, int max, boolean dernierGagne)
	{
		nbNoeuds = 0;
		scoresIA = new int[nbRestant + 1];
		scoresJoueur = new int[nbRestant + 1];
		for (int i = 0 ; i <= nbRestant ; i++)
		{
			scoresIA [i] = -2;
			scoresJoueur [i] = -2;
		}
		if (!dernierGagne)
			return minMax(nbRestant - 1, max, !dernierGagne);
		if (max > nbRestant)
			max = nbRestant;
		int bestMove = 0;
		int bestScore = 0;
		for (int i = 1 ; i <= max ; i++)
		{
			int score = minMax_(nbRestant - i, max, false);
			if (i == 1 || score > bestScore)
			{
				bestMove = i;
				bestScore = score;
			}
		}
		System.err.println("Nbnoeuds = " + nbNoeuds);
		return bestMove;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int nbAllumettes = 17;
		boolean dernierGagne = true;
		boolean aMoi = false;
		int max = 3; 
		System.out.println("valeur de départ : " + nbAllumettes);
		while (nbAllumettes != 0)
		{
			if (aMoi)
			{
				int nb;
				do
				{
					System.out.println("A toi :");
					nb = scanner.nextInt();
				}
				while(nb <= 0 || nb > max);
				nbAllumettes -= nb;
			}
			else
			{
				System.out.println("IA :");
				nbAllumettes -= minMax(nbAllumettes, max, dernierGagne);				
			}
			System.out.println(nbAllumettes);
			if(nbAllumettes == 0)
				if(aMoi == dernierGagne)
					System.out.println("Gagné");
				else
					System.out.println("Perdu");
			aMoi = !aMoi;
		}
		
		scanner.close();
	}

}
