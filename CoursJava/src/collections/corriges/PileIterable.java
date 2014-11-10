package collections.corriges;

import java.util.Iterator;

import collections.corriges.Pile.PileVideException;

public class PileIterable<T> extends Pile<T>
{
	/*
	 * Retourne un iterateur sur la pile.
	 */

	public Iterator<T> iterator()
	{
		return ((ListeIterable<T>) l).iterator();
	}

	public void empile(T data)
	{
		l = new ListeIterable<T>(data, l);
	}

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

	public String toString()
	{
		String res = "";
		for(T m : (ListeIterable<T>)l)
			res += m + " ";
		return res;	
	}

	public static void main(String[] args)
	{
		Pile<Integer> p = new PileIterable<Integer> ();
		int i = 0;
		while(i < 20)
			p.empile(i++);
		System.out.println(p);
		while(!p.estVide())
		{
			try
			{
				System.out.println(p.sommet());
			}
			catch(PileVideException e)
			{
				System.out.println(e);
			}
			p.depile();
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
	 * Retourne un iterateur sur la liste.
	 */

	public Iterator<T> iterator()
	{
		return new MyIterator<T>(this);
	}

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

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

	public boolean hasNext()
	{
		return l != null;
	}

	public T next()
	{
		Liste<T> temp = l;
		l = l.getNext();
		return temp.getData();
	}

	public void remove()
	{
	}
}
