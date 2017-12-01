package hibernate.relations;

import static hibernate.relations.Passerelle.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRelations
{
	private Client joffrey;
	private Commande commandeJoffrey;
	private Produit arbalete;
	
	@Before
	public void setUp() throws Exception
	{
		open();
	}

	@After
	public void tearDown() throws Exception
	{
		deleteCommandeJoffrey();
		deleteJoffrey();
		deleteArbalete();
		close();
	}

	private void reopen() throws RuntimeException
	{
		close();
		open();
	}

	private int count(String className)
	{
		return getData(className).size();
	}
	
	private void createJoffrey()
	{
		if (joffrey == null)
		{
			joffrey = new Client("Joffrey");
			assertEquals(0, joffrey.getNum());
			joffrey.save();
		}
	}
	
	private void deleteJoffrey()
	{
		if (joffrey != null)
		{
			joffrey.delete();
			assertNotEquals(0, joffrey.getNum());
			assertNotEquals(0, joffrey.getNum());
			joffrey = null;
		}
		reopen();
		assertEquals(0, count("Client"));
		assertEquals(0, count("Commande"));
	}

	private void createCommandeJoffrey()
	{
		createJoffrey();
		commandeJoffrey = joffrey.createCommande();
		commandeJoffrey.save();
		assertEquals(joffrey, commandeJoffrey.getClient());
	}
	
	private void deleteCommandeJoffrey()
	{
		if (commandeJoffrey != null)
		{
			assertEquals(1, count("Client"));
			commandeJoffrey.delete();
			commandeJoffrey = null;
			assertEquals(1, count("Client"));
		}
		assertEquals(0, count("Commande"));
	}

	private void createArbalete()
	{
		arbalete = new Produit("Arbalète", 12);
		assertEquals(0, arbalete.getNum());
		arbalete.save();
	}
	
	private void deleteArbalete()
	{
		if (arbalete != null)
		{
			arbalete.delete();
			assertNotEquals(0, arbalete.getNum());
			arbalete = null;
		}
		assertEquals(0, count("Produit"));
	}

	@Test
	public void testCreateDeleteClient() throws Exception
	{
		createJoffrey();
		assertEquals(joffrey.getNom(), "Joffrey");
		int id = joffrey.getNum();
		assertNotEquals(0, id);
		assertEquals(joffrey, getData("Client", id));
		reopen();
		joffrey = getData("Client", id);
		assertEquals("Joffrey", joffrey.getNom());
		assertEquals(1, count("Client"));
		deleteJoffrey();
		assertEquals(0, count("Client"));
	}
	
	@Test
	public void testCreateDeleteCommande() throws Exception
	{
		createCommandeJoffrey();
		int id = joffrey.getNum();
		reopen();
		assertEquals(1, count("Commande"));
		joffrey = getData("Client", id);
		assertEquals(1, joffrey.getCommandes().size());
		commandeJoffrey = joffrey.getCommandes().first();
		deleteCommandeJoffrey();
		assertEquals(0, joffrey.getCommandes().size());
	}

	@Test
	public void testInsertionClientCascade() throws Exception
	{
		Client cersei = new Client("Cersei");
		Commande commandeCersei = cersei.createCommande();
		assertEquals(0, count("Commande"));
		assertEquals(0, cersei.getNum());
		commandeCersei.save();
		int id = cersei.getNum();
		assertNotEquals(id, 0);
		assertEquals(1, count("Client"));
		assertEquals(1, count("Commande"));
		assertEquals(cersei, getData("Client", id));
		assertEquals(commandeCersei, getData("Commande", commandeCersei.getNum()));
		reopen();
		assertEquals(1, count("Client"));
		assertEquals(1, count("Commande"));
		cersei = ((Client) getData("Client", id));
		assertEquals("Cersei", cersei.getNom());
		cersei.delete();
		assertEquals(0, count("Client"));
		assertEquals(0, count("Commande"));
		reopen();
		assertEquals(0, count("Client"));
		assertEquals(0, count("Commande"));
	}

	@Test
	public void testCreateDeleteProduit() throws Exception
	{
		createArbalete();
		int id = arbalete.getNum();
		assertNotEquals(id, 0);
		assertEquals(count("Produit"), 1);
		assertEquals(arbalete, getData("Produit", id));
		reopen();
		assertEquals(count("Produit"), 1);
		arbalete = getData("Produit", id);
		assertEquals(arbalete.getNom(), "Arbalète");
		assertEquals(arbalete.getPrix(), 12, 0);
		deleteArbalete();
		assertEquals(count("Produit"), 0);
	}

	@Test
	public void testAddRemoveProduitCommande() throws Exception
	{
		createJoffrey();
		createArbalete();
		createCommandeJoffrey();
		int id = joffrey.getNum();
		commandeJoffrey.add(arbalete, 2);
		assertEquals(1, commandeJoffrey.getDetailsCommande().size());
		commandeJoffrey.save();
		reopen();
		joffrey = getData("Client", id);
		commandeJoffrey = joffrey.getCommandes().first();
		assertEquals(1, commandeJoffrey.getDetailsCommande().size());
		arbalete = commandeJoffrey.getProduits().first();
		assertEquals(2, commandeJoffrey.getQuantite(arbalete));
		Produit hachoir = new Produit("Hachoir", 5);
		commandeJoffrey.add(hachoir, 3);
		commandeJoffrey.save();
		assertEquals(2, count("Produit"));
		assertEquals(2, commandeJoffrey.getDetailsCommande().size());
		commandeJoffrey.remove(hachoir);
		assertEquals(2, count("Produit"));
		assertEquals(1, commandeJoffrey.getDetailsCommande().size());
		hachoir.delete();
		deleteArbalete();
		assertEquals(0, count("Produit"));
		assertEquals(0, commandeJoffrey.getDetailsCommande().size());
	}

}
