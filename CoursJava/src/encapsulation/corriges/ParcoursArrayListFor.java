package encapsulation.corriges;

import java.util.ArrayList;
import java.util.Random;

public class ParcoursArrayListFor
{
	public static ArrayList<Integer> init(int taille)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 1; i <= taille; i++)
			a.add(r.nextInt() % 10);	
		return a;
	}
	
	public static void affiche(ArrayList<Integer> a)
	{
		for (int i  = 0; i < a.size() ; i++)
			System.out.print(a.get(i) + " ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		affiche(init(20));
	}
}
