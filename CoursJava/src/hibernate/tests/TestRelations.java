package hibernate.tests;

import static org.junit.Assert.*;
import hibernate.hibernateRelations.*;
import static hibernate.hibernateRelations.Passerelle.*;

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

	private void reset() throws Exception
	{
		tearDown();
		setUp();
	}

	@Test
	public void all() throws Exception
	{
		testClientCommande();
		testProduit();
		testDeleteClientCommande();
		testDeleteProduit();
	}

	public void testClientCommande() throws Exception
	{
		Client joff = new Client("Joffrey"), cersei = new Client("Cersei");
		Commande joffCmd = joff.createCommande();
		Commande cerseiCommande = cersei.createCommande();
		joff.save();
		// vérifie Joffrey et sa commande
		assertTrue(joff == getData("Client", 1));
		assertTrue(joffCmd == getData("Commande", 1));
		assertTrue(count("Client") == 1);
		assertTrue(count("Commande") == 1);
		cerseiCommande.save();
		// vérifie insertion en cascade Cersei et sa commande
		assertTrue(cersei == getData("Client", 2));
		assertTrue(cerseiCommande == getData("Commande", 2));
		assertTrue(count("Client") == 2);
		assertTrue(count("Commande") == 2);
		reset();
		// Re-vérification avec un reset
		assertTrue(count("Client") == 2);
		assertTrue(count("Commande") == 2);
		joff = Passerelle.<Client> getData("Client", 1);
		cersei = Passerelle.<Client> getData("Client", 2);
		assertTrue("Joffrey != " + joff.getNom(),
				joff.getNom().equals("Joffrey"));
		assertTrue(joff.getCommandes().size() == 1);
		assertTrue(cersei.getCommandes().size() == 1);
		assertTrue(joff.getCommandes().first().getClient() == joff);
		assertTrue(cersei.getCommandes().first().getClient() == cersei);
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
		reset();
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
		reset();
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
