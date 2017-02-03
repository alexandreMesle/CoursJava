package persistance.tp.gestionContacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ContactJDBC extends Contact
{
	private static final long serialVersionUID = 4696699080235390470L;
	private int numContact;
	Connection connexion;

	public ContactJDBC(int numContact, String nom, String eMail,
			Connection connection)
	{
		super(nom, eMail);
		this.numContact = numContact;
		this.connexion = connection;
	}

	int getNumContact()
	{
		return numContact;
	}

	void setNumContact(int numContact)
	{
		this.numContact = numContact;
	}

	private void update()
	{
		
		try
		{
			PreparedStatement s = connexion
					.prepareStatement("update contact set nomContact = ?, eMailContact = ? where numContact = ?");
			s.setString(1, getNom());
			s.setString(2, geteMail());
			s.setInt(3, getNumContact());
			s.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println("Connexion perdue !");
		}
		
	}
	
	@Override
	public void setNom(String nom)
	{
		super.setNom(nom);
		update();
	}

	@Override
	public void setEMail(String email)
	{
		super.setEMail(email);
		update();
	}
}
