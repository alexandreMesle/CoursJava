package boucles;
import java.util.Scanner;


public class FactorielleRepeter
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Saisissez un nombre : ");
		int n = scanner.nextInt();
		scanner.close();
		int fact = 1;
		int i = 1 ;
		do
		{
				fact *= i;
				i++;
		}
		while (i <= n);
		System.out.println(n + "! = " + fact);	
	}

}
