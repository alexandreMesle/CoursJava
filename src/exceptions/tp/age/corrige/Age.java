package exceptions.tp.age.corrige;

import java.time.LocalDate;

public class Age
{
	/**
	 * Prend en paramètre une année de naissance 
	 * au format chaîne de caractère et retourne 
	 * l'âge.
	 * @throws AnneeInvalideException si l'année est dans le futur.
	 * @throws FormatInvalideException si l'année n'est pas un entier.
	 */
	
	public static int getAge(String anneeChaine) 
		throws AnneeInvalideException, FormatInvalideException
	{
		try
		{
			int anneeInt = Integer.parseInt(anneeChaine);
			int maintenant = LocalDate.now().getYear();
			int age = maintenant - anneeInt; 
			if (age < 0)
				throw new AnneeInvalideException(anneeInt);
			return age;
		}
		catch(NumberFormatException e)
		{
			throw new FormatInvalideException(anneeChaine);
		}
	}
}

/**
 * Déclenchée si l'année passée en paramètre est dans le futur.
 */

class AnneeInvalideException extends Exception
{
	private int annee;
	
	AnneeInvalideException(int annee)
	{
		this.annee = annee;
	}
	
	@Override
	public String getMessage()
	{
		return "L'année " + annee + " est dans le futur.";
	}
}

/**
 * Déclenchée si la chaine passée en paramètre n'est pas un nombre entier.
 */

class FormatInvalideException extends Exception
{
	private String chaine;
	
	public FormatInvalideException(String chaine)
	{
		this.chaine = chaine;
	}
	
	@Override
	public String getMessage()
	{
		return chaine + " n'est pas un entier.";
	}
}
