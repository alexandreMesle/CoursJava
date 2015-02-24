package persistance.injection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HachagePassword extends RequetePreparee
{
	private String md5(String value)
	{
		try
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return new String(md5.digest(value.getBytes()));
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
		password = md5(password);
		return super.executeConnect();
	}
	
	public static void main(String[] args)
	{
		Gruyere requetePreparee = new HachagePassword();
		requetePreparee.saisitIdentifiants();
		if (requetePreparee.connect())
			System.out.println("Connexion acceptée");
		else
			System.out.println("Accès refusé");
		requetePreparee.close();
	}
}
