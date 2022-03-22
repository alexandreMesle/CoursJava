package procedural;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class TestGeometrie 
{
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	public TestGeometrie()
	{
	    System.setOut(new PrintStream(out));
	}


	@Test
	void testAfficheCaractere() 
	{
		Geometrie.afficheCaractere('!');
		assertEquals("! ", out.toString());
		out.reset();
		Geometrie.afficheCaractere('#');
		assertEquals("# ", out.toString());
		out.reset();
	}

	@Test
	void testLigneSansReturn() 
	{
		Geometrie.ligneSansReturn(2, '*');
		assertEquals("* * ", out.toString());
		out.reset();
		Geometrie.ligneSansReturn(5, '!');
		assertEquals("! ! ! ! ! ", out.toString());
		out.reset();
	}

	@Test
	void testLigneAvecReturn() 
	{
		Geometrie.ligneAvecReturn(2, '*');
		assertEquals("* * \n", out.toString());
		out.reset();
		Geometrie.ligneAvecReturn(5, '!');
		assertEquals("! ! ! ! ! \n", out.toString());
		out.reset();
	}

	@Test
	void testEspaces() 
	{
		Geometrie.espaces(2);
		assertEquals("    ", out.toString());
		out.reset();
		Geometrie.espaces(5);
		assertEquals("          ", out.toString());
		out.reset();
	}

	@Test
	void testUnCaractereSansReturn() 
	{
		Geometrie.unCaractereSansReturn(2, '*');
		assertEquals("  * ", out.toString());
		out.reset();
		Geometrie.unCaractereSansReturn(5, '!');
		assertEquals("        ! ", out.toString());
		out.reset();
	}

	@Test
	void testUnCaractereAvecReturn() 
	{
		Geometrie.unCaractereAvecReturn(2, '*');
		assertEquals("  * \n", out.toString());
		out.reset();
		Geometrie.unCaractereAvecReturn(5, '!');
		assertEquals("        ! \n", out.toString());
		out.reset();
	}

	@Test
	void testDeuxCaracteres() 
	{
		Geometrie.deuxCaracteres(2, 5, '*');
		assertEquals("  *     * \n", out.toString());
		out.reset();
		Geometrie.deuxCaracteres(1, 2, '#');
		assertEquals("# # \n", out.toString());
		out.reset();
	}

	@Test
	void testCarre() 
	{
		Geometrie.carre(2);
		assertEquals("* * \n* * \n* * \n", out.toString());
		out.reset();
		Geometrie.carre(4);
		assertEquals("* * * * \n*     * \n*     * \n*     * \n* * * * \n", out.toString());
		out.reset();
	}

	@Test
	void testChapeau() 
	{
		Geometrie.chapeau(3, 'x');
		assertEquals(
				"  x   x \n",
				out.toString());
		out.reset();
		Geometrie.chapeau(5, '?');
		assertEquals(
				"      ?   ? \n" + 
				"    ?       ? \n" + 
				"  ?           ? \n" 
				, out.toString());
		out.reset();
	}

	@Test
	void testChapeauInverse() 
	{
		Geometrie.chapeauInverse(3, 'x');
		assertEquals(
				"  x   x \n",
				out.toString());
		out.reset();
		Geometrie.chapeauInverse(5, '?');
		assertEquals(
				"  ?           ? \n" + 
				"    ?       ? \n" + 
				"      ?   ? \n"
				, out.toString());
		out.reset();
	}

	@Test
	void testLosange() 
	{
		Geometrie.losange(3);
		assertEquals(
				"    * \n" +
				"  *   * \n" +
				"*       * \n" +
				"  *   * \n" +
				"    * \n",
				out.toString());
		out.reset();
		Geometrie.losange(5);
		assertEquals(
				"        * \n" +
				"      *   * \n" +
				"    *       * \n" +
				"  *           * \n" +
				"*               * \n" +
				"  *           * \n" +
				"    *       * \n" +
				"      *   * \n" +
				"        * \n",
				out.toString());
		out.reset();
	}

	@Test
	void testCroix() 
	{
		Geometrie.croix(3);
		assertEquals(
				"*       * \n" +
				"  *   * \n" +
				"    * \n" +
				"  *   * \n" +
				"*       * \n",
				out.toString());
		out.reset();
		Geometrie.croix(5);
		assertEquals(
				"*               * \n" +
				"  *           * \n" +
				"    *       * \n" +
				"      *   * \n" +
				"        * \n" +
				"      *   * \n" +
				"    *       * \n" +
				"  *           * \n" +
				"*               * \n",
				out.toString());
		out.reset();
	}
}
