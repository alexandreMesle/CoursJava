package encapsulation;

public class NativeArray
{
	public static void main(String[] args)
	{
		int taille = (47 - 2) / 3 + 1;
		int[] a = new int[taille];
		for (int value = 2, index = 0; value < 50; value += 3, index++)
			a[index] = value;
		for (int index = 0; index < taille; index++)
		{
			int valeur = a[index];
			System.out.println(valeur);
		}
	}

}
