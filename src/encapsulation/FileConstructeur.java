package encapsulation;

public class FileConstructeur
{
	private int[] entiers;
	private int first, firstFree;

	public FileConstructeur(int taille)
	{
		entiers = new int[taille + 1];
		first = firstFree = 0;
	}

	private int incrementeIndice(int i)
	{
		i++;
		if (i == entiers.length)
			i = 0;
		return i;
	}

	public boolean estPlein()
	{
		return first == firstFree + 1;
	}

	public boolean estVide()
	{
		return first == incrementeIndice(firstFree);
	}

	public void enfile(int n)
	{
		if (!estPlein())
		{
			entiers[firstFree] = n;
			firstFree = incrementeIndice(firstFree);
		}
	}

	public void defile()
	{
		if (!estVide())
			first = incrementeIndice(first);
	}

	public int premier()
	{
		if (!estVide())
			return entiers[first];
		return 0;
	}
}
