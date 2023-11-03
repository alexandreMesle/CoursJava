package heritage.tp.animalAbstrait.sujet;

interface Animal
{
	// Setter pour le champ nom
	public void setNom(String nom);

	// Getter pour le champ nom
	public String getNom();

	// Retourne le cri de l'animal
	public String cri();
}


abstract class AbstractAnimal implements Animal
{
	private String nom;
}

class Chat
{
}

class Chien
{
}

class Vache
{
}
