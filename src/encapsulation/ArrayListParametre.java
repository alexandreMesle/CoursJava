package encapsulation;

import java.util.ArrayList;

public class ArrayListParametre
{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int value = 2; value < 50; value += 3)
			a.add(value);
		for (int index = 0; index < a.size(); index++)
		{
			int value = a.get(index);
			System.out.println(value);
		}
	}
}
