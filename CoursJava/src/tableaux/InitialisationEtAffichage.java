package tableaux;

public class InitialisationEtAffichage
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for (int indice = 0 ; indice < tab.length ; indice++)
			System.out.print(tab[indice] + " ");
	}
}
