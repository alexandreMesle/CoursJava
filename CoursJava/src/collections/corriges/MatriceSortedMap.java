package collections.corriges;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import collections.interfaces.Matrice;

class Coordonnees implements Comparable<Coordonnees>
{
	private int i, j;

	public Coordonnees(int i, int j)
	{
		this.i = i;
		this.j = j;
	}

	@Override
	public int compareTo(Coordonnees autre)
	{
		if (i != autre.i)
			return i - autre.i;
		else
			return j - autre.j;
	}
}

public class MatriceSortedMap<T> implements Matrice<T>
{
	private SortedMap<Coordonnees, T> matrice = new TreeMap<>();
	private int nbLignes, nbColonnes;

	public MatriceSortedMap(int nbLignes, int nbColonnes)
	{
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}

	@Override
	public Iterator<T> iterator()
	{
		return matrice.values().iterator();
	}

	private T get(Coordonnees c)
	{
		return matrice.get(c);
	}

	private void set(Coordonnees c, T value)
	{
		matrice.put(c, value);
	}

	@Override
	public T get(int i, int j)
	{
		return get(new Coordonnees(i, j));
	}

	@Override
	public void set(int i, int j, T value)
	{
		set(new Coordonnees(i, j), value);
	}

	@Override
	public String toString()
	{
		String str = "";
		for (int i = 0; i < nbLignes; i++)
		{
			for (int j = 0; j < nbColonnes; j++)
				str += get(i, j) + " ";
			str += "\n";
		}
		return str;
	}

	public static void main(String[] args)
	{
		MatriceSortedMap<Integer> matrice = new MatriceSortedMap<>(3, 3);
		matrice.set(0, 0, 4);
		matrice.set(1, 2, 3);
		matrice.set(2, 0, 5);
		for (int k : matrice)
			System.out.println(k);
	}
}
