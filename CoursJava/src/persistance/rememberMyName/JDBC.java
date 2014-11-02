package persistance.rememberMyName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JDBC extends RememberMyName
{
	private static final String URL = "jdbc:mysql://localhost/rememberMyName",
			USER = "rememberMyUser",
			PASSWORD = "rememberMyPassword",
			FIELD = "userField",
			TABLE = "userTable",
			CREATE_SCRIPT = "CREATE TABLE " + TABLE + "(" + FIELD + " varchar(64))"; 
	private Connection c;
	
	private void openJDBCConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	private void closeJDBCConnection() throws SQLException 
	{
		if (c != null)
			c.close();
	}

	@Override
	public String getNameFromSupport() throws ReadException
	{
		try
		{
			openJDBCConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select " + FIELD + " from " + TABLE);
			if (rs.next())
				return rs.getString(1);
			else
				throw new ReadException(null);
		}
		catch(SQLException | ClassNotFoundException e)
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

	@Override
	public void writeNameToSupport(String name) throws WriteException
	{
		try
		{
			openJDBCConnection();
			Statement s = c.createStatement();
			s.execute(CREATE_SCRIPT);
			PreparedStatement ps = c.prepareStatement("insert into " + TABLE + " values (?)");
			ps.setString(1, name);
			ps.executeUpdate();
		}
		catch(SQLException | ClassNotFoundException e)
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
