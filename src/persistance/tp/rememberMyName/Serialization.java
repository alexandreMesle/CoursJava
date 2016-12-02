package persistance.tp.rememberMyName;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization extends RememberMyName
{
	private static final String FILE_NAME = "myName.serialization";

	@Override
	public String getNameFromSupport() throws ReadException
	{
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			String s = (String) (ois.readObject());
			return s;
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new ReadException(e);
		}
		finally
		{
			try
			{
				if (ois != null)
					ois.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void writeNameToSupport(String name) throws WriteException
	{
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fis = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(name);
		}
		catch (IOException e)
		{
			throw new WriteException(e);
		}
		finally
		{
			try
			{
				if (oos != null)
					oos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		RememberMyName rmn = new Serialization();
		rmn.printName();
	}
}
