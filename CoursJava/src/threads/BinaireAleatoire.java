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
    
    public void run()
    {
	for (int i = 1 ; i <= nbIterations ; i++)
	    System.out.print(value);
    }
    
    public static void main(String[] args)
    {
	Thread un = new BinaireAleatoire(1, 30000);
	Thread zero = new BinaireAleatoire(0, 30000);
	un.start();
	zero.start();
    }
}
