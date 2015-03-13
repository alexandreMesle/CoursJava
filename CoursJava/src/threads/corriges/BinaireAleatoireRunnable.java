package threads.corriges;

public class BinaireAleatoireRunnable implements Runnable
{
    private int value;
    private int nbIterations;
    
    public BinaireAleatoireRunnable(int value, int nbIterations)
    {
	this.value = value;
	this.nbIterations = nbIterations;
    }
    
    public void run()
    {
	for (int i = 1 ; i <= nbIterations ; i++)
	    System.out.print(value);
    }
    
    public static void main(String[] args)
    {
	Runnable un = new BinaireAleatoireRunnable(1, 30);
	Runnable zero = new BinaireAleatoireRunnable(0, 30);
	Thread tUn = new Thread(un);
	Thread tZero = new Thread(zero);
	tUn.start();
	tZero.start();
    }
}
