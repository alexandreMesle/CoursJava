package persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int value;

	public Serialization(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return "" + value;
	}

	public static void main(String[] args)
	{
		String fileName = "serialization.srz";
		Serialization s = new Serialization(5);
		System.out.println(s);
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
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
				System.out.println("Impossible de fermer le fichier "
						+ fileName + ".");
			}
		}
		s.setValue(4);
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(fileName);
			ois= new ObjectInputStream(fis);
			Serialization sBis = (Serialization) (ois.readObject());
			System.out.println(sBis);// 4 ou 5 ?
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
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
				System.out.println("Impossible de fermer le fichier "
						+ fileName + ".");
			}
		}
	}
}
