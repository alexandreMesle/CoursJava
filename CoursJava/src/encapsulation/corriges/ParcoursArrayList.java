package encapsulation.corriges;

import java.util.ArrayList;
import java.util.Random;

public class ParcoursArrayList
{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 1; i <= 10; i++)
			a.add(r.nextInt());
		for (int i : a)
			System.out.println(i);
	}
}
