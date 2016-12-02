package encapsulation;

public class ListeInt
{
	/*
	 * Donnee stockee dans le maillon
	 */

	private int data;

	/*
	 * Pointeur vers le maillon suivant
	 */

	private ListeInt next;

	/*
	 * Constructeur initialisant la donnee et le pointeur vers l'element
	 * suivant.
	 */

	ListeInt(int data, ListeInt next)
	{
	}

	/*
	 * Constructeur initialisant la donnee et mettant le suivant a null.
	 */

	ListeInt(int data)
	{
	}

	/*
	 * Constructeur recopiant tous les maillons de other.
	 */

	ListeInt(ListeInt other)
	{
	}

	/*
	 * Retourne la donnee.
	 */

	public int getData()
	{
		return 0;
	}

	/*
	 * Modifie la donnee
	 */

	public void setData(int data)
	{
	}

	/*
	 * Retourne le maillon suivant.
	 */

	public ListeInt getNext()
	{
		return null;
	}

	/*
	 * Modifie le maillon suivant
	 */

	public void setNext(ListeInt next)
	{
	}

	/*
	 * Retourne une représentation sous forme de chaine de la liste.
	 */

	public String toString()
	{
		return null;
	}

	/*
	 * Teste le fonctionnement de la liste.
	 */

	public static void main(String[] args)
	{
		ListeInt l = new ListeInt(20);
		int i = 19;
		while (i >= 0)
			l = new ListeInt(i--, l);
		System.out.println(l);

	}

}
