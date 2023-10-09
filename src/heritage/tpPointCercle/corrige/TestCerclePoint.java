package heritage.tpPointCercle.corrige;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCerclePoint {

	@Test
	public void testPoint()
	{
		Point p = new Point(3, 4);
		Point q = new Point(5, 6);
		assertEquals(3, p.getAbs(), "abs should be 3");
		assertEquals(4, p.getOrd(), "ord should be 4");
		assertEquals(5, q.getAbs(), "abs should be 5");
		assertEquals(6, q.getOrd(), "ord should be 6");
	}

	public void testSetPoint()
	{
		Point p = new Point(3, 4);
		Point q = new Point(5, 6);
		p.setAbs(7);
		p.setOrd(8);
		q.setAbs(9);
		q.setOrd(10);
		assertEquals(7, p.getAbs(), "abs should be 7");
		assertEquals(8, p.getOrd(), "ord should be 8");
		assertEquals(9, q.getAbs(), "abs should be 9");
		assertEquals(10, q.getOrd(), "ord should be 10");
	}

	@Test
	public void testToStringPoint()
	{
		Point p = new Point(3, 4);
		Point q = new Point(5, 6);
		assertEquals("(abs = 3.0 ; ord = 4.0)", p.toString(), "testToString");
		assertEquals("(abs = 5.0 ; ord = 6.0)", q.toString(), "testToString");
	}

	@Test
	public void testCercle()
	{
		Cercle p = new Cercle(3, 4, 5);
		Cercle q = new Cercle(6, 7, 8);
		assertEquals(3, p.getAbs(), "abs should be 3");
		assertEquals(4, p.getOrd(), "ord should be 4");
		assertEquals(5, p.getRayon(), "rayon should be 5");
		assertEquals(6, q.getAbs(), "abs should be 6");
		assertEquals(7, q.getOrd(), "ord should be 7");
		assertEquals(8, q.getRayon(), "rayon should be 8");
	}

	@Test
	public void testRayonNegatif()
	{
		Cercle p = new Cercle(3, 4, 5);
		p.setRayon(-1);
		assertEquals(3, p.getAbs(), "abs should be 3");
		assertEquals(4, p.getOrd(), "ord should be 4");
		assertEquals(5, p.getRayon(), "rayon should be 5");
	}

	@Test
	public void testSurchargeCercle()
	{
		Cercle p = new Cercle(new Point(3, 4), 5);
		Cercle q = new Cercle(new Point(6, 7), 8);
		assertEquals(3, p.getAbs(), "abs should be 3");
		assertEquals(4, p.getOrd(), "ord should be 4");
		assertEquals(5, p.getRayon(), "rayon should be 5");
		assertEquals(6, q.getAbs(), "abs should be 6");
		assertEquals(7, q.getOrd(), "ord should be 7");
		assertEquals(8, q.getRayon(), "rayon should be 8");
	}

	@Test
	public void testSetCercle()
	{
		Cercle p = new Cercle(3, 4, 5);
		Cercle q = new Cercle(6, 7, 8);
		p.setAbs(9);
		p.setOrd(10);
		p.setRayon(11);
		q.setAbs(12);
		q.setOrd(13);
		q.setRayon(14);
		assertEquals(9, p.getAbs(), "abs should be 9");
		assertEquals(10, p.getOrd(), "ord should be 10");
		assertEquals(11, p.getRayon(), "rayon should be 11");
		assertEquals(12, q.getAbs(), "abs should be 12");
		assertEquals(13, q.getOrd(), "ord should be 13");
		assertEquals(14, q.getRayon(), "rayon should be 14");
	}

	@Test
	public void testToStringCercle()
	{
		Cercle p = new Cercle(3, 4, 5);
		Cercle q = new Cercle(6, 7, 8);
		assertEquals("(centre = (abs = 3.0 ; ord = 4.0); rayon = 5.0)", p.toString(), "testToString");
		assertEquals("(centre = (abs = 6.0 ; ord = 7.0); rayon = 8.0)", q.toString(), "testToString");
	}

	@Test
	public void testPolymorphisme()
	{
		Point p = new Cercle(3, 4, 5);
		Point q = new Cercle(6, 7, 8);
	}

}
