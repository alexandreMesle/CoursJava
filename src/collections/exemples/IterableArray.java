package collections.exemples;

import java.util.Iterator;

public class IterableArray implements Iterable<Integer>
{
	private final int TAILLE;
	private int[] tableau;

	public IterableArray(int taille)
	{
		this.TAILLE = taille;
		tableau = new int[taille];
	}

	public void set(int i, int data)
	{
		tableau[i] = data;
	}

	public int get(int i)
	{
		return tableau[i];
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>()
		{
			private int index = 0;

			@Override
			public boolean hasNext()
			{
				return index < TAILLE;
			}

			@Override
			public Integer next()
			{
				int item = get(index);
				index++;
				return item;
			}

			@Override
			public void remove()
			{
				for (int i = index; i < TAILLE; i++)
					set(i, get(i + 1));
			}
		};
	}

	public static void main(String[] args)
	{
		IterableArray tab = new IterableArray(10);
		for (int i = 0; i < 10; i++)
			tab.set(i, i + 1);
		for (int value : tab)
			System.out.println(value);
	}
}
