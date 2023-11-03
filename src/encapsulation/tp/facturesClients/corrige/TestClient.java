package encapsulation.tp.facturesClients.corrige;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClient
{
	private Client marcel, gertrude;
		
	@BeforeEach
	private void setup()
	{
		marcel = new Client("Marcel");
		gertrude = new Client("Gertrude");
	}
	
	@AfterEach
	private void tearDown()
	{
		marcel.delete();
		gertrude.delete();
	}
	

	@Test
	void testGetNom()
	{
		assertEquals("Marcel", marcel.getNom());
		assertEquals("Gertrude", gertrude.getNom());
	}	

	@Test
	void testSetNom()
	{
		marcel.setNom("Bernard");
		gertrude.setNom("Marcelle");
		assertEquals("Bernard", marcel.getNom());
		assertEquals("Marcelle", gertrude.getNom());
	}

	@Test
	void testCreateFacture()
	{
		Facture factureMarcel1 = marcel.createFacture(1),
			factureMarcel2 = marcel.createFacture(3),
			factureGertrude = gertrude.createFacture(5);		
		assertEquals(2, marcel.getFactures().size());
		assertEquals(1, gertrude.getFactures().size());
		assertNotEquals(factureMarcel1, factureMarcel2);
		assertNotEquals(factureMarcel2, factureGertrude);
		assertNotEquals(factureGertrude, factureMarcel1);
		assertTrue(marcel.getFactures().contains(factureMarcel1));
		assertTrue(marcel.getFactures().contains(factureMarcel2));
		assertTrue(gertrude.getFactures().contains(factureGertrude));
	}

	@Test
	void testCreateFactureReglee()
	{
		Facture factureReglee = marcel.createFacture(1, true),
			factureNonReglee = marcel.createFacture(3, false);		
		assertTrue(factureReglee.estReglee());
		assertFalse(factureNonReglee.estReglee());
	}
	
	@Test
	void testGetFactures()
	{
		marcel.createFacture(1);
		marcel.createFacture(3);
		gertrude.createFacture(5);		
		assertTrue(marcel.getFactures() != marcel.getFactures());
		assertTrue(gertrude.getFactures() != gertrude.getFactures());
	}

	@Test
	void testGetFacturesReglees()
	{
		Facture factureMarcel1 = marcel.createFacture(1, true);
		marcel.createFacture(3, false);
		gertrude.createFacture(5, true);
		assertEquals(1, marcel.facturesReglees().size());
		assertTrue(marcel.facturesReglees().contains(factureMarcel1));
	}

	@Test
	void testGetSommeMontant()
	{
		marcel.createFacture(1);
		marcel.createFacture(2);
		gertrude.createFacture(4);
		assertEquals(3, marcel.sommeMontants());
		assertEquals(4, gertrude.sommeMontants());
	}
	
	@Test
	void testTous()
	{
		assertEquals(2, Client.tous().size());
		assertTrue(Client.tous() != Client.tous());
		assertTrue(Client.tous().contains(marcel));
		assertTrue(Client.tous().contains(gertrude));
	}

	@Test
	void testDelete()
	{
		marcel.delete();
		assertEquals(1, Client.tous().size());
		assertTrue(Client.tous().contains(gertrude));
		gertrude.delete();
		assertEquals(0, Client.tous().size());
	}
	
	@Test
	void testMontantFactureNegatif()
	{
		Exception factureMoins2 = assertThrows(IllegalArgumentException.class, () -> marcel.createFacture(-2));
		assertEquals("Le montant d'une facture ne peut pas être négatif.", factureMoins2.getMessage());
		Exception factureZero = assertThrows(IllegalArgumentException.class, () -> marcel.createFacture(0));
		assertEquals("Le montant d'une facture ne peut pas être négatif.", factureZero.getMessage());
	}

}
