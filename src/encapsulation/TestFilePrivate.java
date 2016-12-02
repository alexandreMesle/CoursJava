package encapsulation;

public class TestFilePrivate
{
	public static void main(String[] args)
	{
		FilePrivate f = new FilePrivate();
		f.init(20);
		for (int i = 0; i < 30; i += 2)
		{
			f.enfile(i);
			f.enfile(i + 1);
			System.out.println(f.premier());
			f.defile();
		}
		while (!f.estVide())
		{
			System.out.println(f.premier());
			f.defile();
		}
	}
}
