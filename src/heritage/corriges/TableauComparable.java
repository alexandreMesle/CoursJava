package heritage.corriges;

import java.util.ArrayList;

import heritage.Comparable;

public class TableauComparable
{
	private ArrayList<Comparable> t;

	public TableauComparable()
	{
		t = new ArrayList<>();
	}

	public TableauComparable(TableauComparable other)
	{
		t = new ArrayList<>();
		for (int i = 0 ; i < other.taille() ; i++)
			t.add(other.get(i));
	}

	public int taille()
	{
		return t.size();
	}

	public TableauComparable copie()
	{
		return new TableauComparable(this);
	}

	public String toString()
	{
		String res = "[";
		if (taille() >= 1)
			res += get(0);
		for (int i = 1 ; i < taille() ; i++)
			res += ", " + get(i);
		res += "]";
		return res;
	}

	public Comparable get(int index)
	{
		return t.get(index);
	}

	public void set(int index, Comparable value)
	{
		int n = taille();
		if (index < n)
			t.set(index, value);
		if (index == n)
			t.add(value);
		if (index > n)
			System.out.println("Achtung !");
	}

	public void echange(int i, int j)
	{
		Comparable temp = get(i);
		set(i, get(j));
		set(j, temp);
	}

	public void triSelection()
	{
		for (int i = 0 ; i < taille() - 1 ; i++)
		{
			int indiceMin = i;
			for (int j = i + 1 ; j < taille() ; j++)
				if (get(indiceMin).compareTo(get(j)) > 0)
					indiceMin = j;
			echange(i, indiceMin);
		}
	}
}
