package threads.corriges;

public class BinaireSynchronise extends Thread
{
	private int value;
	private Counter c;

	public BinaireSynchronise(int value, Counter c)
	{
		this.value = value;
		this.c = c;
	}

	@Override
	public void run()
	{
		while (c.stepCounter())
			System.out.print(value);
	}

	public static void main(String[] args)
	{
		Counter c = new Counter(30000);
		Thread un = new BinaireSynchronise(1, c);
		Thread zero = new BinaireSynchronise(0, c);
		un.start();
		zero.start();
	}

	static class Counter
	{
		private int i;
		private final int nbIterations;

		Counter(int nbIterations)
		{
			this.nbIterations = nbIterations;
			i = 1;
		}

		synchronized boolean stepCounter()
		{
			if (i > nbIterations)
				return false;
			i++;
			return true;
		}
	}
}