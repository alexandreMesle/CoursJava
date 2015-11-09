package persistance.tp.rememberMyName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fichier extends RememberMyName
{
	private static final String FILE_NAME = "myName.txt";

	public String getNameFromSupport() throws ReadException
	{
		BufferedReader bufferedReader = null;
		try
		{
			FileInputStream file = new FileInputStream(FILE_NAME);
			InputStreamReader fileReader = new InputStreamReader(file);
			bufferedReader = new BufferedReader(fileReader);
			return bufferedReader.readLine();
		}
		catch (IOException e)
		{
			throw new ReadException(e);
		}
		finally
		{
			try
			{
				if (bufferedReader != null)
					bufferedReader.close();
			}
			catch (Exception e)
			{
			}
		}
	}

	@Override
	public void writeNameToSupport(String name) throws WriteException
	{
		BufferedWriter bufferedWriter = null;
		try
		{
			FileOutputStream outputFile = new FileOutputStream(FILE_NAME);
			OutputStreamWriter writer = new OutputStreamWriter(outputFile);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(name);
		}
		catch (IOException e)
		{
			throw new WriteException(e);
		}
		finally
		{
			try
			{
				if (bufferedWriter != null)
					bufferedWriter.close();
			}
			catch (Exception e)
			{
			}
		}
	}

	public static void main(String[] args)
	{
		RememberMyName rmn = new Fichier();
		rmn.printName();
	}
}
