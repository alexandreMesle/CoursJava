package heritage;

public class ClasseFille extends ClasseMere
{
	private final int y;

	public ClasseFille(int x, int y)
	{
		super(x);
		this.y = y;
	}

	public int getY()
	{
		return y;
	}
}
