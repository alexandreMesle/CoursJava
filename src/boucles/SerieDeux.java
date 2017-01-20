package boucles;

public class SerieDeux
{

	public static void main(String[] args)
	{
		double somme = 0, terme = 1, eps = 1e-16;
		while (terme > eps)
		{
			somme += terme;
			terme /= 2;
		}
		System.out.println(somme);
	}

}
