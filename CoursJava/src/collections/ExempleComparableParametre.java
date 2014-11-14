package collections;

public class ExempleComparableParametre<T extends Comparable<T>> 
	implements Comparable<ExempleComparableParametre<T>>
{
	private T data;
	
	public ExempleComparableParametre(T data)
	{
		this.data = data;
	}
	
	protected T getData()
	{
		return data;
	}

	protected void setData(T data)
	{
		this.data = data;
	}

	@Override
	public int compareTo(ExempleComparableParametre<T> autre)
	{
		return data.compareTo(autre.getData());
	}

	public static void main(String[] args) 
	{
		ExempleComparableParametre<String> e1 = new ExempleComparableParametre<>("toto"),
				e2 = new ExempleComparableParametre<>("tutu");
		System.out.println(e1.compareTo(e2));
		ExempleComparableParametre<Integer> i1 = new ExempleComparableParametre<>(4),
				i2 = new ExempleComparableParametre<>(3);
		System.out.println(i1.compareTo(i2));
	}
}
