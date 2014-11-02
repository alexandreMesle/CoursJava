package persistance.rememberMyName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class RememberMyName
{
	public abstract String getNameFromSupport() throws ReadException;
	public abstract void writeNameToSupport(String name) throws WriteException;

	public void printName()
	{
		try
		{
			System.out.println("Bonjour, " + getName() + ".");
		} 
		catch (IOException | WriteException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getName() throws IOException, WriteException
	{
		String name = "";
		try
		{
			return getNameFromSupport();
		} 
		catch (ReadException e)
		{
			name = getNameStdIn();
			writeNameToSupport(name);
			return name;
		}
	}

	public String getNameStdIn() throws IOException 
	{
		BufferedReader bufferedStdIn = null;
		try
		{
			System.out.println("What is your name ? ");
			InputStreamReader stdinInputStream = new InputStreamReader(System.in);
			bufferedStdIn = new BufferedReader(stdinInputStream);
			return bufferedStdIn.readLine();
		}
		finally
		{
			if (bufferedStdIn != null)
				bufferedStdIn.close();
		}
	}

	public static class ReadException extends Exception
	{
		private static final long serialVersionUID = 1L;
		Exception e;
		public ReadException(Exception e)
		{
			this.e = e;
		}
	}
	
	public static class WriteException extends Exception
	{
		private static final long serialVersionUID = 1L;
		Exception e;
		public WriteException(Exception e)
		{
			this.e = e;
			System.out.println(e);
		}
	}
}
