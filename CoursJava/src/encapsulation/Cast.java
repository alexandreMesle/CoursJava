package encapsulation;

import java.util.ArrayList;

public class Cast
{
	public static void main(String[] args)
	{
		ArrayList a = new ArrayList();
		a.add("toto");
		String s = (String) a.get(0);
		System.out.println(s);
		a.add(5);
		int i = (int) a.get(1);
		System.out.println(i);
	}
}
