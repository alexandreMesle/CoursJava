package collections;

public class ExempleComparable implements Comparable<ExempleComparable>
{
	private String data;
	
	public ExempleComparable(String data)
	{
		this.data = data;
	}
	
	protected String getData()
	{
		return data;
	}

	protected void setData(String data)
	{
		this.data = data;
	}

	@Override
	public int compareTo(ExempleComparable autre)
	{
		return data.compareTo(autre.getData());
	}

	public static void main(String[] args)
	{
		ExempleComparable e1 = new ExempleComparable("toto"),
				e2 = new ExempleComparable("tutu");
		System.out.println(e1.compareTo(e2));
	}
}
