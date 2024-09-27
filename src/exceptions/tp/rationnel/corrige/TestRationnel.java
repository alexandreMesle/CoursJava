package exceptions.tp.rationnel.corrige;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class TestRationnel
{
	private static Rationnel cree(int num, int den)
	{
		return new Rationnel(num, den);
	}
	
    private boolean equals(Rationnel a, Rationnel b)
    {
        return a != null && b != null && a.getNum() * b.getDen() == a.getDen() * b.getNum();
    }

    private boolean hardEquals(Rationnel a, Rationnel b)
    {
        return a != null && b != null && a.getNum() == b.getNum() && a.getDen() == b.getDen() ;
    }
    
	@Test
	void testConstructeur()
	{
		assertEquals(3, cree(3, 4).getNum(), "Numérateur de 3/4");
		assertEquals(6, cree(5, 6).getDen(), "Dénominateur de 5/6");
	}

	@Test
	void testConstructeurDivisionParZero()
	{
		assertThrows(Rationnel.CannotSetZeroToDenominator.class, () -> cree(5, 0), "La création d'un rationnel avec un zéro au dénominateur aurait dû déclencher une exception.");
	}

	@Test
	void testSurchargeConstructeur()
	{
		assertTrue(hardEquals(new Rationnel(3), cree(3, 1)), "Création de 3/1 avec la surchage de constructeur");
		assertTrue(hardEquals(new Rationnel(5), cree(5, 1)), "Création de 5/1 avec la surchage de constructeur");
	}
	
	@Test
	void testSetNum()
	{
		Rationnel r = cree(6, 5);
		r.setNum(7);
		assertEquals(7, r.getNum(), "Le numérateur de 6/5 aurait dû être changé en 7");
	}

	@Test
	void testSetDen()
	{
		Rationnel r = cree(6, 5);
		r.setDen(7);
		assertEquals(7, r.getDen(), "Le dénominateur de 6/5 aurait dû être changé en 7");
		assertThrows(Rationnel.CannotSetZeroToDenominator.class, () -> r.setDen(0), "L'affection d'un zéro au dénominateur aurait dû déclencher une exception.");
	}

	
    @Test
	void testToString()
	{
		assertEquals("5/64", cree(5, 64).toString(), "Création de 5/64");
		assertEquals("-5/8", cree(-5, 8).toString(), "Création de -5/8");
	}

	@Test
	void testCopie()
	{
		Rationnel r = cree(6, 5), t = r.copie();
		assertTrue(hardEquals(r, t), "Copie de 6/5");
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
	}

	@Test
	void testPlus()
	{
		assertTrue(equals(cree(2, 1), cree(1, 2).plus(cree(6, 4))), "1/2 + 6/4 != " + cree(1, 2).plus(cree(6, 4)));
		assertTrue(equals(cree(17, 12), cree(3, 4).plus(cree(2, 3))), "3/4 + 2/3 != " + cree(3, 4).plus(cree(2, 3)));
		assertTrue(equals(cree(235, 248), cree(13, 8).plus(cree(-21, 31))), "13/8 + -21/31 != " + cree(13, 8).plus(cree(-21, 31)));
	}

	@Test
	void testMoins()
	{
		assertTrue(equals(cree(-1, 1), cree(1, 2).moins(cree(6, 4))), "1/2 - 6/4 != " + cree(1, 2).moins(cree(6, 4)));
		assertTrue(equals(cree(1, 12), cree(3, 4).moins(cree(2, 3))), "3/4 - 2/3 != " + cree(3, 4).moins(cree(2, 3)));
		assertTrue(equals(cree(571, 248), cree(13, 8).moins(cree(-21, 31))), "13/8 - -21/31 != " + cree(13, 8).moins(cree(-21, 31)));
	}

	@Test
	void testMultiplie()
	{
		assertTrue(equals(cree(40, 2), cree(10, 2).multiplie(cree(4, 1))), "10/2 * 4/1 != " + cree(10, 2).multiplie(cree(4, 1)));
		assertTrue(equals(cree(205, -117), cree(-5, 9).multiplie(cree(41, 13))), "10/2 * 4/1 != " + cree(-5, 9).multiplie(cree(41, 13)));
		assertTrue(equals(cree(-13, 1050), cree(13, -21).multiplie(cree(-2, -100))), "10/2 * 4/1 != " + cree(13, -21).multiplie(cree(-2, -100)));
	}

	@Test
	void testDivise()
	{
		assertTrue(equals(cree(5, 4), cree(10, 2).divise(cree(4, 1))), "10/2 / 4/1 != " + cree(10, 2).divise(cree(4, 1)));
		assertTrue(equals(cree(65, -369), cree(-5, 9).divise(cree(41, 13))), "10/2 / 4/1 != " + cree(-5, 9).divise(cree(41, 13)));
		assertTrue(equals(cree(-650, 21), cree(13, -21).divise(cree(-2, -100))), "10/2 / 4/1 != " + cree(13, -21).divise(cree(-2, -100)));
	}

	@Test
	void testEquals()
	{
		assertTrue(cree(6, 5).equals(cree(6, 5)), "6/5 == 6/5");
		assertFalse(cree(6, 5).equals(cree(6, 4)), "6/5 == 6/4");
		assertTrue(cree(2, 1).equals(cree(2, 1)), "2/1 == 2/1");
		assertTrue(cree(20, 1).equals(cree(20, 1)), "20/1 == 20/1");
		assertTrue(cree(5, 2).equals(cree(15, 6)), "5/2 == 15/6");
	}

	@Test
	void testCompareTo()
	{
		assertTrue(cree(5, 7).compareTo(cree(10, 8)) < 0, "5/7 > 10/8 doit retourner un nombre négatif");
		assertTrue(cree(5, 7).compareTo(cree(-10, 8)) > 0, "5/7 > -10/8 doit retourner un nombre positif");
		assertTrue(cree(-5, 7).compareTo(cree(-5, 7)) == 0, "-5/7 > -5/7 doit retourner zéro");
	}
	
	@Test 
	void testPgcd() throws IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, NoSuchMethodException, SecurityException
	{
		Class[] types = {int.class, int.class};
		Method pgcd = Rationnel.class.getDeclaredMethod("pgcd", types);
		pgcd.setAccessible(true);
		assertEquals(1, pgcd.invoke(null, 13, 21), "pgcd(13, 21)");
		assertEquals(5, pgcd.invoke(null, 35, 40), "pgcd(35, 40)");
		assertTrue(hardEquals(cree(13, 21), cree(26, 42)), "26/42 devrait être automatiquement simplifié en 13/21");
		assertTrue(hardEquals(cree(7, 8), cree(35, 40)), "35/40 devrait être automatiquement simplifié en 7/8");
	}
}
