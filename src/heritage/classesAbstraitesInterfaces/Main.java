package heritage.classesAbstraitesInterfaces;

import heritage.Comparable;
import heritage.corriges.TableauComparable;

public class Main
{
	public static void main(String[] args)
	{
		TableauComparable t = new TableauComparable();
		t.set(0, new Chat("Ronron"));
		t.set(1, new Chien("Médor"));
		t.set(2, new Vache("Huguette"));
		System.out.println(t);
		t.triSelection();
		System.out.println(t);

		t = new TableauComparable();
		t.set(0, new Euros(5));
		t.set(1, new Dollars(5));
		t.set(2, new Livres(5));
		t.set(3, new Euros(2));
		System.out.println(t);
		t.triSelection();
		System.out.println(t);
	}
}

abstract class Animal implements Comparable
{
	private String nom;

	public Animal(String nom)
	{
		setNom(nom);
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public abstract String parle();

	public int compareTo(Comparable other)
	{
		return nom.compareTo(((Animal) other).getNom());
	}

	@Override
	public String toString()
	{
		return getNom();
	}
}

class Chat extends Animal
{
	public Chat(String nom)
	{
		super(nom);
	}

	@Override
	public String parle()
	{
		return "Miaou !";
	}

}

class Chien extends Animal
{
	public Chien(String nom)
	{
		super(nom);
	}

	@Override
	public String parle()
	{
		return "Waf !";
	}

}

class Vache extends Animal
{
	public Vache(String nom)
	{
		super(nom);
	}

	@Override
	public String parle()
	{
		return "Meuh !";
	}

}

abstract class Devise implements Comparable
{
	private double somme = 0;

	public abstract double getCours();

	public abstract String getUnite();

	public void setSomme(Devise d)
	{
		this.somme = d.getSomme() * this.getCours() / d.getCours();
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

	@Override
	public int compareTo(Comparable other)
	{
		Double thisDollar = (new Dollars(this)).getSomme(), 
				otherDollar = (new Dollars((Devise) other)).getSomme();
		return thisDollar.compareTo(otherDollar);
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
