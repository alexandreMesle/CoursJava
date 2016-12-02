package encapsulation;

public class TestFileSurcharge
{
	public static void main(String[] args)
	{
		FileSurcharge f = new FileSurcharge(20);
		for (int i = 0; i < 30; i += 2)
		{
			f.enfile(i);
			f.enfile(i + 1);
			System.out.println(f.premier());
			f.defile();
		}
		FileSurcharge g = new FileSurcharge(f);
		while (!f.estVide())
		{
			System.out.println(f.premier());
			f.defile();
		}
		while (!g.estVide())
		{
			System.out.println(g.premier());
			g.defile();
		}
	}
}
