package encapsulation.corriges;

public class ListeInt
{
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
		this.data = data;
		this.next = next;
	}

	/*
	 * Constructeur initialisant la donnee et mettant le suivant a null.
	 */

	ListeInt(int data)
	{
		this(data, null);
	}

	/*
	 * Cree une liste aléatoire
	 */
	
	static ListeInt aleatoire(int taille)
	{
		if (taille == 0)
			return null;
		return new ListeInt((new java.util.Random()).nextInt()%100, 
				aleatoire(taille - 1));
	}
	
	/*
	 * Constructeur initialisant la donnee et mettant le suivant a null.
	 */

	ListeInt(ListeInt other)
	{
		this(other.getData(), new ListeInt(other.getNext()));
	}

	/*
	 * Retourne la donnee.
	 */

	public int getData()
	{
		return data;
	}

	/*
	 * Modifie la donnee
	 */

	public void setData(int data)
	{
		this.data = data;
	}

	/*
	 * Retourne le maillon suivant.
	 */

	public ListeInt getNext()
	{
		return next;
	}

	/*
	 * Modifie le maillon suivant
	 */

	public void setNext(ListeInt next)
	{
		this.next = next;
	}

	/*
	 * Retourne une représentation sous forme de chaine de la liste.
	 */

	public String toString()
	{
		String res = "" + data;
		if (next != null)
			res += " -> " + next.toString();
		return res;
	}

	/*
	 * Teste le fonctionnement de la liste.
	 */

	public static void main(String[] args)
	{
		ListeInt l = aleatoire(20);
		System.out.println(l);
	}

}
