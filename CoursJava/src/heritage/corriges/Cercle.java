package heritage.corriges;


public class Cercle extends Point
{
    private double radius;
    
    public Cercle(double abs, double ord, double radius)
    {
	super(abs, ord);
	this.radius = radius;
    }

    public Cercle(Point point, double rayon)
    {
	this(point.getAbs(), point.getOrd(), 0);
    }

    public Cercle()
    {
	this(0, 0, 0);
    }

    public double getRadius()
    {
	return radius;
    }

    public void setRadius(double abs)
    {
	this.radius = radius;
    }
    public String toString()
    {
	return "(" + super.toString()+  ", " + radius + ")";
    }
}
