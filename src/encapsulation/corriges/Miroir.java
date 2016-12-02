package encapsulation.corriges;

import java.util.ArrayList;
import static encapsulation.corriges.ParcoursArrayListFor.*;

public class Miroir
{
	public static void echange(ArrayList<Integer> t, int a, int b)
	{
		int temp = t.get(a);
		t.set(a, t.get(b));
		t.set(b,  temp);
	}
	
	public static void miroir(ArrayList<Integer> t)
	{
		int inf = 0, sup = t.size() - 1;
		while(inf < sup)
			echange(t, inf++, sup--);
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> t = init(5);
		affiche(t);
		miroir(t);
		affiche(t);
	}
}
