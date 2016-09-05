package tableaux;

public class PermutationCirculaireDeuxTableaux
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] res = new int[tab.length];
		for (int i = 0 ; i < tab.length ; i++)
			res[(i + 1)%tab.length] = tab[i];
		for (int i = 0 ; i < res.length ; i++)
			System.out.print(res[i] + " ");
	}
}
