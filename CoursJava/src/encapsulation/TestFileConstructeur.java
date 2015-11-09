package encapsulation;

public class TestFileConstructeur
{
	public static void main(String[] args)
	{
		FileConstructeur f = new FileConstructeur(20);
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
