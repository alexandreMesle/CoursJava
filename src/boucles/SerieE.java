package boucles;

public class SerieE
{

	public static void main(String[] args)
	{
		double somme = 0, terme = 1, eps = 1e-16, i = 0;
		while (terme > eps)
		{
			somme += terme;
			i++;
			terme /= i;			
		}
		System.out.println(somme);		
	}

}
