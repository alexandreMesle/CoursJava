package persistance.injection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequetePreparee extends Gruyere
{
	protected ResultSet executeConnect() throws SQLException
	{
		String req = "select * from utilisateur where login = ? and password = ?";
		PreparedStatement s = c.prepareStatement(req);
		s.setString(1, login);
		s.setString(2, password);
		return s.executeQuery();
	}

	public static void main(String[] args)
	{
		Gruyere requetePreparee = new RequetePreparee();
		requetePreparee.connect();
		requetePreparee.close();
	}
}
