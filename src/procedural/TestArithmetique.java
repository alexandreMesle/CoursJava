package procedural;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestArithmetique
{

	@Test
	void testPuissance()
	{
		assertEquals(1, Arithmetique.puissance(1,  1));
		assertEquals(1, Arithmetique.puissance(10,  0));
		assertEquals(0, Arithmetique.puissance(0,  10));
		assertEquals(1024, Arithmetique.puissance(2, 10));
		assertEquals(1000000000, Arithmetique.puissance(10, 9));
	}

	@Test
	void testUnites()
	{
		assertEquals(1, Arithmetique.unites(1));
		assertEquals(1, Arithmetique.unites(1111));
		assertEquals(2, Arithmetique.unites(465432));
		assertEquals(0, Arithmetique.unites(4650));
		assertEquals(0, Arithmetique.unites(0));
	}

	@Test
	void testDizaines()
	{
		assertEquals(1, Arithmetique.dizaines(12));
		assertEquals(2, Arithmetique.dizaines(123));
		assertEquals(0, Arithmetique.dizaines(1));
		assertEquals(0, Arithmetique.dizaines(0));
		assertEquals(7, Arithmetique.dizaines(13246578));
		assertEquals(6, Arithmetique.dizaines(111161));
	}

	@Test
	void testExtrait()
	{
		assertEquals(1, Arithmetique.extrait(1, 1));
		assertEquals(1, Arithmetique.extrait(10, 2));
		assertEquals(3, Arithmetique.extrait(321, 3));
		assertEquals(0, Arithmetique.extrait(321, 4));
		assertEquals(7, Arithmetique.extrait(98765432, 6));
	}

	@Test
	void testNbChiffres()
	{
		assertEquals(1, Arithmetique.nbChiffres(1));
		assertEquals(2, Arithmetique.nbChiffres(65));
		assertEquals(4, Arithmetique.nbChiffres(7984));
		assertEquals(1, Arithmetique.nbChiffres(0));
		assertEquals(9, Arithmetique.nbChiffres(132465000));
	}

	@Test
	void testSommeChiffres()
	{
		assertEquals(1, Arithmetique.sommeChiffres(1));
		assertEquals(0, Arithmetique.sommeChiffres(0));
		assertEquals(6, Arithmetique.sommeChiffres(123));
		assertEquals(39, Arithmetique.sommeChiffres(465789));
		assertEquals(17, Arithmetique.sommeChiffres(123450002));
	}

	@Test
	void testDivise()
	{
		assertTrue(Arithmetique.divise(1, 1));
		assertFalse(Arithmetique.divise(2, 1));
		assertTrue(Arithmetique.divise(10, 0));
		assertFalse(Arithmetique.divise(2, 3));
		assertTrue(Arithmetique.divise(4, 12));
		assertFalse(Arithmetique.divise(5, 17));
	}

	@Test
	void testSommeDiviseursStricts()
	{
		assertEquals(6, Arithmetique.sommeDiviseursStricts(6));
		assertEquals(1, Arithmetique.sommeDiviseursStricts(2));
		assertEquals(0, Arithmetique.sommeDiviseursStricts(0));
		assertEquals(1, Arithmetique.sommeDiviseursStricts(17));
		assertEquals(117, Arithmetique.sommeDiviseursStricts(100));
	}

	@Test
	void testSontAmis()
	{
		assertTrue(Arithmetique.sontAmis(220, 284));
		assertFalse(Arithmetique.sontAmis(220, 64));
		assertTrue(Arithmetique.sontAmis(5020, 5564));
		assertFalse(Arithmetique.sontAmis(1000, 2000));
		assertTrue(Arithmetique.sontAmis(1184, 1210));
		assertFalse(Arithmetique.sontAmis(1184, 1500));
		assertTrue(Arithmetique.sontAmis(2620, 2924));
		assertFalse(Arithmetique.sontAmis(12345, 65432));
	}

	@Test
	void testEstParfait()
	{
		assertTrue(Arithmetique.estParfait(6));
		assertFalse(Arithmetique.estParfait(27));
		assertTrue(Arithmetique.estParfait(28));
		assertFalse(Arithmetique.estParfait(150));
		assertTrue(Arithmetique.estParfait(496));
		assertFalse(Arithmetique.estParfait(600));
		assertTrue(Arithmetique.estParfait(8128));
		assertFalse(Arithmetique.estParfait(10000));
	}

	@Test
	void testSommeParties()
	{
		assertEquals(703, Arithmetique.sommeParties(494209, 3));
		assertEquals(4942 + 9, Arithmetique.sommeParties(494209, 2));
		assertEquals(49 + 4209, Arithmetique.sommeParties(494209, 4));
	}

	@Test
	void testEstKaprekar()
	{
		assertTrue(Arithmetique.estKaprekar(9));
		assertFalse(Arithmetique.estKaprekar(10));
		assertTrue(Arithmetique.estKaprekar(99));
		assertFalse(Arithmetique.estKaprekar(100));
		assertTrue(Arithmetique.estKaprekar(703));
		assertFalse(Arithmetique.estKaprekar(2000));
		assertTrue(Arithmetique.estKaprekar(4879));
		assertFalse(Arithmetique.estKaprekar(10000));
		assertTrue(Arithmetique.estKaprekar(142857));
		assertFalse(Arithmetique.estKaprekar(250000));
		assertTrue(Arithmetique.estKaprekar(318682));
		assertFalse(Arithmetique.estKaprekar(350000));
	}

}
