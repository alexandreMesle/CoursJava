package heritage.corriges;

import heritage.Comparable;

import java.util.Random;
import java.lang.Math;

public class TableauComparable
{
	private Comparable[] t;

	/*-----------------------------------------------*/

	public TableauComparable(int taille)
	{
		t = new Comparable[taille];
	}

	/*-----------------------------------------------*/

	public TableauComparable(TableauComparable other)
	{
		t = new Comparable[other.t.length];
		for (int i = 0; i < t.length; i++)
			t[i] = other.t[i];
	}

	/*-----------------------------------------------*/

	public TableauComparable copie()
	{
		return new TableauComparable(this);
	}

	/*-----------------------------------------------*/

	public String toString()
	{
		String res = "[";
		if (t.length >= 1)
			res += t[0];
		for (int i = 1; i < t.length; i++)
			res += ", " + t[i];
		res += "]";
		return res;
	}

	/*-----------------------------------------------*/

	public Comparable get(int index)
	{
		return t[index];
	}

	/*-----------------------------------------------*/

	public void set(int index, Comparable value)
	{
		t[index] = value;
	}

	/*-----------------------------------------------*/

	public void echange(int i, int j)
	{
		Comparable temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	/*-----------------------------------------------*/

	public void triSelection()
	{
		for (int i = 0; i < t.length - 1; i++)
		{
			int indiceMin = i;
			for (int j = i + 1; j < t.length; j++)
				if (t[indiceMin].compareTo(t[j]) >= 1)
					indiceMin = j;
			echange(i, indiceMin);
		}
	}
}
