package persistance.tp.rememberMyName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JDBC extends RememberMyName
{
	protected static final String URL = "jdbc:mysql://localhost/rememberMyName",
			USER = "rememberMyUser",
			PASSWORD = "rememberMyPassword",
			FIELD = "userField",
			TABLE = "userTable",
			CREATE_SCRIPT = "CREATE TABLE " + TABLE + "(" + FIELD
					+ " varchar(64))";
	protected Connection c;

	protected void openJDBCConnection() throws ClassNotFoundException,
			SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	protected void closeJDBCConnection() throws SQLException
	{
		if (c != null)
			c.close();
	}

	protected ResultSet readNameFromDb() throws SQLException
	{
		Statement s = c.createStatement();
		return s.executeQuery("select " + FIELD + " from " + TABLE);
	}

	@Override
	public String getNameFromSupport() throws ReadException
	{
		try
		{
			openJDBCConnection();
			ResultSet rs = readNameFromDb();
			if (rs.next())
				return rs.getString(1);
			else
				throw new ReadException(null);
		}
		catch (SQLException | ClassNotFoundException e)
		{
			throw new ReadException(e);
		}
		finally
		{
			try
			{
				closeJDBCConnection();
			}
			catch (SQLException e)
			{
				System.out.println("Error while closing database connection");
			}
		}
	}

	protected void writeNameToDb(String name) throws SQLException
	{
		PreparedStatement ps = c.prepareStatement("insert into " + TABLE
				+ " values (name)");
		ps.setString(1, name);
		ps.executeUpdate();
	}

	@Override
	public void writeNameToSupport(String name) throws WriteException
	{
		try
		{
			openJDBCConnection();
			Statement s = c.createStatement();
			s.execute(CREATE_SCRIPT);
			writeNameToDb(name);
		}
		catch (SQLException | ClassNotFoundException e)
		{
			throw new WriteException(e);
		}
		finally
		{
			try
			{
				closeJDBCConnection();
			}
			catch (SQLException e)
			{
				System.out.println("Error while closing database connection");
			}
		}
	}

	public static void main(String[] args)
	{
		RememberMyName rmn = new JDBC();
		rmn.printName();
	}
}
