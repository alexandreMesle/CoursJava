package heritage.animalAbstrait;

import java.util.ArrayList;

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

	public abstract String cri();

	public static void main(String[] args)
	{
		ArrayList<Animal> animaux = new ArrayList<>();
		animaux.add(new Chat("Ronron"));
		animaux.add(new Chien("Médor"));
		animaux.add(new Vache("Huguette"));
		for (Animal animal : animaux)
			System.out.println(animal.cri());
	}
}

class Chat extends Animal
{
	public Chat(String nom)
	{
		super(nom);
	}

	@Override
	public String cri()
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
	public String cri()
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
	public String cri()
	{
		return "Meuh !";
	}
}
