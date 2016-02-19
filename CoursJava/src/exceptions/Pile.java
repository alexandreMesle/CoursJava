package exceptions;

public class Pile
{
	/*
	 * Liste contenant les elements de la pile.
	 */

	private Liste l;

	/*
	 * Taille de la pile
	 */

	private final int taille;

	/*
	 * Nombre d'elements dans la liste
	 */

	private int nbItems;

	/*
	 * Constructeur
	 */

	Pile(int taille)
	{
		l = null;
		this.taille = taille;
		nbItems = 0;
	}

	/*
	 * Retourne vrai si et seulement si la pile est vide
	 */

	public boolean estVide()
	{
		return nbItems == 0;
	}

	/*
	 * Retourne vrai si et seulement si la pile est pleine.
	 */

	public boolean estPleine()
	{
		return nbItems == taille;
	}

	/*
	 * Retourne l'element se trouvant au sommet de la pile.
	 */

	public Object sommet()
	{
		if (!estVide())
			return l.getData();
		throw new PileVideException();
	}

	/*
	 * Supprime l'element se trouvant au sommet de la pile.
	 */

	public void depile()
	{
		if (!estVide())
		{
			l = l.getNext();
			nbItems--;
		}
		else
			throw new PileVideException();
	}

	/*
	 * Ajoute data en haut de la pile.
	 */

	public void empile(int data)
	{
		l = new Liste(data, l);
		nbItems++;
	}

	/*
	 * Retourne une representation de la pile au format chaîne de caractères.
	 */

	public String toString()
	{
		return l.toString();
	}

	/*
	 * Teste le fonctionnement de la pile.
	 */

	public static void main(String[] args)
	{
		Pile p = new Pile(30);
		int i = 0;
		while (!p.estPleine())
			p.empile(new Integer(i++));
		System.out.println(p);
		while (!p.estVide())
		{
			System.out.println(p.sommet());
			try
			{
				p.depile();
			}
			catch (PileVideException e)
			{
				System.out.println(e);
			}
		}
	}
}

class Liste
{
	/*
	 * Donnee stockee dans le maillon
	 */

	private Object data;

	/*
	 * Pointeur vers le maillon suivant
	 */

	private Liste next;

	/*
	 * Constructeur initialisant la donnee et le pointeur vers l'element
	 * suivant.
	 */

	Liste(Object data, Liste next)
	{
		this.data = data;
		this.next = next;
	}

	/*
	 * Constructeur initialisant la donnee et mettant le suivant a null.
	 */

	Liste(Object data)
	{
		this(data, null);
	}

	/*
	 * Retourne la donnee.
	 */

	public Object getData()
	{
		return data;
	}

	/*
	 * Modifie la donnee
	 */

	public void setData(Object data)
	{
		this.data = data;
	}

	/*
	 * Retourne le maillon suivant.
	 */

	public Liste getNext()
	{
		return next;
	}

	/*
	 * Modifie le maillon suivant
	 */

	public void setNext(Liste next)
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
}
