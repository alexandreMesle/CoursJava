package persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization implements Serializable
{
	private static final long serialVersionUID = 1L;

	private  int value;
	
	public TestSerialization(int value)
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
		String fileName = "testSerialization";
		TestSerialization ts = new TestSerialization(5);
		System.out.println(ts);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try
		{
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ts);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (fos != null)	
					fos.close();
				if (oos != null)	
					oos.close();
			} 
			catch (IOException e)
			{
				System.out.println("Impossible de fermer le fichier " 
						+ fileName + ".");
			}
		}
		ts.setValue(4);
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream("testSerialization");
			ois = new ObjectInputStream(fis);
			TestSerialization tsBis = (TestSerialization)(ois.readObject());
			System.out.println(tsBis);// 4 ou 5 ?
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
