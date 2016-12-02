package collections.corriges;

import java.util.ArrayList;
import java.util.Iterator;

interface Condition<U>
{
	public boolean check(U item);
}

public class Filtre<T extends Iterable<U>, U>
{
	private final Condition<U> condition;

	public Filtre(Condition<U> filterFunction)
	{
		this.condition = filterFunction;
	}

	private class FiltreIterator implements Iterator<U>
	{
		private Iterator<U> iterator;
		private U next = null;

		FiltreIterator(Iterator<U> iterator)
		{
			this.iterator = iterator;
		}

		@Override
		public boolean hasNext()
		{
			boolean res = false;
			while (iterator.hasNext() && !res)
			{
				next = iterator.next();
				res = condition.check(next);
			}
			return res;
		}

		@Override
		public U next()
		{
			return next;
		}

		@Override
		public void remove()
		{
			iterator.remove();
		}
	}

	public Iterable<U> iterator(final T collection)
	{
		return new Iterable<U>()
		{
			@Override
			public Iterator<U> iterator()
			{
				return new FiltreIterator(collection.iterator());
			}
		};
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = -22; i <= 37; i++)
			array.add(i);
		Filtre<ArrayList<Integer>, Integer> filtre = new Filtre<>(new Pair());
		for (Integer i : filtre.iterator(array))
			System.out.println(i);
	}
}

class Pair implements Condition<Integer>
{
	@Override
	public boolean check(Integer item)
	{
		return item % 2 == 0;
	}
}