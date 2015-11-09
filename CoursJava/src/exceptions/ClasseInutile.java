package exceptions;

public class ClasseInutile
{
	public void nePasInvoquer() throws ExceptionInutile
	{
		throw new ExceptionInutile();
	}

	public static void main(String[] args)
	{
		ClasseInutile o = new ClasseInutile();
		try
		{
			o.nePasInvoquer();
		}
		catch (ExceptionInutile e)
		{
			System.out.println(e);
		}
	}
}

class ExceptionInutile extends Exception
{
	public ExceptionInutile()
	{
		System.out.println("Je vous avais dit de ne pas "
				+ "invoquer cette fonction !");
	}

	public String toString()
	{
		return "Vous avez essayer d'invoquer une methode "
				+ "qu'il ne fallait pas invoquer !";
	}
}
