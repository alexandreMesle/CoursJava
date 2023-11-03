package heritage.tp.animalAbstrait.corrige;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestAnimal
{
	@Test
	void testPolymorphisme()
	{
		Animal chat = new Chat("Ronron");
		Animal chien = new Chien("Médor");
		Animal vache = new Vache("Huguette");
	}
	
	@Test
	void testGetNom()
	{
		Chat chat = new Chat("Ronron");
		Chien chien = new Chien("Médor");
		Vache vache = new Vache("Huguette");
		assertEquals("Ronron", chat.getNom());
		assertEquals("Médor", chien.getNom());
		assertEquals("Huguette", vache.getNom());
	}
	
	@Test
	void testSetNom()
	{
		Chat chat = new Chat("Ronron");
		Chien chien = new Chien("Médor");
		Vache vache = new Vache("Huguette");
		chat.setNom("Ponpon");
		chien.setNom("Hannibal");
		vache.setNom("Kiri");
		assertEquals("Ponpon", chat.getNom());
		assertEquals("Hannibal", chien.getNom());
		assertEquals("Kiri", vache.getNom());
	}
	
	@Test
	void testCri()
	{
		Animal chat = new Chat("Ronron");
		Animal chien = new Chien("Médor");
		Animal vache = new Vache("Huguette");
		assertEquals("Miaou !", chat.cri());
		assertEquals("Waf !", chien.cri());
		assertEquals("Meuh !", vache.cri());
	}
}
