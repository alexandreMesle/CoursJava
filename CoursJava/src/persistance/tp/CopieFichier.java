package persistance.tp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopieFichier
{
	public static void copie(InputStreamReader source,
			OutputStreamWriter destination) throws IOException
	{
		int character;
		while ((character = source.read()) != -1)
			destination.write((char) character);
	}

	public static void copie(FileInputStream source,
			FileOutputStream destination) throws IOException
	{
		InputStreamReader isr = null;
		OutputStreamWriter osr = null;
		try
		{
			isr = new InputStreamReader(source);
			osr = new OutputStreamWriter(destination);
			copie(isr, osr);
		} finally
		{
			isr.close();
			osr.close();
		}
	}

	public static boolean copie(String source, String destination)
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);
			copie(fis, fos);
			return true;
		} catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		} catch (IOException e)
		{
			System.out.println("Erreur d'entrée/sortie.");
		} finally
		{
			try
			{
				fis.close();
			} catch (IOException e)
			{
			}
			try
			{
				fos.close();
			} catch (IOException e)
			{
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		if (copie(args[1], args[2]))
			System.out.println("Copie réussie.");
		else
			System.out.println("Copie échouée.");
	}

}
