package classes;

public class Rationnel
{
    public int num, den;
    
    /*-----------------------------------------------*/

    public String toString()
    {
	return num + "/" + den;
    }
    
    /*-----------------------------------------------*/

    public Rationnel copy()
    {
	Rationnel r = new Rationnel();
	r.num = num;
	r.den = den;
	return r;
    }
    
    /*-----------------------------------------------*/

    public Rationnel opposite()
    {
	Rationnel r = copy();
	r.num = -r.num;
	return r;
    }
    
    /*-----------------------------------------------*/
    
    private int pgcd(int a, int b)
    {
	if (b == 0)
	    return a;
	return pgcd(b, a%b);
    }

    public Rationnel reduce()
    {
	Rationnel r = copy();
	int p = pgcd(num, den);
	r.num/=p;
	r.den/=p;
	return r;
    }
    
    /*-----------------------------------------------*/

    public boolean isPositive()
    {
	return num > 0 && den > 0 || num < 0 && den < 0;
    }
    
    /*-----------------------------------------------*/

    public Rationnel add(Rationnel other)
    {
	Rationnel res = new Rationnel();
	res.num = num*other.den + den*other.num;
	res.den = den * other.den ;
	return res.reduce();
    }
    
    /*-----------------------------------------------*/

    public Rationnel multiply(Rationnel other)
    {
	Rationnel res = new Rationnel();
	res.num = num*other.num;
	res.den = den * other.den ;
	return res.reduce();
    }

    /*-----------------------------------------------*/

    public Rationnel divide(Rationnel other)
    {
	Rationnel res = new Rationnel();
	res.num = num*other.den;
	res.den = den * other.num ;
	return res.reduce();
    }

    /*-----------------------------------------------*/

    public int compareTo(Rationnel other)
    {
	Rationnel sub = add(other.opposite());
	if (sub.isPositive())
	    return 1;
	if (sub.opposite().isPositive())
	    return -1;
	return 0;
    }

    /*-----------------------------------------------*/    

    public static void main(String[] args)
    {
	Rationnel a, b;
	a = new Rationnel();
	b = new Rationnel();
	a.num = 1;
	a.den = 2;
	b.num = 4; 
	b.den = 3;
	System.out.println("a = 1/2 = " + a);
	System.out.println("b = 4/3 = " + b);
	System.out.println("compareTo(" + a + ", " + 
			   b + ") = -1 = " + a.compareTo(b));
	System.out.println("1/2 = " + a.copy());
	System.out.println("-1/2 = " + a.opposite());
	System.out.println("11/6 = " + a.add(b));
	System.out.println("2/3 = " + a.multiply(b));
	System.out.println("3/8 = " + a.divide(b));
    }
}
