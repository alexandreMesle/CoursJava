package threads;

public class BinaireAleatoire extends Thread
{
	private int value;
	private int nbIterations;

	public BinaireAleatoire(int value, int nbIterations)
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
		Thread un = new BinaireAleatoire(1, 30);
		Thread zero = new BinaireAleatoire(0, 30);
		un.start();
		zero.start();
	}
}
