package heritage;

public abstract class Devise
{
    private double somme = 0;

    public abstract double getCours();
    
    public void setSomme(Devise d)
    {
	this.somme = d.somme*d.getCours()/this.getCours();
    }
    
    public void setSomme(double somme)
    {
	this.somme = somme;
    }
    
    public String toString()
    {
	return "somme = " + somme + " ";
    }

    public static void main(String[] args)
    {
	Dollars d = new Dollars(12);
	System.out.println(d);
	Euros e = new Euros(d);
	System.out.println(e);
	Livres l = new Livres(e);
	System.out.println(l);
    }
}

class Livres extends Devise
{
    public Livres(Devise d)
    {
	setSomme(d);
    }

    public Livres(double somme)
    {
	setSomme(somme);
    }

    public double getCours()
    {
	return 1.95842;
    }

    public String toString()
    {
	return super.toString() + " Livres";
    }
}

class Euros extends Devise
{
    public Euros(Devise d)
    {
	setSomme(d);
    }

    public Euros(double somme)
    {
	setSomme(somme);
    }

    public double getCours()
    {
	return 1.4625;
    }
    
    public String toString()
    {
	return super.toString() + " Euros";
    }
}

class Dollars extends Devise
{
    public Dollars(Devise d)
    {
	setSomme(d);
    }

    public Dollars(double somme)
    {
	setSomme(somme);
    }

    public double getCours()
    {
	return 1.;
    }
    
    public String toString()
    {
	return super.toString() + " Dollars";
    }
}

