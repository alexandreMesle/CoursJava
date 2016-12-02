package persistance;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fichier
{
	public static void main(String[] args)
	{
		BufferedReader br = null;
		String fileName = "src/persistance/Fichier.java";
		try
		{
			FileInputStream fis = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null)
				System.out.println(line);
		}
		catch (IOException e)
		{
			System.out.println("Impossible d'ouvrir le fichier " + fileName
					+ ".");
		}
		finally
		{
			try
			{
				if (br != null)
					br.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
