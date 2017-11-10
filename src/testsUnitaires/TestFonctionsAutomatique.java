package testsUnitaires;

public class TestFonctionsAutomatique
{
	private boolean ok = true;

	private void teste(String fonction, int obtenu, int attendu)
	{
		if (attendu == obtenu)
			System.out.println("test OK");
		else
		{
			System.out.println("test " + fonction + " échoué : " + obtenu
					+ " != " + attendu);
			ok = false;
		}
	}

	public boolean teste(Puissance p)
	{
		ok = true;
		try
		{
			teste("succ", p.succ(1), 2);
			teste("pred", p.pred(6), 5);
			teste("somme", p.somme(2, 0), 2);
			teste("somme", p.somme(3, 6), 9);
			teste("somme", p.somme(13, -3), 10);
			teste("produit", p.produit(2, 1), 2);
			teste("produit", p.produit(3, 6), 18);
			teste("produit", p.produit(-3, 6), -18);
			teste("produit", p.produit(3, -6), -18);
			teste("puissance", p.puissance(4, 0), 1);
			teste("puissance", p.puissance(5, 1), 5);
			teste("puissance", p.puissance(3, 2), 9);
			teste("puissance", p.puissance(2, 10), 1024);
		}
		catch (Exception e)
		{
			ok = false;
			System.out.println(e);
		}
		if (ok)
			System.out.println("----> Soooo goood");
		else
			System.out.println("----> Au moins un test a échoué.");
		return ok;
	}

	public static void main(String[] args)
	{
		Puissance p = new ImplementationPuissance();
		TestFonctionsAutomatique t = new TestFonctionsAutomatique();
		t.teste(p);
	}
}
