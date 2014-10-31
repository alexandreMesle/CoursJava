package heritage.corriges;

public class Point
{
    private double abs, ord;
    
    Point(double abs, double ord)
    {
	this.abs = abs;
	this.ord = ord;
    }

    Point()
    {
	this(0, 0);
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
    
    public String toString()
    {
	return "(" + abs + ", " + ord + ")";
    }
}
