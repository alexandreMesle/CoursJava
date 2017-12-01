package hibernate.gestionContacts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Contact
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private String nom;

	private String prenom;

	Contact()
	{
	}

	public Contact(String prenom, String nom)
	{
		this.nom = nom;
		this.prenom = prenom;
	}

	int getNum()
	{
		return num;
	}

	void setNum(int num)
	{
		this.num = num;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	@Override
	public String toString()
	{
		return prenom + " " + nom;
	}
}
