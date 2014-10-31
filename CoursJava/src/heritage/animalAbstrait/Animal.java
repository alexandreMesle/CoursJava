package heritage.animalAbstrait;

public abstract class Animal
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

	public static void main(String[] args)
	{
		Animal a = new Chat("Ronron");
		Animal b = new Chien("Médor");
		Animal c = new Vache("Huguette");
		System.out.println(a.parle());
		System.out.println(b.parle());
		System.out.println(c.parle());
	}
}

class Chat extends Animal
{
	public Chat(String nom)
	{
		super(nom);
	}

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

	public String parle()
	{
		return "Meuh !";
	}
}
