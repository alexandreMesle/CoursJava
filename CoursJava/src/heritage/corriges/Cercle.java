package heritage.corriges;

public class Cercle extends Point
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

	// exercice 4
	
	@Override
	public String toString()
	{
		return "( centre = " + super.toString() +
				"; rayon = " + getRayon() + ")";
	}
	
}
