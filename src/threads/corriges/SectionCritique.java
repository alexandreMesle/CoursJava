package threads.corriges;

public class SectionCritique extends Thread
{
	private int value;
	private Counter c;

	public SectionCritique(int value, Counter c)
	{
		this.value = value;
		this.c = c;
	}

	@Override
	public void run()
	{
		boolean okay = true;
		while (okay)
			synchronized (c)
			{
				okay = c.stepCounter();
				if (okay)
					System.out.print(value);
			}
	}

	public static void main(String[] args)
	{
		Counter c = new Counter(30000);
		Thread un = new SectionCritique(1, c);
		Thread zero = new SectionCritique(0, c);
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

		boolean stepCounter()
		{
			if (i > nbIterations)
				return false;
			i++;
			return true;
		}
	}

}
