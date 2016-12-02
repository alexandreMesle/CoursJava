package collections.exemples;

public class StringWrapper implements Comparable<StringWrapper>
{
	private String data;

	public StringWrapper(String data)
	{
		this.data = data;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	@Override
	public int compareTo(StringWrapper autre)
	{
		return data.compareTo(autre.getData());
	}

	public static void main(String[] args)
	{
		StringWrapper e1 = new StringWrapper("toto"), 
				e2 = new StringWrapper("tutu");
		System.out.println(e1.compareTo(e2));
	}
}
