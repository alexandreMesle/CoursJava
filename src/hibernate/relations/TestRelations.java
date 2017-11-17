package hibernate.relations;

import static hibernate.relations.Passerelle.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRelations
{
	@Before
	public void setUp() throws Exception
	{
		open();
	}

	@After
	public void tearDown() throws Exception
	{
		close();
	}

	private void reopen() throws Exception
	{
		close();
		open();
	}

	private Client createJoffrey()
	{
		Client joffrey = new Client("Joffrey");
		assertEquals(joffrey.getNom(), "Joffrey");
		joffrey.save();
		return joffrey;
	}
	
	@Test
	public void testClient() throws Exception
	{
		Client joffrey = createJoffrey();
		assertEquals(joffrey, getData("Client").get(0));
		int id = joffrey.getNum();
		reopen();
		joffrey = getData("Client", id);
		assertEquals("Joffrey", joffrey.getNom());
		assertEquals(count("Client"), 1);
		joffrey.delete();
		assertEquals(count("Client"), 0);
	}
	
	@Test
	public void testClientCommande() throws Exception
	{
		Client joffrey = createJoffrey();
		Commande commandeJoffrey = joffrey.createCommande();
		commandeJoffrey.save();
		int id = joffrey.getNum();
		reopen();
		assertEquals(count("Commande"), 1);
		joffrey = getData("Client", id);
		assertEquals(joffrey.getCommandes().size(), 1);
		commandeJoffrey = joffrey.getCommandes().first();
		commandeJoffrey.delete();
		assertEquals(joffrey.getCommandes().size(), 0);
		joffrey.delete();
	}

	@Test
	public void testInsertionClientCascade() throws Exception
	{
		Client cersei = new Client("Cersei");
		Commande commandeCersei = cersei.createCommande();
		assertEquals(count("Commande"), 0);
		assertEquals(cersei.getNum(), 0);
		commandeCersei.save();
		int id = cersei.getNum();
		assertNotEquals(id, 0);
		assertEquals(count("Client"), 1);
		assertEquals(count("Commande"), 1);
		assertEquals(cersei, getData("Client", id));
		assertEquals(commandeCersei, getData("Commande", commandeCersei.getNum()));
		reopen();
		assertEquals(count("Client"), 1);
		assertEquals(count("Commande"), 1);
		cersei = ((Client) getData("Client", id));
		assertEquals("Cersei", cersei.getNom());
		cersei.delete();
		assertEquals(count("Client"), 0);
		assertEquals(count("Commande"), 0);
		reopen();
		assertEquals(count("Client"), 0);
		assertEquals(count("Commande"), 0);
	}

	public void testProduit() throws Exception
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
