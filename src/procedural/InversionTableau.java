package procedural;

public class InversionTableau
{

	public static void affiche(int[] t)
	{
		for (int i = 0; i < t.length; i++)
		{
			System.out.print(t[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] t, int i, int j)
	{
		int temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	public static void reverse(int[] t)
	{
		int i = 0, j = t.length - 1;
		while (i < j)
			swap(t, i++, j--);
	}

	public static void reverseRec(int[] t, int i, int j)
	{
		if (i < j)
		{
			swap(t, i, j);
			reverseRec(t, i + 1, j - 1);
		}
	}

	public static void reverseBis(int[] t)
	{
		reverseRec(t, 0, t.length - 1);
	}


	public static void main(String[] args)
	{
		int[] t = new int[20];
		for (int i = 0; i < 20; i++)
			t[i] = i + 1;
		affiche(t);
		reverse(t);
		affiche(t);
		reverseBis(t);
		affiche(t);
	}
}
