package collections.corriges;

public class Paire<T>
{
	private T first;
	private T second;

	protected T getFirst()
	{
		return first;
	}

	protected T getSecond()
	{
		return second;
	}

	public Paire(T first, T second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}
}
