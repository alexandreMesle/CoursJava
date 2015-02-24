package persistance.injection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gruyere
{
	protected Connection c = null;
	protected String login, password;
	
	public Gruyere()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test",
					user = "",
					password = "";
			c = DriverManager.getConnection(url, user, password);
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non installé.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

	public void close()
	{
		try
		{
			if (c != null)
				c.close();
		}
		catch(SQLException e)
		{
			System.out.println("Impossible de fermer la connection.");
		}

	}
	
	protected static String getString() throws IOException
	{
		BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
		return br.readLine();
	}
	
	protected void saisitIdentifiants()
	{
		try
		{
			System.out.println("login : ");
			login = getString();
			System.out.println("password : ");
			password = getString(); 
		} 
		catch (IOException e)
		{
			System.out.println("Erreur de saisie !");
			System.exit(1);
		}
	}
	
	public boolean connect()
	{
		try
		{
			ResultSet rs = executeConnect();
			return rs.next();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	protected ResultSet executeConnect() throws SQLException
	{
		String req = "select * from utilisateur where login = '" + login 
				+ "' and password = '" + password + "'";
		Statement s = c.createStatement();
		return s.executeQuery(req);
	}
	
	public static void main(String[] args)
	{
		Gruyere gruyere = new Gruyere();
		gruyere.saisitIdentifiants();
		if (gruyere.connect())
			System.out.println("Connexion acceptée");
		else
			System.out.println("Accès refusé");
		gruyere.close();
	}
}
