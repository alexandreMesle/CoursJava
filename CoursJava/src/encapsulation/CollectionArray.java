package collections.exemples;

import java.util.ArrayList;

public class CollectionArray
{
	public static void main(String[] args)
	{
		ArrayList a = new ArrayList();
		for (int value = 2; value < 50; value += 3)
			a.add(value);
		for (int index = 0; index < a.size(); index++)
			System.out.println(a.get(index));
	}
}
