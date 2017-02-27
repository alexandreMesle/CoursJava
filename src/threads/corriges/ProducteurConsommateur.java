package threads.corriges;

import java.util.Random;

public class ProducteurConsommateur
{
	public static void main(String[] args)
	{
		File<Integer> f = new File<Integer>(30);
		Thread producteur1 = new Producteur(f, "producteur 1");
		Thread producteur2 = new Producteur(f, "producteur 2");
		Thread consommateur1 = new Consommateur(f, "consommateur 1");
		Thread consommateur2 = new Consommateur(f, "consommateur 2");
		producteur1.start();
		producteur2.start();
		consommateur1.start();
		consommateur2.start();
	}
}

class Producteur extends Thread
{
	private File<Integer> file;
	String name;

	Producteur(File<Integer> file, String name)
	{
		this.file = file;
		this.name = name;
	}

	@Override
	public void run()
	{
		Random r = new Random();
		while (true)
		{
			synchronized (file)
			{
				try
				{
					sleep(100);
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
				System.out.println(name);
				if (!file.isFull())
				{
					boolean empty = file.isEmpty();
					try
					{
						file.add(r.nextInt());
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
					if (empty)
						file.notifyAll();
				}
				else
					try
					{
						file.wait();
					}
					catch (InterruptedException e)
					{
						System.out.println(e);
					}
			}
		}
	}
}

class Consommateur extends Thread
{
	private File<Integer> file;
	private String name;

	Consommateur(File<Integer> file, String name)
	{
		this.file = file;
		this.name = name;
	}

	@Override
	public void run()
	{
		while (true)
		{
			synchronized (file)
			{
				try
				{
					sleep(100);
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
				System.out.println(name);
				if (!file.isEmpty())
				{
					boolean full = file.isFull();
					int first = 0;
					try
					{
						first = file.getFirst();
						file.removeFirst();
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
					System.out.println(first);
					if (full)
						file.notifyAll();
				}
				else
					try
					{
						file.wait();
					}
					catch (InterruptedException e)
					{
						System.out.println(e);
					}
			}
		}
	}
}

class List<T>
{
	private T data;
	private List<T> next;

	List(T data, List<T> next)
	{
		this.data = data;
		this.next = next;
	}

	List(T data)
	{
		this(data, null);
	}

	public T getData()
	{
		return data;
	}

	public List<T> getNext()
	{
		return next;
	}

	public void setNext(List<T> next)
	{
		this.next = next;
	}
}

class File<T>
{
	private List<T> first = null;
	private List<T> last = null;
	private int nbElements = 0;
	private final int maxNbElements;

	public File(int maxNbElements)
	{
		this.maxNbElements = maxNbElements;
	}

	public T getFirst()
	{
		if (isEmpty())
			throw new EmptyFileException();
		return first.getData();
	}

	public void removeFirst()
	{
		if (isEmpty())
			throw new EmptyFileException();
		first = first.getNext();
		nbElements--;
	}

	public void add(T data)
	{
		if (isFull())
			throw new FullFileException();
		if (isEmpty())
			first = last = new List<T>(data);
		else
		{
			last.setNext(new List<T>(data));
			last = last.getNext();
		}
		nbElements++;
	}

	public boolean isEmpty()
	{
		return nbElements == 0;
	}

	public boolean isFull()
	{
		return nbElements == maxNbElements;
	}
	
	static class EmptyFileException extends RuntimeException
	{
		private static final long serialVersionUID = 8004748487421897828L;
		public EmptyFileException()
		{
			System.out.println("Can't read empty file");
		}
	}

	static class FullFileException extends RuntimeException
	{
		private static final long serialVersionUID = -1988943091168454052L;
		public FullFileException()
		{
			System.out.println("Can't write full file");
		}
	}
}
