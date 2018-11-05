package testsUnitaires;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestsJUnit
{
	private Puissance p = new ImplementationPuissance();

	@Test
	public void testSucc()
	{
		assertEquals("test de la fonction successeur", 2, p.succ(1));
		assertEquals("test de la fonction successeur", -2, p.succ(-3));
		assertEquals("test de la fonction successeur", 1, p.succ(0));
	}

	@Test
	public void testPred()
	{
		assertEquals("pred", 5, p.pred(6));
		assertEquals("pred", -8, p.pred(-7));
		assertEquals("pred", -1, p.pred(0));
	}

	@Test
	public void testSomme()
	{
		assertEquals("somme", 2, p.somme(2, 0));
		assertEquals("somme", 2, p.somme(0, 2));
		assertEquals("somme", 9, p.somme(3, 6));
		assertEquals("somme", 10, p.somme(13, -3));
		assertEquals("somme", -10, p.somme(-13, 3));
		assertEquals("somme", -16, p.somme(-13, -3));
	}

	@Test
	public void testProduit()
	{
		assertEquals("produit", 0, p.produit(2, 0));
		assertEquals("produit", 0, p.produit(0, 2));
		assertEquals("produit", 2, p.produit(2, 1));
		assertEquals("produit", 18, p.produit(3, 6));
		assertEquals("produit", -18, p.produit(-3, 6));
		assertEquals("produit", 18, p.produit(-3, -6));
	}

	@Test
	public void testPuissance()
	{
		assertEquals("puissance", 1, p.puissance(4, 0));
		assertEquals("puissance", 5, p.puissance(5, 1));
		assertEquals("puissance", 1, p.puissance(1, 50));
		assertEquals("puissance", 9, p.puissance(3, 2));
		assertEquals("puissance", 1024, p.puissance(2, 10));
	}
}
