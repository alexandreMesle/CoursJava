package testsUnitaires.tp;

public class ImplementPoint implements InterfacePoint
{
	private int abs, ord;

	public ImplementPoint(int abs, int ord)
	{
		setAbs(abs);
		setOrd(ord);
	}

	public ImplementPoint()
	{
		this(0, 0);
	}

	@Override
	public int getOrd()
	{
		return ord;
	}

	@Override
	public int getAbs()
	{
		return abs;
	}

	@Override
	public void setOrd(int ord)
	{
		this.ord = ord;
	}

	@Override
	public void setAbs(int abs)
	{
		this.abs = abs;
	}

	@Override
	public InterfacePoint add(InterfacePoint p)
	{
		return new ImplementPoint(getAbs() + p.getAbs(), getOrd() + p.getOrd());
	}

	@Override
	public boolean equals(InterfacePoint p)
	{
		return getAbs() == p.getAbs() && getOrd() == p.getOrd();
	}
}
