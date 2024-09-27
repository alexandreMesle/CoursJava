package exceptions.tp.age.sujet;

import java.time.LocalDate;

/**
 * Déclenchée si l'année passée en paramètre est dans le futur.
 */

class AnneeInvalideException extends Exception
{
	public String getMessage()
	{
		return null;
	}
}

/**
 * Déclenchée si la chaine passée en paramètre n'est pas un nombre entier.
 */

class FormatInvalideException extends Exception
{
	public String getMessage()
	{
		return null;
	}
}

public class Age
{
	/**
	 * Prend en paramètre une année de naissance 
	 * au format chaîne de caractère et retourne 
	 * l'âge.
	 * @throws AnneeInvalideException si l'année est dans le futur.
	 * @throws FormatInvalideException si l'année n'est pas un entier.
	 */
	
	public static int getAge(String annee) 
		throws AnneeInvalideException, FormatInvalideException
	{
		int maintenant = LocalDate.now().getYear();
		return 0;
	}
}
