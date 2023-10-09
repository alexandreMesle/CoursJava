package heritage.tpPointCercle.corrige;

public class Point
{
	private double abs, ord;

	Point(double abs, double ord)
	{
		this.abs = abs;
		this.ord = ord;
	}

	public double getAbs()
	{
		return abs;
	}

	public double getOrd()
	{
		return ord;
	}

	public void setAbs(double abs)
	{
		this.abs = abs;
	}

	public void setOrd(double ord)
	{
		this.ord = ord;
	}

	// exercice 4
	
	@Override
	public String toString()
	{
		return "(abs = " + abs + " ; ord = " + ord + ")";
	}
}

class Cercle extends Point
{
	private double rayon = 0;

	public Cercle(double abs, double ord, double rayon)
	{
		super(abs, ord);
		setRayon(rayon);
	}

	public Cercle(Point centre, double rayon)
	{
		this(centre.getAbs(), centre.getOrd(), rayon);
	}

	public double getRayon()
	{
		return rayon;
	}

	public void setRayon(double rayon)
	{
		if (rayon > 0)
			this.rayon = rayon;
	}

	@Override
	public String toString()
	{
		return "(centre = " + super.toString() +
				"; rayon = " + getRayon() + ")";
	}
	
}

