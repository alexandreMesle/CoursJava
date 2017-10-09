package exceptions;

import java.io.IOException;
import java.time.LocalDate;
import commandLineMenus.rendering.examples.util.InOut;

class AnneeInvalideException extends Exception
{
	@Override
	public String toString()
	{
		return "L'année ne peut pas être dans le futur";
	}
}


public class Age
{
	public static int calculeAge(int annee) throws AnneeInvalideException
	{
		int maintenant = LocalDate.now().getYear();
		if (annee > maintenant)
			throw new AnneeInvalideException();
		return maintenant - annee;
	}

	public static boolean afficheAge()
	{
		try
		{
			System.out.println("Quelle est ton année de naissance ? ");
			int annee = InOut.getInt();
			System.out.println("Tu as " + calculeAge(annee) + " ans.");
			return true;
		} 
		catch (AnneeInvalideException e)
		{
			System.out.println(e);
		} 
		catch (IOException | NumberFormatException e)
		{
			System.out.println("Merci de saisir un nombre.");
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		while(!afficheAge());
	}

}
