package persistance.tp.rememberMyName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class RequetePreparee extends JDBC
{
	protected ResultSet readNameFromDb() throws SQLException
	{
		PreparedStatement s = c.prepareStatement("select " + FIELD + " from "
				+ TABLE);
		return s.executeQuery();
	}

	protected void writeNameToDb(String name) throws SQLException
	{
		PreparedStatement ps = c.prepareStatement("insert into " + TABLE
				+ " values (?)");
		ps.setString(1, name);
		ps.executeUpdate();
	}

	public static void main(String[] args)
	{
		RememberMyName rmn = new RequetePreparee();
		rmn.printName();
	}
}
