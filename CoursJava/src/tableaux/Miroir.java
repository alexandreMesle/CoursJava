package tableaux;

public class Miroir
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int i = 0, j = tab.length - 1;
		while (i < j)
		{
			int tmp = tab[i];
			tab[i] = tab[j];
			tab[j] = tmp;
			i++;
			j--;
		}
		for (int indice = 0 ; indice < tab.length ; indice++)
			System.out.print(tab[indice] + " ");
	}
}
