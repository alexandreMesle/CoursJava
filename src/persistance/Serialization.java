package persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Wrapper implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int value;

	public Wrapper(int value)
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

	public static Wrapper read(String fileName) throws IOException, ClassNotFoundException
	{
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(fileName);
			ois= new ObjectInputStream(fis);
			return (Wrapper) (ois.readObject());
		}
		finally
		{
			if (ois != null)
				ois.close();
		}
	}
	
	public void write(String fileName) throws IOException
	{
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		}
		finally
		{
			if (oos != null)
				oos.close();
		}
	}
}

public class Serialization
{
	public static void main(String[] args)
	{
		String fileName = "serialization.srz";
		Wrapper w = new Wrapper(5);
		System.out.println(w);
		try
		{
			w.write(fileName);
			w.setValue(4);
			Wrapper wBis = Wrapper.read(fileName);
			System.out.println(wBis);// 4 ou 5 ?
			
			wBis.setValue(6);
			wBis.write(fileName);
			
			
		}
		catch (IOException e) 
		{
			System.out.println("Impossible d'ouvrir le fichier " + fileName + ".");
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Le fichier " + fileName + " est corrompu.");
		}
		
	}
}
