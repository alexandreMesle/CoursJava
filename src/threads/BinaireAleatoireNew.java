package threads;

public class BinaireAleatoireNew implements Runnable
{
	private int value;
	private int nbIterations;

	public BinaireAleatoireNew(int value, int nbIterations)
	{
		this.value = value;
		this.nbIterations = nbIterations;
	}
	
	@Override
	public void run()
	{
		for (int i = 1; i <= nbIterations; i++)
			System.out.print(value);
	}

	public static void main(String[] args)
	{
		Runnable un = new BinaireAleatoireNew(1, 30);
		Runnable zero = new BinaireAleatoireNew(0, 30);
		Thread tun = new Thread(un);
		Thread tzero = new Thread(zero);
		tun.start();
		tzero.start();
	}
}
