package encapsulation;

import java.util.ArrayList;

public class CollectionArray
{
	public static void main(String[] args)
	{
		ArrayList a = new ArrayList();
		for (int value = 2; value < 50; value += 3)
			a.add("a " + value);
		for (int index = 0; index < a.size(); index++)
		{
			int valeur = (int) a.get(index);
			System.out.println(valeur);
		}
	}
}
