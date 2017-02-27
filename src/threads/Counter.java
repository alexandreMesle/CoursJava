package threads;

public class Counter
{
	private int value = 0;
	private int upperBound;
	private int lowerBound;

	public Counter(int lowerBound, int upperBound)
	{
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		value = (upperBound + lowerBound) / 2;
	}

	public synchronized void increaseCounter() throws InterruptedException
	{
		while (value == upperBound)
			wait();
		value++;
		System.out.println("+ 1 = " + value);
		if (value == lowerBound + 1)
			notify();
	}

	public synchronized void decreaseCounter() throws InterruptedException
	{
		while (value == lowerBound)
			wait();
		value--;
		System.out.println("- 1 = " + value);
		if (value == upperBound - 1)
			notify();
	}

	public static void main(String[] args)
	{
		Counter c = new Counter(0, 100);
		Thread p = new Plus(c);
		Thread m = new Moins(c);
		p.start();
		m.start();
	}
}

class Plus extends Thread
{
	private Counter c;

	Plus(Counter c)
	{
		this.c = c;
	}

	@Override
	public void run()
	{
		while (true)
			try{c.increaseCounter();}
			catch (InterruptedException e){}
		
	}
}

class Moins extends Thread
{
	private Counter c;

	Moins(Counter c)
	{
		this.c = c;
	}

	@Override
	public void run()
	{
		while (true)
			try{c.decreaseCounter();}
			catch (InterruptedException e){}
	}
}
