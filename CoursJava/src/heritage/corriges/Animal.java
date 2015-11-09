package heritage.corriges;

public interface Animal
{
	public void setNom(String nom);

	public String getNom();

	public String parle();

}

class Main
{
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

class Chat implements Animal
{
	private String nom;

	public Chat(String nom)
	{
		this.nom = nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public String parle()
	{
		return "Miaou !";
	}

}

class Vache implements Animal
{
	private String nom;

	public Vache(String nom)
	{
		this.nom = nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public String parle()
	{
		return "Meuh !";
	}
}

class Chien implements Animal
{
	private String nom;

	public Chien(String nom)
	{
		this.nom = nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public String parle()
	{
		return "Waf !";
	}

}
