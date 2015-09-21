package heritage.classesAbstraitesInterfaces;

import heritage.Comparable;
import heritage.corriges.TableauComparable;

public class Main
{
    public static void main(String[] args)
    {
	TableauComparable t = new TableauComparable(3);
	t.set(0, new ChatComparable("Ronron"));
	t.set(1, new ChienComparable("Médor"));
	t.set(2, new VacheComparable("Huguette"));
	System.out.println(t); 
	t.triSelection();
	System.out.println(t); 
	
	t = new TableauComparable(4);
	t.set(0, new EurosComparable(5));
	t.set(1, new DollarsComparable(5));
	t.set(2, new LivresComparable(5));
	t.set(3, new EurosComparable(2));
	System.out.println(t); 
	t.triSelection();
	System.out.println(t); 
    }
}

abstract class AnimalComparable implements Comparable
{
    private String nom;
    
    public AnimalComparable(String nom)
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
	return nom.compareTo(((AnimalComparable)other).getNom());
    }

    public String toString()
    {
	return getNom();
    }
}

class ChatComparable extends AnimalComparable
{
    private String nom;

    public ChatComparable(String nom)
    {
	super(nom);
    }    

    public String parle()
    {
	return "Miaou !";
    }

}

class ChienComparable extends AnimalComparable
{
    public ChienComparable(String nom)
    {
	super(nom);
    }    

    public String parle()
    {
	return "Waf !";
    }

}

class VacheComparable extends AnimalComparable
{
    private String nom;

    public VacheComparable(String nom)
    {
	super(nom);
    }    

    public String parle()
    {
	return "Meuh !";
    }

}

abstract class DeviseComparable implements Comparable
{
    private double somme = 0;

    public abstract double getCours();
    
    public void setSomme(DeviseComparable d)
    {
	this.somme = d.getSomme()*d.getCours()/this.getCours();
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
	return "somme = " + somme + " ";
    }

    public int compareTo(Comparable other)
    {
    	Double thisDollar = (new DollarsComparable(this)).getSomme(),
    		otherDollar = (new DollarsComparable((DeviseComparable)other)).getSomme(); 
    	return thisDollar.compareTo(otherDollar);
    }
}

class LivresComparable extends DeviseComparable
{
    public LivresComparable(DeviseComparable d)
    {
	setSomme(d);
    }

    public LivresComparable(double somme)
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

class EurosComparable extends DeviseComparable
{
    public EurosComparable(DeviseComparable d)
    {
	setSomme(d);
    }

    public EurosComparable(double somme)
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

class DollarsComparable extends DeviseComparable
{
    public DollarsComparable(DeviseComparable d)
    {
	setSomme(d);
    }

    public DollarsComparable(double somme)
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

