package heritage;

import java.util.ArrayList;
import java.util.Random;

public class TableauInt
{
	private ArrayList<Integer> t;

	public TableauInt()
	{
		t = new ArrayList<>();
	}

	public TableauInt(TableauInt other)
	{
		t = new ArrayList<>();
		for (int i = 0 ; i < other.taille() ; i++)
			t.add(other.get(i));
	}

	public int taille()
	{
		return t.size();
	}

	public TableauInt copie()
	{
		return new TableauInt(this);
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

	public int get(int index)
	{
		return t.get(index);
	}

	public void set(int index, int value)
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
		int temp = get(i);
		set(i, get(j));
		set(j, temp);
	}

	public void triSelection()
	{
		for (int i = 0 ; i < taille() - 1 ; i++)
		{
			int indiceMin = i;
			for (int j = i + 1 ; j < taille() ; j++)
				if (get(indiceMin) > get(j))
					indiceMin = j;
			echange(i, indiceMin);
		}
	}

	public static void main(String[] args)
	{
		int n = 10 ;
		Random r = new Random();
		TableauInt tab = new TableauInt();
		for (int i = 0; i < n; i++)
			tab.set(i, r.nextInt() % 100);
		System.out.println(tab);
		tab.triSelection();
		System.out.println(tab);
	}	
}