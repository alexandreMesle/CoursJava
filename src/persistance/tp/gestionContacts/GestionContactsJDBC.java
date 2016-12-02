package persistance.tp.gestionContacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilitaires.EntreesSorties;

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

	@Override
	public void setNom(String nom)
	{
		try
		{
			PreparedStatement s = connexion
					.prepareStatement("update contact set nomContact = ? where numContact = ?");
			s.setString(1, nom);
			s.setInt(2, getNumContact());
			s.executeUpdate();
			super.setNom(nom);
		}
		catch (SQLException e)
		{
			System.out.println("Connexion perdue !");
		}
	}

	@Override
	public void setEMail(String email)
	{
		try
		{
			PreparedStatement s = connexion
					.prepareStatement("update contact set eMailContact  = ? where numContact = ?");
			s.setString(1, email);
			s.setInt(2, getNumContact());
			s.executeUpdate();
			super.setEMail(email);
		}
		catch (SQLException e)
		{
			System.out.println("Connexion perdue !");
		}
	}
}

class ListeContactsJDBC extends ListeContacts
{
	private static final long serialVersionUID = -8830007898666104116L;
	private Connection connexion = null;

	public ListeContactsJDBC()
	{
		lire();
	}

	private void initialiserDB() throws SQLException
	{
		Statement s = connexion.createStatement();
		s.executeUpdate("create table contact("
				+ "numContact int primary key auto_increment, "
				+ "nomContact varchar(64), " + "eMailContact varchar(64))");
		System.out.println("Base de données créée avec succès.");
	}

	private void lire()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/emails", user = "emails", password = "emails";
			connexion = DriverManager.getConnection(url, user, password);
			connexion.setAutoCommit(false);
			String req = "select * from contact";
			Statement s = connexion.createStatement();
			ResultSet rs = s.executeQuery(req);
			while (rs.next())
				super.ajouter(new ContactJDBC(rs.getInt(1), rs.getString(2), rs
						.getString(3), connexion));
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non installé.");
		}
		catch (SQLException e)
		{
			try
			{
				System.out.println("Création de la base de données.");
				initialiserDB();
				lire();
			}
			catch (SQLException e1)
			{
				System.out.println("Impossible de créer les données : ");
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void ajouter(String nom, String email)
	{
		try
		{
			PreparedStatement s = connexion
					.prepareStatement(
							"insert into contact (nomContact, eMailContact) values (?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			s.setString(1, nom);
			s.setString(2, email);
			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.next();
			super.ajouter(new ContactJDBC(rs.getInt(1), nom, email, connexion));
		}
		catch (SQLException e)
		{
			System.out.println("Connexion perdue !");
		}
	}

	public void supprimer(Contact contact)
	{
		try
		{
			PreparedStatement s = connexion
					.prepareStatement("delete from contact where numContact = ?");
			s.setInt(1, ((ContactJDBC) contact).getNumContact());
			s.executeUpdate();
			super.supprimer(contact);
			System.out.println("Suppression !");
		}
		catch (SQLException e)
		{
			System.out.println("Connexion perdue !");
			EntreesSorties.afficheException(e);
		}
	}

	public void fermer()
	{
		try
		{
			if (connexion != null)
				connexion.close();
		}
		catch (SQLException e)
		{
			System.out.println("Impossible de fermer la connection.");
		}
	}

	@Override
	public void ecrire()
	{
		try
		{
			connexion.commit();
		}
		catch (SQLException e)
		{
			System.out.println("Impossible d'enregistrer les modifications.");
		}
		finally
		{
			fermer();
		}
	}

	@Override
	public void annuler()
	{
		try
		{
			connexion.rollback();
		}
		catch (SQLException e)
		{
			System.out.println("Impossible d'annuler les modifications.");
		}
		finally
		{
			fermer();
		}
	}

	@Override
	public String toString()
	{
		return "contacts JDBC :\n" + super.toString();
	}
}

public class GestionContactsJDBC
{
	public static void main(String[] args)
	{
		new GestionContacts(new ListeContactsJDBC());
	}
}
