package exceptions;

import java.util.Scanner;

class TaSaisiVrai extends Exception
{
	@Override
	public String toString() 
	{
		return "Katastrophe : Il fallait saisir faux !!!!!";
	}
}

class TaSaisiFaux extends Exception
{
	@Override
	public String toString() 
	{
		return "Katastrophe : Il fallait saisir vrai !!!!!";
	}
}

public class VraiFaux 
{
	static void saisisUnBooleen() throws TaSaisiVrai, TaSaisiFaux
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			if (scanner.nextBoolean())
				throw new TaSaisiVrai();
			else
				throw new TaSaisiFaux();
		}
		finally
		{
			scanner.close();
			System.out.println("Scanner fermé");
		}
	}
	
	static void appelleSaisisUnBooleen() throws TaSaisiVrai, TaSaisiFaux
	{
		saisisUnBooleen();
	}
	
	public static void main(String[] args)
	{
		try
		{
			appelleSaisisUnBooleen();
			System.out.println("Tout s'est bien passé");
		}
		catch (TaSaisiFaux|TaSaisiVrai exception)
		{
			System.out.println(exception);
		}
	}
}
