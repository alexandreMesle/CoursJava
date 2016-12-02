package testsUnitaires.tp;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoint
{
	// Pour pouvoir connecter cette classe de tests à n'importe quelle
	// implémentation.
	// Il vous suffit de remplacer l'instanciation ici par celle de votre classe
	// point.
	private static InterfacePoint getPoint()
	{
		return new ImplementPoint();
	}

	public static InterfacePoint getPoint(int abs, int ord)
	{
		InterfacePoint p = getPoint();
		p.setAbs(abs);
		p.setOrd(ord);
		return p;
	}

	@Test
	public void testPointIntInt()
	{
		InterfacePoint p = getPoint(3, 2);
		assertTrue(p.getAbs() == 3 && p.getOrd() == 2);
	}

	@Test
	public void testGetOrd()
	{
		InterfacePoint p = getPoint();
		p.setOrd(5);
		assertTrue(p.getOrd() == 5);
		p.setOrd(-1);
		assertTrue(p.getOrd() == -1);
		p.setAbs(4);
		assertTrue(p.getOrd() == -1);
	}

	@Test
	public void testGetAbs()
	{
		InterfacePoint p = getPoint();
		p.setAbs(5);
		assertTrue(p.getAbs() == 5);
		p.setAbs(-1);
		assertTrue(p.getAbs() == -1);
		p.setOrd(4);
		assertTrue(p.getAbs() == -1);
	}

	@Test
	public void testEquals()
	{
		InterfacePoint p = getPoint(3, 5);
		assertTrue(p.equals(p));
		InterfacePoint q = getPoint(3, 5);
		assertTrue(p.equals(q) && q.equals(p));
		assertTrue(!p.equals(getPoint(5, 3)));
		assertTrue(!p.equals(getPoint(3, 6)));
		assertTrue(!p.equals(getPoint(4, 5)));
	}

	@Test
	public void testAdd()
	{
		InterfacePoint p = getPoint(3, 5), q = getPoint(2, 3);
		assertTrue(p.add(p).equals(getPoint(6, 10)));
		assertTrue(p.add(p).equals(getPoint(6, 10)));
		assertTrue(p.add(q).equals(getPoint(5, 8)));
		assertTrue(p.add(q).equals(q.add(p)));
	}

}
