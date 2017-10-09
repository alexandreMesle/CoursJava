package persistance.injection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import commandLineMenus.rendering.examples.util.*;

public class Gruyere
{
	protected Connection c = null;
	protected String login, password;

	public Gruyere()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test", user = "", password = "";
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
		catch (SQLException e)
		{
			System.out.println("Impossible de fermer la connection.");
		}

	}

	private void saisitIdentifiants()
	{
		login = InOut.getString("login : ");
		password = InOut.getString("password : ");
	}

	public boolean connect()
	{
		saisitIdentifiants();
		boolean connexionAcceptee = false;
		try
		{
			ResultSet rs = executeConnect();
			connexionAcceptee = rs.next();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		if (connexionAcceptee)
			System.out.println("Connexion acceptée");
		else
			System.out.println("Accés refusé");
		return connexionAcceptee;
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
		gruyere.connect();
		gruyere.close();
	}
}
