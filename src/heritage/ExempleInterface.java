package heritage;

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
		Saluer[] t = new Saluer[] { new Bonjour(), new Hello(), new GutenTag() };
		for (int i = 0; i < 3; i++)
			t[i].saluer();
	}
}
