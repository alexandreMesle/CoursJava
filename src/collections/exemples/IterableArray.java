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
			private int index = -1;

			@Override
			public boolean hasNext()
			{
				index++;
				return index < TAILLE;
			}

			@Override
			public Integer next()
			{
				return get(index);
			}

			@Override
			public void remove()
			{
				for (int i = index; i < TAILLE - 1; i++)
					set(i, get(i + 1));
				set(TAILLE - 1, 0);
				index --;
			}
		};
	}

	public static void main(String[] args)
	{
		IterableArray tab = new IterableArray(10);
		for (int i = 0; i < 10; i++)
			tab.set(i, i + 1);
		
		Iterator<Integer> iterator = tab.iterator();
		while (iterator.hasNext()) 
		{
			int value = iterator.next();
			if (value % 2 != 0)
				iterator.remove();
		}		
		for (int value : tab)
			System.out.println(value);
	}
}
