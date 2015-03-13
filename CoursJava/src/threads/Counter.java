package threads;
public class Counter
{
    private int value = 0;
    private int upperBound;
    private int lowerBound;
    private static int SLEEP_DURATION = 50;
    
    public Counter(int lowerBound, int upperBound)
    {
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
		value = (upperBound + lowerBound)/2;
    }
    
    public synchronized void increaseCounter() throws InterruptedException
    {
		if (value == upperBound)
		    wait();
		else
		    {
				value++;
				System.out.println("+ 1 = " + value);
				Thread.sleep(SLEEP_DURATION);
				if (value == lowerBound + 1)
				    notify();
		    }
    }
    
    public synchronized void decreaseCounter() throws InterruptedException
    {
	if (value == lowerBound)
	    wait();
	else
	    {
			value--;
			System.out.println("- 1 = " + value);
			Thread.sleep(SLEEP_DURATION);
			if (value == upperBound - 1)
			    notify();
	    }
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
    
    public void run()
    {
	while(true)
	    try
		{
		    c.increaseCounter();
		}
	    catch(InterruptedException e){}
    }
}

class Moins extends Thread
{
    private Counter c;
    
    Moins(Counter c)
    {
    	this.c = c;
    }
    
    public void run()
    {
		while(true)
		    try
			{
			    c.decreaseCounter();
			}
		    catch(InterruptedException e){}
	    }
}
