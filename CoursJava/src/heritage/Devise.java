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
		Devise devise = new Dollars(12);
		System.out.println(devise);
		devise = new Euros(devise);
		System.out.println(devise);
		devise = new Livres(devise);
		System.out.println(devise);
		devise = new Livres(devise);
		System.out.println(devise);
		devise = new Dollars(devise);
		System.out.println(devise);
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
