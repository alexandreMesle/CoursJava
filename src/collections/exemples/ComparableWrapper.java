package collections.exemples;

public class ComparableWrapper<T extends Comparable<T>> 
	implements Comparable<ComparableWrapper<T>>
{
	private T data;

	public ComparableWrapper(T data)
	{
		this.data = data;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	@Override
	public int compareTo(ComparableWrapper<T> autre)
	{
		return data.compareTo(autre.getData());
	}

	public static void main(String[] args)
	{
		ComparableWrapper<String> e1 = new ComparableWrapper<>("toto"), 
				e2 = new ComparableWrapper<>("tutu");
		System.out.println(e1.compareTo(e2));
		ComparableWrapper<Integer> i1 = new ComparableWrapper<>(4), 
				i2 = new ComparableWrapper<>(3);
		System.out.println(i1.compareTo(i2));
	}
}
