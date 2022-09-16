package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRationnel
{

	@Test
	void testToString()
	{
		assertEquals("5/64", Rationnel.cree(5, 64).toString(), "Création de 5/64");
		assertEquals("-5/8", Rationnel.cree(-5, 8).toString(), "Création de -5/8");
	}

	@Test
	void testCree()
	{
		assertEquals(3, Rationnel.cree(3, 4).num, "Numérateur de 3/4");
		assertEquals(4, Rationnel.cree(3, -4).den, "Dénominateur de 3/-4");
	}

	@Test
	void testCopie()
	{
		Rationnel r = Rationnel.cree(6, 5), t = r.copie();
		assertTrue(r.num == t.num && r.den == t.den, "Copie de 6/5");
		assertNotSame(r, t, "Copie de 6/5 différente de l'original");
	}

	@Test
	void testOppose()
	{
		assertEquals(Rationnel.cree(-4, 5), Rationnel.cree(4, 5).oppose(), "Opposé de 4/5");
		assertEquals(Rationnel.cree(8, 1), Rationnel.cree(-8, 1).oppose(), "Opposé de -8/1");
	}

	@Test
	void testInverse()
	{
		assertEquals(Rationnel.cree(4, 5), Rationnel.cree(5, 4).inverse(), "Inverse de 5/4");
		assertEquals(Rationnel.cree(-11, 5), Rationnel.cree(-5, 11).inverse(), "Inverse de -5/11");
	}

	@Test
	void testEstPositif()
	{
		assertTrue(Rationnel.cree(4, 5).estPositif(), "4/5 > 0 ?");
		assertFalse(Rationnel.cree(-4, 5).estPositif(), "-4/5 > 0 ?");
		assertFalse(Rationnel.cree(4, -5).estPositif(), "4/-5 > 0 ?");
		assertTrue(Rationnel.cree(-4, -5).estPositif(), "-4/-5 > 0 ?");
	}

	@Test
	void testPlus()
	{
		assertEquals(Rationnel.cree(2, 1), Rationnel.cree(1, 2).plus(Rationnel.cree(6, 4)), "1/2 + 6/4 = 2/1");
	}

	@Test
	void testMoins()
	{
		assertEquals(Rationnel.cree(2, 1), Rationnel.cree(6, 2).moins(Rationnel.cree(1, 1)), "6/2 - 1/1 = 2/1");
	}

	@Test
	void testMultiplie()
	{
		assertEquals(Rationnel.cree(40, 2), Rationnel.cree(10, 2).multiplie(Rationnel.cree(4, 1)), "10/2 * 4/1 = 40/2");
	}

	@Test
	void testDivise()
	{
		assertEquals(Rationnel.cree(10, 8), Rationnel.cree(10, 2).divise(Rationnel.cree(4, 1)), "(10/2) / (6/4) = 10/8");
	}

	@Test
	void testEquals()
	{
		assertTrue(Rationnel.cree(6, 5).equals(Rationnel.cree(6, 5)), "6/5 == 6/5");
		assertFalse(Rationnel.cree(6, 5).equals(Rationnel.cree(6, 4)), "6/5 == 6/4");
		assertTrue(Rationnel.cree(2, 1).equals(Rationnel.cree(2, 1)), "2/1 == 2/1");
		assertTrue(Rationnel.cree(20, 1).equals(Rationnel.cree(20, 1)), "20/1 == 20/1");
	}

	@Test
	void testCompareTo()
	{
		assertTrue(Rationnel.cree(5, 7).compareTo(Rationnel.cree(10, 8)) < 0, "5/7 > 10/8");
		assertTrue(Rationnel.cree(5, 7).compareTo(Rationnel.cree(-10, 8)) > 0, "5/7 > -10/8");
		assertTrue(Rationnel.cree(-5, 7).compareTo(Rationnel.cree(-5, 7)) == 0, "-5/7 > -5/7");
	}
	
	@Test 
	void testPgcd()
	{
		assertEquals(1, Rationnel.pgcd(13, 21), "pgcd(13, 21)");
		assertEquals(5, Rationnel.pgcd(35, 40), "pgcd(35, 40)");
	}

}
