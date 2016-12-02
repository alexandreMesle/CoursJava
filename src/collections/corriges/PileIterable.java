package collections.corriges;

import java.util.Iterator;

public class PileIterable<T> extends Pile<T> implements Iterable<T>
{
	/*
	 * Retourne un itérateur sur la pile.
	 */

	@Override
	public Iterator<T> iterator()
	{
		return ((ListeIterable<T>) l).iterator();
	}

	@Override
	public void empile(T data)
	{
		l = new ListeIterable<T>(data, l);
	}

	/*
	 * Retourne une représentation de la pile au format chaîne de caractères.
	 */

	@Override
	public String toString()
	{
		String res = "";
		for (T m : (ListeIterable<T>) l)
			res += m + " ";
		return res;
	}

	public static void main(String[] args)
	{
		Pile<Integer> p = new PileIterable<Integer>();
		int i = 0;
		while (i < 20)
			p.empile(i++);
		System.out.println(p);
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
	
	public static class SuppressionInterditeException extends RuntimeException
	{
		private static final long serialVersionUID = -5787906244873409640L;
		
		@Override
		public String toString()
		{
			return "Il est formellement interdit de supprimer de la pile un élément autre que le sommet, utilisez depile() pour ce faire.";
		}
	}
}

class ListeIterable<T> extends Liste<T> implements Iterable<T>
{
	ListeIterable(T data)
	{
		super(data);
	}

	ListeIterable(T data, Liste<T> next)
	{
		super(data, next);
	}

	/*
	 * Retourne un itérateur sur la liste.
	 */

	@Override
	public Iterator<T> iterator()
	{
		return new MyIterator<T>(this);
	}

	/*
	 * Retourne une représentation de la pile au format chaîne de caractères.
	 */

	@Override
	public String toString()
	{
		String res = "";
		for (T m : this)
			res += m + " ";
		return res;
	}
}

class MyIterator<T> implements Iterator<T>
{
	private Liste<T> l;

	MyIterator(Liste<T> l)
	{
		this.l = l;
	}

	@Override
	public boolean hasNext()
	{
		return l != null;
	}

	@Override
	public T next()
	{
		Liste<T> temp = l;
		l = l.getNext();
		return temp.getData();
	}


	@Override
	public void remove()
	{
		throw new PileIterable.SuppressionInterditeException();
	}
}
