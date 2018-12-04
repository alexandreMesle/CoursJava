package threads.corriges;

public class BinaireAleatoireRunnable
{
	public static void main(String[] args)
	{
		(new Thread(() -> {for (int i = 1; i <= 30; i++)System.out.print("1");})).start();
		(new Thread(() -> {for (int i = 1; i <= 30; i++)System.out.print("0");})).start();
	}
}
