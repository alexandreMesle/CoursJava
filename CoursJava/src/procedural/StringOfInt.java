package procedural;

class StringOfInt
{

	/*
	 * Affiche le nombre passe en parametre s'il est compris entre 1 et 19.
	 */

	static void afficheUnites(int n)
	{
		switch (n)
		{
		case 1:
			System.out.print("un");
			break;
		case 2:
			System.out.print("deux");
			break;
		case 3:
			System.out.print("trois");
			break;
		case 4:
			System.out.print("quatre");
			break;
		case 5:
			System.out.print("cinq");
			break;
		case 6:
			System.out.print("six");
			break;
		case 7:
			System.out.print("sept");
			break;
		case 8:
			System.out.print("huit");
			break;
		case 9:
			System.out.print("neuf");
			break;
		case 10:
			System.out.print("dix");
			break;
		case 11:
			System.out.print("onze");
			break;
		case 12:
			System.out.print("douze");
			break;
		case 13:
			System.out.print("treize");
			break;
		case 14:
			System.out.print("quatorze");
			break;
		case 15:
			System.out.print("quinze");
			break;
		case 16:
			System.out.print("seize");
			break;
		case 17:
			System.out.print("dix-sept");
			break;
		case 18:
			System.out.print("dix-huit");
			break;
		case 19:
			System.out.print("dix-neuf");
			break;
		default:
			break;
		}
	}

	/*
	 * Affiche les dizaines de 10*n si n est compris entre 2 et 9.
	 */

	static void afficheDizaines(int n)
	{
		switch (n)
		{
		case 2:
			System.out.print("vingt");
			break;
		case 3:
			System.out.print("trente");
			break;
		case 4:
			System.out.print("quarante");
			break;
		case 5:
			System.out.print("cinquante");
			break;
		case 6:
		case 7:
			System.out.print("soixante");
			break;
		case 8:
		case 9:
			System.out.print("quatre-vingt");
			break;
		default:
			break;
		}
	}

	/*
	 * Retourne b^n
	 */

	static int puissance(int b, int n)
	{
		int res = 1;
		for (int i = 1; i <= n; i++)
			res *= b;
		return res;
	}

	/*
	 * Extrait les chiffres de n par tranche. On indices ces chiffres a partir
	 * de 1 en partant de la droite. debut est l'indice du debut de la tranche
	 * et fin l'indice de la fin. Par exemple extraitTranche(987654321, 5, 2) =
	 * 5432.
	 */

	static int extraitTranche(int n, int debut, int fin)
	{
		return (n % puissance(10, debut)) / puissance(10, fin - 1);
	}

	/*
	 * Affiche en toutes lettres le nombre n, n doit etre compris entre 0 et
	 * 999.
	 */

	static void afficheTroisChiffres(int n)
	{
		int unites = extraitTranche(n, 1, 1);
		int dizaines = extraitTranche(n, 2, 2);
		int dizainesUnites = extraitTranche(n, 2, 1);
		int centaines = extraitTranche(n, 3, 3);
		if (centaines >= 2)
		{
			afficheUnites(centaines);
			System.out.print("-");
		}
		if (centaines != 0)
			System.out.print("cent");
		if (dizainesUnites == 0 && centaines != 1 && centaines != 0)
			System.out.print("s");
		if (dizainesUnites != 0 && centaines != 0)
			System.out.print("-");
		afficheDizaines(dizaines);
		if (unites == 0 && dizaines == 8)
			System.out.print("s");
		if (dizaines != 0 && dizaines != 1
				&& (unites != 0 || dizaines == 7 || dizaines == 9))
			System.out.print("-");
		if (unites == 1 && dizaines >= 2 && dizaines <= 6)
			System.out.print("et-");
		if (dizaines == 1 || dizaines == 7 || dizaines == 9)
			afficheUnites((dizainesUnites - 10 * (dizaines - 1)));
		else
			afficheUnites(unites);
	}

	/*
	 * Affiche le nombre n suivi de la chaine unite, accorde est vrai si l'unite
	 * n'est pas invariable.
	 */

	static void afficheNombreEtUnite(int n, String unite, boolean accorde)
	{
		if (accorde || n != 1)
		{
			afficheTroisChiffres(n);
			if (n != 0)
				System.out.print(" ");
		}
		System.out.print(unite);
		if (accorde && n > 1)
			System.out.print("s");
	}

	static void afficheNombre(int n)
	{
		int billions = extraitTranche(n, 15, 13);
		int milliards = extraitTranche(n, 12, 10);
		int millions = extraitTranche(n, 9, 7);
		int milliers = extraitTranche(n, 6, 4);
		int unites = extraitTranche(n, 3, 1);
		if (billions != 0)
		{
			afficheNombreEtUnite(billions, "billion", true);
			System.out.print(" ");
		}
		if (milliards != 0)
		{
			afficheNombreEtUnite(milliards, "milliard", true);
			System.out.print(" ");
		}
		if (millions != 0)
		{
			afficheNombreEtUnite(millions, "million", true);
			System.out.print(" ");
		}
		if (milliers != 0)
		{
			afficheNombreEtUnite(milliers, "mille", false);
			System.out.print(" ");
		}
		if (unites != 0)
		{
			afficheNombreEtUnite(unites, "", false);
		}
	}

	public static void main(String[] args)
	{
		for (int i = 1; i <= 30; i++)
		{
			System.out.print(puissance(3, i) + " = ");
			afficheNombre(puissance(3, i));
			System.out.println("");
		}
	}
}
