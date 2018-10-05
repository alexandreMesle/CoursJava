package heritage;

import java.util.ArrayList;

interface Saluer
{
	public void direBonjour();
}

class Bonjour implements Saluer
{
	@Override
	public void direBonjour()
	{
		System.out.println("Bonjour");
	}
}

class Hello implements Saluer
{
	@Override
	public void direBonjour()
	{
		System.out.println("Hello");
	}
}

class GutenTag implements Saluer
{
	@Override
	public void direBonjour()
	{
		System.out.println("Guten tag");
	}
}

public class ExempleInterface
{
	public static void main(String[] args)
	{
		Saluer s = new Bonjour();
		s.direBonjour();
		s = new Hello();
		s.direBonjour();
		ArrayList<Saluer> arrayList = new ArrayList<Saluer>();
		arrayList.add(new Bonjour());
		arrayList.add(new Hello());
		arrayList.add(new GutenTag());
		for (Saluer saluer : arrayList)
			saluer.direBonjour();
	}
}
