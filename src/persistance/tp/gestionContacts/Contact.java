package persistance.tp.gestionContacts;

import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact>
{
	private static final long serialVersionUID = 692955532183439742L;
	private String nom, eMail;

	public Contact(String nom, String eMail)
	{
		super();
		this.nom = nom;
		this.eMail = eMail;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String geteMail()
	{
		return eMail;
	}

	public void setEMail(String eMail)
	{
		this.eMail = eMail;
	}

	@Override
	public int compareTo(Contact autre)
	{
		return getNom().compareTo(autre.getNom());
	}

	@Override
	public String toString()
	{
		return nom + " " + eMail;
	}
}
