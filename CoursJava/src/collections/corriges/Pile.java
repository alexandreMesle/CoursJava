package collections.corriges;

public class Pile<T>
{
	/*
	 * Liste contenant les elements de la pile.
	 */

	protected Liste<T> l;

	/*
	 * Constructeur
	 */

	Pile()
	{
		l = null;
	}

	/*
	 * Retourne vrai si et seulement si la pile est vide
	 */

	public boolean estVide()
	{
		return l == null;
	}

	/*
	 * Retourne l'element se trouvant au sommet de la pile.
	 */

	public T sommet() throws PileVideException
	{
		if (!estVide())
			return l.getData();
		throw new PileVideException();
	}

	/*
	 * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
	 * pile est vide.
	 */

	public void depile()
	{
		if (!estVide())
			l = l.getNext();
	}

	/*
	 * Ajoute data en haut de la pile.
	 */

	public void empile(T data)
	{
		l = new Liste<T>(data, l);
	}

	public static class PileVideException extends Exception
	{
		public String toString()
		{
			return "Can't top an empty stack.";
		}
	}

	/*
	 * Teste le fonctionnement de la pile.
	 */

	public static void main(String[] args)
	{
		Pile<Integer> p = new Pile<Integer>();
		int i = 0;
		while (i < 20)
			p.empile(i++);
		while (!p.estVide())
		{
			try
			{
				System.out.println(p.sommet());
			}
			catch (PileVideException e)
			{
				System.out.println(e);
			}
			p.depile();
		}
	}
}

class Liste<T>
{
	/*
	 * Donnee stockee dans le maillon
	 */

	private T data;

	/*
	 * Pointeur vers le maillon suivant
	 */

	private Liste<T> next;

	/*
	 * Constructeur initialisant la donnee et le pointeur vers l'element
	 * suivant.
	 */

	Liste(T data, Liste<T> next)
	{
		this.data = data;
		this.next = next;
	}

	/*
	 * Constructeur initialisant la donnee et mettant le suivant a null.
	 */

	Liste(T data)
	{
		this(data, null);
	}

	/*
	 * Retourne la donnee.
	 */

	public T getData()
	{
		return data;
	}

	/*
	 * Modifie la donnee
	 */

	public void setData(T data)
	{
		this.data = data;
	}

	/*
	 * Retourne le maillon suivant.
	 */

	public Liste<T> getNext()
	{
		return next;
	}

	/*
	 * Modifie le maillon suivant
	 */

	public void setNext(Liste<T> next)
	{
		this.next = next;
	}

	/*
	 * Retourne une représentation sous forme de chaine de la liste.
	 */

	@Override
	public String toString()
	{
		String res = "" + data;
		if (next != null)
			res += " -> " + next.toString();
		return res;
	}
}
