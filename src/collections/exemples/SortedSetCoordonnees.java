package collections.exemples;

import java.util.SortedSet;
import java.util.TreeSet;

class Coordonnees implements Comparable<Coordonnees>
{
	private int x, y;

	public Coordonnees(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		return x + " " + y;
	}

	@Override
	public int compareTo(Coordonnees autre)
	{
		if (x == autre.x)
			return y - autre.y;
		return x - autre.x;
	}
}

public class SortedSetCoordonnees
{
	public static void main(String[] args)
	{
		SortedSet<Coordonnees> cases = new TreeSet<>();
		cases.add(new Coordonnees(1, 6));
		cases.add(new Coordonnees(7, 3));
		cases.add(new Coordonnees(-2, 5));
		cases.add(new Coordonnees(1, 5));
		for (Coordonnees c : cases)
			System.out.println(c);
	}
}
