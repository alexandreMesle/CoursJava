package threads;

public class ReveilsPerdus
{
	private int value = 0;
	private int upperBound;
	private int lowerBound;

	public ReveilsPerdus(int lowerBound, int upperBound)
	{
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		value = (upperBound + lowerBound) / 2;
		new Plus().start();
		new Moins().start();
	}

	public void increaseCounter() throws InterruptedException
	{
		if (value == upperBound)
			synchronized(this){wait();}
		else
		{
			value++;
			System.out.println("+ 1 = " + value);
			if (value == lowerBound + 1)
				synchronized(this){notify();}
		}
	}

	public void decreaseCounter() throws InterruptedException
	{
		if (value == lowerBound)
			synchronized(this){wait();}
		else
		{
			value--;
			System.out.println("- 1 = " + value);
			if (value == upperBound - 1)
				synchronized(this){notify();}
		}
	}

	class Plus extends Thread
	{
		@Override
		public void run()
		{
			while (true)
				try{increaseCounter();}
				catch (InterruptedException e){}
		}
	}

	class Moins extends Thread
	{
		@Override
		public void run()
		{
			while (true)
				try{decreaseCounter();}
				catch (InterruptedException e){}
		}
	}

	public static void main(String[] args)
	{
		new ReveilsPerdus(0, 100);
	}	
}

