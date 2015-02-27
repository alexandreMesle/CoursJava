package utilitaires;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntreesSorties
{
	public static String getString() throws IOException
	{
		BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
		return br.readLine();
	}
	
	public static int getInt() throws IOException
	{
		return Integer.parseInt(getString());
	}
	
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
}
