package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRationnel
{
    private Rationnel cree(int num, int den)
    {
        Rationnel r = new Rationnel();
        r.num = num;
        r.den = den;
        return r;
    }

    private boolean equals(Rationnel a, Rationnel b)
    {
        return a != null && b != null && a.num * b.den == a.den * b.num;
    }

    private boolean hardEquals(Rationnel a, Rationnel b)
    {
        return a != null && b != null && a.num == b.num && a.den == b.den ;
    }

    
	@Test
	void testToString()
	{
		assertEquals("5/64", cree(5, 64).toString(), "Création de 5/64");
		assertEquals("-5/8", cree(-5, 8).toString(), "Création de -5/8");
	}

	@Test
	void testCree()
	{
		assertEquals(3, Rationnel.cree(3, 4).num, "Numérateur de 3/4");
		assertEquals(6, Rationnel.cree(5, 6).den, "Dénominateur de 5/6");
	}

	@Test
	void testCopie()
	{
		Rationnel r = cree(6, 5), t = r.copie();
		assertTrue(r.num == t.num && r.den == t.den, "Copie de 6/5");
		assertNotSame(r, t, "Copie de 6/5 différente de l'original");
	}

	@Test
	void testOppose()
	{
		assertTrue(equals(cree(-4, 5), cree(4, 5).oppose()), "Opposé de 4/5");
		assertTrue(equals(cree(8, 1), cree(-8, 1).oppose()), "Opposé de -8/1");
	}

	@Test
	void testInverse()
	{
		assertTrue(equals(cree(4, 5), cree(5, 4).inverse()), "Inverse de 5/4");
		assertTrue(equals(cree(-11, 5), cree(-5, 11).inverse()), "Inverse de -5/11");
	}

	@Test
	void testEstPositif()
	{
		assertTrue(cree(4, 5).estPositif(), "4/5 >= 0 ?");
		assertFalse(cree(-4, 5).estPositif(), "-4/5 >= 0 ?");
		assertFalse(cree(4, -5).estPositif(), "4/-5 >= 0 ?");
		assertTrue(cree(-4, -5).estPositif(), "-4/-5 >= 0 ?");
		assertTrue(cree(0, 2).estPositif(), "0/2 >= 0 ?");
		assertTrue(cree(0, -1).estPositif(), "0/-1 >= 0 ?");
	}

	@Test
	void testPlus()
	{
		assertTrue(equals(cree(2, 1), cree(1, 2).plus(cree(6, 4))), "1/2 + 6/4 = 2/1");
	}

	@Test
	void testMoins()
	{
		assertTrue(equals(cree(2, 1), cree(6, 2).moins(cree(1, 1))), "6/2 - 1/1 = 2/1");
	}

	@Test
	void testMultiplie()
	{
		assertTrue(equals(cree(40, 2), cree(10, 2).multiplie(cree(4, 1))), "10/2 * 4/1 = 40/2");
	}

	@Test
	void testDivise()
	{
		assertTrue(equals(cree(10, 8), cree(10, 2).divise(cree(4, 1))), "(10/2) / (6/4) = 10/8");
	}

	@Test
	void testEquals()
	{
		assertTrue(cree(6, 5).equals(cree(6, 5)), "6/5 == 6/5");
		assertFalse(cree(6, 5).equals(cree(6, 4)), "6/5 == 6/4");
		assertTrue(cree(2, 1).equals(cree(2, 1)), "2/1 == 2/1");
		assertTrue(cree(20, 1).equals(cree(20, 1)), "20/1 == 20/1");
		assertTrue(cree(5, 2).equals(cree(15, 6)), "5/2 == 15/6");
		assertTrue(cree(1, Integer.MAX_VALUE).equals(cree(1, Integer.MAX_VALUE)), "1/" + Integer.MAX_VALUE + " == 1/" + Integer.MAX_VALUE);
		assertFalse(cree(1, Integer.MAX_VALUE - 1).equals(cree(1, Integer.MAX_VALUE)), "(" + Integer.MAX_VALUE + " - 1)/" + Integer.MIN_VALUE + " == " + Integer.MAX_VALUE + "/" + Integer.MIN_VALUE);
	}

	@Test
	void testCompareTo()
	{
		assertTrue(cree(5, 7).compareTo(cree(10, 8)) < 0, "5/7 > 10/8 doit retourner un nombre négatif");
		assertTrue(cree(5, 7).compareTo(cree(-10, 8)) > 0, "5/7 > -10/8 doit retourner un nombre positif");
		assertTrue(cree(-5, 7).compareTo(cree(-5, 7)) == 0, "-5/7 > -5/7 doit retourner zéro");
		assertTrue(cree(Integer.MAX_VALUE, Integer.MIN_VALUE).compareTo(cree(Integer.MAX_VALUE, Integer.MIN_VALUE)) == 0, Integer.MAX_VALUE + "/" + Integer.MIN_VALUE + " > " + Integer.MAX_VALUE + "/" + Integer.MIN_VALUE + " doit retouner zéro.");
		assertFalse(cree(Integer.MAX_VALUE - 1, Integer.MIN_VALUE).compareTo(cree(Integer.MAX_VALUE, Integer.MIN_VALUE)) > 1, "(" + Integer.MAX_VALUE + " - 1)/" + Integer.MIN_VALUE + " == " + Integer.MAX_VALUE + "/" + Integer.MIN_VALUE + " doit retouner un nombre négatif.");
	}
	
	@Test 
	void testPgcd()
	{
		assertEquals(1, Rationnel.pgcd(13, 21), "pgcd(13, 21)");
		assertEquals(5, Rationnel.pgcd(35, 40), "pgcd(35, 40)");
		assertTrue(hardEquals(cree(13, 21), Rationnel.cree(26, 42)), "26/42 doit être simplifié en 13/21");
		assertTrue(hardEquals(cree(7, 8), Rationnel.cree(35, 40)), "35/40 doit être simplifié en 7/8");
	}
}
