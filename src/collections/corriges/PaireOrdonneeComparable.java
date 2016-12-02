package collections.corriges;

public class PaireOrdonneeComparable<T extends Comparable<T>> extends
		PaireOrdonnee<T> implements Comparable<PaireOrdonnee<T>>
{
	public PaireOrdonneeComparable(T first, T second)
	{
		super(first, second);
	}

	@Override
	public int compareTo(PaireOrdonnee<T> other)
	{
		return getGrand().compareTo(other.getGrand());
	}
}
