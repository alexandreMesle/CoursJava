package heritage.tp.animalAbstrait.corrige;

interface Animal
{
	public void setNom(String nom);
	public String getNom();
	public String cri();
}

abstract class AbstractAnimal implements Animal
{
	private String nom;

	public AbstractAnimal(String nom)
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
}

class Chat extends AbstractAnimal
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

class Chien extends AbstractAnimal
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

class Vache extends AbstractAnimal
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
