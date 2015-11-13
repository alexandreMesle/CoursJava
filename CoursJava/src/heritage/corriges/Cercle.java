package heritage.corriges;

public class Cercle extends Point
{
	private double radius = 0;

	public Cercle(double abs, double ord, double radius)
	{
		super(abs, ord);
		setRadius(radius);
	}

	public Cercle(Point centre, double rayon)
	{
		this(centre.getAbs(), centre.getOrd(), 0);
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		if (radius > 0)
			this.radius = radius;
	}

	// exercice 4
	
	@Override
	public String toString()
	{
		return "( centre = " + super.toString() +
				"; rayon = " + getRadius() + ")";
	}
	
}
