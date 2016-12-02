package tableaux;

public class Somme
{
	public static void main(String[] args)
	{
		int[] tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int somme = 0;
		for (int i = 0 ; i < tab.length ; i++)
			somme += tab[i];
		System.out.println("somme = " + somme);
	}
}
