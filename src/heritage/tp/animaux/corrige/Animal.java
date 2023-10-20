package heritage.tp.animaux.corrige;

interface Animal
{
	// Getter pour le champ nom
	public void setNom(String nom);

	// Setter pour le champ nom
	public String getNom();

	// Affiche le cri de l'animal
	public String cri();
}

class Chat implements Animal
{
	private String nom;

	public Chat(String nom)
	{
		this.nom = nom;
	}

	@Override
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	@Override
	public String getNom()
	{
		return nom;
	}

	@Override
	public String cri()
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

	@Override
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	@Override
	public String getNom()
	{
		return nom;
	}

	@Override
	public String cri()
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

	@Override
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	@Override
	public String getNom()
	{
		return nom;
	}

	@Override
	public String cri()
	{
		return "Waf !";
	}
}
