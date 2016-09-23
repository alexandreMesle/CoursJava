package encapsulation;

import java.util.ArrayList;

public class ArrayListForEach
{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>();
		for (int value = 2; value < 50; value += 3)
			a.add(value);
		for (int value : a)
			System.out.println(value);
	}
}
