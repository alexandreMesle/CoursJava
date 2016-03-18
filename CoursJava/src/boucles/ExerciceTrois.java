package boucles;

public class ExerciceTrois
{
	public static void main(String[] args)
	{
		int a, b, c, d;
		a = 1;
		b = 2;
		c = a / b;
		d = (a == b) ? 3 : 4;
		System.out.println(c + ", " + d + ".");
		a = ++b;
		b %= 3;
		System.out.println(a + ", " + b + ".");
		b = 1;
		for (a = 0; a <= 10; a++)
			c = ++b;
		System.out.println(a + ", " + b + ", " + c + ", " + d + ".");
	}
}
