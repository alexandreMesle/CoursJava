package testsUnitaires;

public class TestFonctions
{
	public static void main(String[] args)
	{
		Puissance p = new ImplementationPuissance();
		System.out.println("2 = " + p.succ(1));
		System.out.println("5 = " + p.pred(6));
		System.out.println("2 = " + p.somme(2, 0));
		System.out.println("9 = " + p.somme(3, 6));
		System.out.println("10 = " + p.somme(13, -3));
		System.out.println("2 = " + p.produit(2, 1));
		System.out.println("18 = " + p.produit(3, 6));
		System.out.println("-18 = " + p.produit(-3, 6));
		System.out.println("1 = " + p.puissance(4, 0));
		System.out.println("5 = " + p.puissance(5, 1));
		System.out.println("9 = " + p.puissance(3, 2));
		System.out.println("1024 = " + p.puissance(2, 10));
	}
}
