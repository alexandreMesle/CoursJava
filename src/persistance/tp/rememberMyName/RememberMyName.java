package persistance.tp.rememberMyName;

import java.io.IOException;
import commandLineMenus.rendering.examples.util.InOut;

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
			name = InOut.getString("What is your name ? ");
			writeNameToSupport(name);
			return name;
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
