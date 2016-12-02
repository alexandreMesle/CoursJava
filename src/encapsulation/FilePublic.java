package encapsulation;

public class FilePublic
{
	/*
	 * Elements de la file
	 */

	int[] entiers;

	/*
	 * Indice de la tête de file et du premier emplacement libre dans le
	 * tableau.
	 */

	int first, firstFree;

	/*
	 * Initialise les attributs de la file.
	 */

	public void init(int taille)
	{
		entiers = new int[taille + 1];
		first = firstFree = 0;
	}

	/*
	 * Décale i d'une position vers la droite dans le tableau, revient au debut
	 * si i déborde.
	 */

	public int incrementeIndice(int i)
	{
		i++;
		if (i == entiers.length)
			i = 0;
		return i;
	}

	/*
	 * Retourne vrai si et seulement si la file est pleine.
	 */

	public boolean estPlein()
	{
		return first == incrementeIndice(firstFree);
	}

	/*
	 * Retourne vrai si et seulement si la file est vide.
	 */

	public boolean estVide()
	{
		return first == firstFree;
	}

	/*
	 * Ajoute l'élément n dans la file.
	 */

	public void enfile(int n)
	{
		if (!estPlein())
		{
			entiers[firstFree] = n;
			firstFree = incrementeIndice(firstFree);
		}
	}

	/*
	 * Supprime la tête de file.
	 */

	public void defile()
	{
		if (!estVide())
			first = incrementeIndice(first);
	}

	/*
	 * Retourne la tête de file.
	 */

	public int premier()
	{
		if (!estVide())
			return entiers[first];
		return 0;
	}
}
