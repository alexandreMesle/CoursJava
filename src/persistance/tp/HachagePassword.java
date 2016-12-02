package persistance.tp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistance.injection.Gruyere;
import persistance.injection.RequetePreparee;

public class HachagePassword extends RequetePreparee
{
	private String sha1(String value)
	{
		try
		{
			MessageDigest sha1 = MessageDigest.getInstance("SHA1");
			return new String(sha1.digest(value.getBytes()));
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return value;
	}

	@Override
	protected ResultSet executeConnect() throws SQLException
	{
		password = sha1(password);
		return super.executeConnect();
	}

	public static void main(String[] args)
	{
		Gruyere requetePreparee = new HachagePassword();
		requetePreparee.connect();
		requetePreparee.close();
	}
}
