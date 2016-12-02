package encapsulation.corriges;

import java.util.ArrayList;
import static encapsulation.corriges.ParcoursArrayListFor.*;
import static encapsulation.corriges.Miroir.echange;

public class Tri
{
	public static void tri(ArrayList<Integer> t)
	{
		for (int i = t.size() - 1 ; i > 0; i--)
		{
			int indexMax = 0;
			for (int j = 0 ; j <= i ; j++)
			{
				if (t.get(indexMax) < t.get(j))
					indexMax = j;
				echange(t, indexMax, i);
			}
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> t = init(5);
		affiche(t);
		tri(t);
		affiche(t);
	}
}
