package tableaux;

public class PermutationCirculaire
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int tmp = tab[tab.length - 1];
		for (int i = tab.length - 1 ; i >= 1 ; i--)
			tab[i] = tab[i - 1];
		tab[0] = tmp;
		for (int indice = 0 ; indice < tab.length ; indice++)
			System.out.print(tab[indice] + " ");
	}
}
