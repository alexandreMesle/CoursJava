package classes;

import java.util.Random;
import java.lang.Math;
import classes.Rationnel;

public class TableauRationnel
{
	Rationnel[] t;

	/*-----------------------------------------------*/

	public void init(int taille)
	{
		t = new Rationnel[taille];
		Random r = new Random();
		for (int i = 0; i < taille; i++)
		{
			t[i] = new Rationnel();
			t[i].num = r.nextInt() % 10;
			t[i].den = Math.abs(r.nextInt() % 10) + 1;
		}
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

	public void echange(int i, int j)
	{
		Rationnel temp = t[i];
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
				if (t[indiceMin].compareTo(t[j]) > 1)
					indiceMin = j;
			echange(i, indiceMin);
		}
	}

	/*-----------------------------------------------*/

	public boolean ordonne(int i, int j)
	{
		if ((i - j) * (t[i].compareTo(t[j])) < 0)
		{
			echange(i, j);
			return true;
		}
		return false;
	}

	/*-----------------------------------------------*/

	public void triInsertion()
	{
		for (int i = 1; i < t.length; i++)
		{
			int j = i;
			while (j > 0 && ordonne(j - 1, j))
				j--;
		}
	}

	/*-----------------------------------------------*/

	public void triBulle()
	{
		for (int i = t.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				ordonne(j, j + 1);
	}

	/*-----------------------------------------------*/

	public void initTab(TableauRationnel other)
	{
		t = new Rationnel[other.t.length];
		for (int i = 0; i < t.length; i++)
			t[i] = other.t[i];
	}

	/*-----------------------------------------------*/

	public TableauRationnel copie()
	{
		TableauRationnel other = new TableauRationnel();
		other.initTab(this);
		return other;
	}

	/*-----------------------------------------------*/

	public void interclasse(TableauRationnel t1, TableauRationnel t2)
	{
		t = new Rationnel[t1.t.length + t2.t.length];
		int i1 = 0, i2 = 0, i = 0;
		while (i < t.length)
		{
			if (i1 == t1.t.length)
				t[i++] = t2.t[i2++].copie();
			else if (i2 == t2.t.length)
				t[i++] = t1.t[i1++].copie();
			else if (t1.t[i1].compareTo(t2.t[i2]) < 0)
				t[i++] = t1.t[i1++].copie();
			else
				t[i++] = t2.t[i2++].copie();
		}
	}

	/*-----------------------------------------------*/

	public static void main(String[] args)
	{
		TableauRationnel t = new TableauRationnel();
		t.init(10);
		System.out.println(t);
		t.triInsertion();
		System.out.println(t);
		t.triSelection();
		System.out.println(t);
		t.triBulle();
		System.out.println(t);
		TableauRationnel tBis = new TableauRationnel();
		tBis.initTab(t);
		System.out.println(tBis);
		tBis = t.copie();
		System.out.println(tBis);
		tBis.init(10);
		System.out.println(tBis);
		TableauRationnel tTer = new TableauRationnel();
		tBis.triInsertion();
		System.out.println(tBis);
		tTer.interclasse(t, tBis);
		System.out.println(tTer);
		tTer.triInsertion();
		System.out.println(tTer);
	}
}
