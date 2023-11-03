package encapsulation.tp.facturesClients.corrige;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFacture
{
	private Client marcel, gertrude;
	private Facture factureMarcel1, factureMarcel2, factureGertrude;
	
	@BeforeEach
	private void setUp()
	{
		marcel = new Client("Marcel");
		gertrude = new Client("Gertrude");
		factureMarcel1 = marcel.createFacture(1);
		factureMarcel2 = marcel.createFacture(3);
		factureGertrude = gertrude.createFacture(5);
	}
	

	@Test
	void testGetClient()
	{
		assertEquals(marcel, factureMarcel1.getClient());
		assertEquals(marcel, factureMarcel2.getClient());
		assertEquals(gertrude, factureGertrude.getClient());
	}

	@Test
	void testGetMontant()
	{
		assertEquals(1, factureMarcel1.getMontant());
		assertEquals(3, factureMarcel2.getMontant());
		assertEquals(5, factureGertrude.getMontant());
	}

	@Test
	void testGetReglee()
	{
		assertFalse(factureMarcel1.estReglee());
		assertFalse(factureMarcel2.estReglee());
		assertFalse(factureGertrude.estReglee());
	}

	@Test
	void testGetDate()
	{
		assertEquals(LocalDate.now(), factureMarcel1.getDate());
		assertEquals(LocalDate.now(), factureMarcel2.getDate());
		assertEquals(LocalDate.now(), factureGertrude.getDate());
	}
	
	@Test
	void testCopie()
	{
		Facture copieFactureMarcel1 = factureMarcel1.copie();
		assertEquals(factureMarcel1.getDate(), copieFactureMarcel1.getDate());
		assertEquals(factureMarcel1.getMontant(), copieFactureMarcel1.getMontant());
		assertNotEquals(copieFactureMarcel1, factureMarcel1);
		assertEquals(3, marcel.getFactures().size());
		assertTrue(marcel.getFactures().contains(factureMarcel1));
		assertTrue(marcel.getFactures().contains(factureMarcel2));
		assertTrue(marcel.getFactures().contains(copieFactureMarcel1));
	}
	
	@Test
	void testDelete()
	{
		factureMarcel2.delete();
		assertEquals(1, marcel.getFactures().size());
		assertEquals(1, gertrude.getFactures().size());
		assertEquals(factureMarcel1, marcel.getFactures().get(0));
		assertEquals(factureGertrude, gertrude.getFactures().get(0));
		factureGertrude.delete();
		assertEquals(1, marcel.getFactures().size());
		assertEquals(0, gertrude.getFactures().size());
		assertEquals(factureMarcel1, marcel.getFactures().get(0));
		factureMarcel1.delete();
		assertEquals(0, marcel.getFactures().size());
		assertEquals(0, gertrude.getFactures().size());
	}
}
