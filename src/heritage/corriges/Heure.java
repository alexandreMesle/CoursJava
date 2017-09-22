package heritage.corriges;

import heritage.Comparable;

import java.util.Random;

public class Heure implements Comparable
{
	private int heures, minutes;

	public Heure(int heures, int minutes)
	{
		this.heures = valeurAbsolue(heures) % 24;
		this.minutes = valeurAbsolue(minutes) % 60;
	}

	public Heure(Random r)
	{
		this(r.nextInt(), r.nextInt());
	}

	private int valeurAbsolue(int x)
	{
		if (x < 0)
			return -x;
		return x;
	}

	public int getHeures()
	{
		return heures;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public void setHeures(int heures)
	{
		this.heures = heures;
	}

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	@Override
	public String toString()
	{
		return heures + ":" + minutes;
	}

	public int enMinutes()
	{
		return 60 * heures + minutes;
	}

	@Override
	public int compareTo(Comparable other)
	{
		return this.enMinutes() - ((Heure) other).enMinutes();
	}

	public static void main(String[] args)
	{
		int n = 10;
		Random r = new Random();
		TableauComparable tab = new TableauComparable();
		for (int i = 0; i < n; i++)
			tab.set(i, new Heure(r));
		System.out.println(tab);
		tab.triSelection();
		System.out.println(tab);
	}
}
