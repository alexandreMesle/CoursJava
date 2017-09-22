package heritage;

import java.util.ArrayList;

interface Saluer
{
	public void saluer();
}

class Bonjour implements Saluer
{
	@Override
	public void saluer()
	{
		System.out.println("Bonjour");
	}
}

class Hello implements Saluer
{
	@Override
	public void saluer()
	{
		System.out.println("Hello");
	}
}

class GutenTag implements Saluer
{
	@Override
	public void saluer()
	{
		System.out.println("Guten tag");
	}
}

public class ExempleInterface
{
	public static void main(String[] args)
	{
		Saluer s = new Bonjour();
		s.saluer();
		s = new Hello();
		s.saluer();
		ArrayList<Saluer> arrayList = new ArrayList<Saluer>();
		arrayList.add(new Bonjour());
		arrayList.add(new Hello());
		arrayList.add(new GutenTag());
		for (Saluer salut : arrayList)
			salut.saluer();
	}
}
