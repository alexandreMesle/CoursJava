package tableaux;

public class InitialisationEtAffichageBoucle
{
	public static void main(String[] args)
	{
		int[] tab = new int[10];
		for (int i = 0 ; i < tab.length ; i++)
			tab[i] = i + 1;
		for (int indice = 0 ; indice < tab.length ; indice++)
			System.out.print(tab[indice] + " ");
	}
}
