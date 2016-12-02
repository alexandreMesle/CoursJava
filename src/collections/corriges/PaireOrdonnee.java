package collections.corriges;

public class PaireOrdonnee<T extends Comparable<T>> extends Paire<T>
{
	public PaireOrdonnee(T first, T second)
	{
		super(first, second);
	}

	public T getPetit()
	{
		T first = getFirst(), second = getSecond();
		if (first.compareTo(second) < 0)
			return first;
		else
			return second;
	}

	public T getGrand()
	{
		T first = getFirst(), second = getSecond();
		if (first.compareTo(second) >= 0)
			return first;
		else
			return second;
	}

	public static void main(String args[])
	{
		PaireOrdonnee<Integer> a = new PaireOrdonnee<Integer>(2, 7);
		System.out.println(a.getGrand());
	}
}
