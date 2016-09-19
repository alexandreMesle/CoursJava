package heritage;

public abstract class Devise
{
	private double somme = 0;

	/*
	 * Nombre de devises pour 1$.
	 */
	
	public abstract double getCours();

	public abstract String getUnite();

	public void setSomme(Devise d)
	{
		this.somme = d.somme * this.getCours() / d.getCours();
	}

	public void setSomme(double somme)
	{
		this.somme = somme;
	}

	public double getSomme()
	{
		return somme;
	}
	
	public String toString()
	{
		return "somme = " + somme + " " + getUnite();
	}

	public static void main(String[] args)
	{
		Devise d = new Dollars(12);
		System.out.println(d);
		Euros e = new Euros(d);
		System.out.println(e);
		Livres l = new Livres(e);
		System.out.println(l);
		Dollars dBis = new Dollars(l);
		System.out.println(dBis);
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

	@Override
	public double getCours()
	{
		return 0.76636574;
	}

	@Override
	public String getUnite() 
	{
		return "Livres";
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

	@Override
	public double getCours()
	{
		return 0.895744319;
	}

	@Override
	public String getUnite() 
	{
		return "Euros";
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

	@Override
	public double getCours()
	{
		return 1.;
	}

	@Override
	public String getUnite() 
	{
		return "Dollars";
	}
}
