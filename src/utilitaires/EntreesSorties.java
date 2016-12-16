package utilitaires;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Fonctions de simplification des opérations de saisie.
 */

public class EntreesSorties
{
	/**
	 * Saisit une chaîne de caractères.
	 * @return la chaîne saisie.
	 * @throws IOException En cas d'erreur de saisie.
	 */
	
	public static String getString() throws IOException
	{
		BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
		return br.readLine();
	}
	
	/**
	 * Saisit un int.
	 * @return l'entier saisi.
	 * @throws IOException En cas d'erreur de saisie.
	 */
	
	public static int getInt() throws IOException
	{
		return Integer.parseInt(getString());
	}
	
	/**
	 * Saisit un int après avoir affiché {@link message}.
	 * La saisie est démandé itérativement jusqu'à ce que 
	 * l'utilisateur ait saisi une valeur correcte.
	 * @param message le message affiché avant la saisie.
	 * @return l'entier saisi.
	 */
	
	public static int getInt(String message)
	{
		do
		{
			System.out.print(message);
			try
			{
				return getInt();
			}
			catch(Exception e)
			{
				System.out.println("Erreur de saisie !");
			}
		}
		while(true);
	}
	
	/**
	 * Saisit une chaîne de caractères après avoir affiché {@link message}.
	 * La saisie est demandée jusqu'à ce que l'utilisateur l'ait 
	 * sans provoquer d'erreur.
	 * @param message le message affiché avant la saisie.
	 * @return la chaîne saisie.
	 */
	
	public static String getString(String message)
	{
		do
		{
			System.out.print(message);
			try
			{
				return getString();
			}
			catch(Exception e)
			{
				System.out.println("Erreur de saisie !");
			}
		}
		while(true);
	}

	/**
	 * Affiche une exception, utile pour afficher une exception rattrapée.
	 * @param e l'exception à afficher.
	 */

	public static void afficheException(Exception e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter s = new PrintWriter(sw);
		e.printStackTrace(s);
		System.out.println(sw);
	}

}
