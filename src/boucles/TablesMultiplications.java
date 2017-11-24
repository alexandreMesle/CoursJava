package boucles;

public class TablesMultiplications
{

	public static void main(String[] args)
	{
		for (int n = 1 ; n <= 10 ; n++)
		{
			System.out.println("Table de " + n + " :");
			for (int i = 1 ; i <= 10 ; i++)
				System.out.println(n + " * " + i + " = " + n * i);
			System.out.println();
		}
	}

}
