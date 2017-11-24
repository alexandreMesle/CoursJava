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

	private void reopen() throws Exception
	{
		close();
		open();
	}

	private void createJoffrey()
	{
		joffrey = new Client("Joffrey");
		assertEquals(0, joffrey.getNum());
		joffrey.save();
	}
	
	private void deleteJoffrey()
	{
		if (joffrey != null)
		{
			deleteCommandeJoffrey();
			joffrey.delete();
			assertNotEquals(0, joffrey.getNum());
			joffrey = null;
		}
		assertEquals(0, count("Client"));
	}

	private void createCommandeJoffrey()
	{
		createJoffrey();
		commandeJoffrey = joffrey.createCommande();
		commandeJoffrey.save();
	}
	
	private void deleteCommandeJoffrey()
	{
		if (commandeJoffrey != null)
		{
			commandeJoffrey.delete();
			commandeJoffrey = null;
		}
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
			assertEquals(0, count("Produit"));
		}
	}

	@Test
	public void testClient() throws Exception
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
	public void testClientCommande() throws Exception
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
	public void testProduit() throws Exception
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
	}

	@Test
	public void testProduitCommande() throws Exception
	{
		createJoffrey();
		createArbalete();
		createCommandeJoffrey();
		int id = joffrey.getNum();
		commandeJoffrey.addProduit(arbalete, 2);
		assertEquals(commandeJoffrey.getDetailsCommande().size(), 1);
		commandeJoffrey.save();
		reopen();
		joffrey = getData("Client", id);
		commandeJoffrey = joffrey.getCommandes().first();
		assertEquals(commandeJoffrey.getDetailsCommande().size(), 1);
		arbalete = commandeJoffrey.getProduits().first();
		assertTrue(false);
		deleteArbalete();
	}

	public void testBordel() throws Exception
	{
		Produit arb = new Produit("Arbalète", 600), hachoir = new Produit(
				"Hachoir", 150);
		arb.save();
		// vérification arbalète et hachoir
		assertTrue(count("Produit") == 1);
		assertTrue(arb == getData("Produit", 1));
		Client joff = getData("Client", 1);
		Commande cmd = joff.getCommandes().first();
		cmd.addProduit(arb, 10);
		cmd.addProduit(hachoir, 5);
		// Vérification commande de joffrey
		assertTrue("2 != " + cmd.getProduits().size(),
				cmd.getProduits().size() == 2);
		assertTrue(cmd.getProduits().contains(arb));
		assertTrue(cmd.getProduits().contains(hachoir));
		cmd.save();
		// hachoir inséré en cascade
		assertTrue(hachoir == getData("Produit", 2));
		// *******************************************
		reopen();
		arb = getData("Produit", 1);
		hachoir = getData("Produit", 2);
		// vérification des produits insérés dans la base
		assertTrue(2 == count("Produit"));
		assertTrue(arb.getNom().equals("Arbalète"));
		assertTrue(hachoir.getNom().equals("Hachoir"));
		joff = getData("Client", 1);
		cmd = joff.getCommandes().first();
		// épreuve du reset
		assertTrue(
				"2 != " + cmd.getProduits().size() + " " + cmd.getProduits(),
				cmd.getProduits().size() == 2);
		// arb insérée directement
		assertTrue(cmd.getProduits().contains(arb));
		assertTrue(10 == cmd.getQuantite(arb));
		assertTrue(cmd.getProduits().contains(hachoir));
		assertTrue(5 == cmd.getQuantite(hachoir));
		Client cersei = getData("Client", 2);
		cmd = cersei.getCommandes().first();
		cmd.addProduit(hachoir, 2);
		cmd.save();
		// *******************************************
		reopen();
		cersei = getData("Client", 2);
		cmd = getData("Commande", 2);
		assertTrue(cersei.getCommandes().first() == cmd);
		cmd = cersei.getCommandes().first();
		hachoir = getData("Produit", 2);
		// vérification commande cersei
		assertTrue("1 != " + cmd.getProduits().size(),
				cmd.getProduits().size() == 1);
		assertTrue(cmd.getProduits().contains(hachoir));
		assertTrue(2 == cmd.getQuantite(hachoir));
		// vérification lignes de detailCommande
		assertTrue(3 == count("DetailCommande"));
		// vérification du produit
		assertTrue(2 == hachoir.getNbCommandes());
	}

	public void testDeleteClientCommande() throws Exception
	{
		Client joff = getData("Client", 1);
		joff.delete();
		// vérification suppression en cascade des données de joffrey
		assertTrue(count("Client") == 1);
		assertTrue(!getData("Client").contains(joff));
		assertTrue(count("Commande") == 1);
		// vérification lignes de detailCommande
		assertTrue("1 != " + count("DetailCommande"),
				1 == count("DetailCommande"));
		Client cersei = getData("Client", 2);
		Commande cmd = cersei.getCommandes().first();
		assertTrue(cmd.getClient() == cersei);
		assertTrue(count("Produit") == 2);
		cmd.delete();
		// suppression cascade commande de cersei
		assertTrue(count("Client") == 1);
		assertTrue(count("Commande") == 0);
		assertTrue(cersei == getData("Client", 2));
		assertTrue(count("Produit") == 2);
		// vérification lignes de detailCommande
		assertTrue("0 != " + count("DetailCommande"),
				0 == count("DetailCommande"));
	}

	public void testDeleteProduit() throws Exception
	{
		Produit arb = getData("Produit", 1), hachoir = getData("Produit", 2);
		// réinsertion des données
		Client joff = new Client("Joffrey"), cersei = new Client("Cersei");
		Commande joffCmd = joff.createCommande();
		joffCmd.addProduit(arb, 10);
		joffCmd.addProduit(hachoir, 10);
		Commande cerseiCommande = cersei.createCommande();
		cerseiCommande.addProduit(hachoir, 2);
		joff.save();
		cersei.save();
		// suppression de l'arbalete
		arb.delete();
		// vérfication suppression arbalète
		assertTrue(count("Produit") == 1);
		assertTrue(!getData("Produit").contains(arb));
		// vérification des commandes
		assertTrue(count("Commande") == 2);
		assertTrue("2 != " + count("DetailCommande"),
				count("DetailCommande") == 2);
	}
}
