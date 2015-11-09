package heritage.corriges;

import heritage.Comparable;

import java.util.Random;

public class Heure implements Comparable
{
	private int heures, minutes;

	/*-----------------------------------------------*/

	public Heure(int heures, int minutes)
	{
		this.heures = intAbs(heures) % 24;
		this.minutes = intAbs(minutes) % 60;
	}

	/*-----------------------------------------------*/

	public Heure(Random r)
	{
		this(r.nextInt(), r.nextInt());
	}

	/*-----------------------------------------------*/

	private int intAbs(int x)
	{
		if (x > 0)
			return x;
		else
			return -x;
	}

	/*-----------------------------------------------*/

	public int getHeures()
	{
		return heures;
	}

	/*-----------------------------------------------*/

	public int getMinutes()
	{
		return minutes;
	}

	/*-----------------------------------------------*/

	public void setHeures(int heures)
	{
		this.heures = heures;
	}

	/*-----------------------------------------------*/

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	/*-----------------------------------------------*/

	public String toString()
	{
		return heures + ":" + minutes;
	}

	/*-----------------------------------------------*/

	public int enMinutes()
	{
		return 60 * heures + minutes;
	}

	/*-----------------------------------------------*/

	/*
	 * -1 si this < other 0 si this = others 1 si this > other
	 */

	public int compareTo(Comparable other)
	{
		Heure autre = (Heure) other;
		if (heures > autre.getHeures())
			return 1;
		if (heures < autre.getHeures())
			return -1;
		if (minutes > autre.getMinutes())
			return 1;
		if (minutes < autre.getMinutes())
			return -1;
		return 0;
	}

	/*-----------------------------------------------*/

	public static void main(String[] args)
	{
		int n = 10;
		Random r = new Random();
		TableauComparable tab = new TableauComparable(n);
		for (int i = 0; i < n; i++)
			tab.set(i, new Heure(r));
		System.out.println(tab);
		tab.triSelection();
		System.out.println(tab);
	}
}
