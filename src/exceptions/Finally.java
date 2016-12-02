package exceptions;

class MonException extends Exception
{
	@Override
	public String toString()
	{
		return "Fallait pas invoquer cette methode...";
	}
}

public class Finally
{
	public static void main(String[] args)
	{
		try
		{
			try
			{
				throw new MonException();
			}
			catch (MonException e)
			{
				throw new MonException();
			}
			finally
			{
				System.out.println("Tu t'afficheras quoi qu'il advienne !");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
