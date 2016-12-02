package classes;

public class Point
{
	float abscisse;
	float ordonnee;

	void presenteToi()
	{
		System.out.println("Je suis un point, mes coordonnees sont ("
				+ abscisse + ", " + ordonnee + ")");
	}

	public static void main(String[] args)
	{
		Point p;
		p = new Point();
		p.abscisse = 1;
		p.ordonnee = 2;
		p.presenteToi();
	}
}
