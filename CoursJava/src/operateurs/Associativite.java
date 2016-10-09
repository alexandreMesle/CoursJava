package operateurs;

public class Associativite
{

	public static void main(String[] args)
	{
		double a = Double.MAX_VALUE,
				b = 1;
		double somme1 = b + (a - a),
				somme2 = (b + a) - a;
		System.out.println(somme1 + " =? " + somme2 + " :'-(");
	}
}
