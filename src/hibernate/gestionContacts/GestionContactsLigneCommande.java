package hibernate.gestionContacts;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;

public class GestionContactsLigneCommande
{
	GestionContacts gestionContacts;
	
	public GestionContactsLigneCommande(GestionContacts gestionContacts)
	{
		this.gestionContacts = gestionContacts;
		menuPrincipal().start();
	}
	
	private Option getAfficher()
	{
		return new Option("Afficher", "l", 
				() -> 
				{
					for (Contact contact : gestionContacts.getContacts())
						System.out.println(contact);
				}
			);
	}

	private Option getAjouter()
	{
		return new Option("Ajouter", "a", 
				() -> 
				{
					gestionContacts.sauvegarder(new Contact(
							InOut.getString("Prénom : "), 
							InOut.getString("Nom : ")));
				}
			);
	}

	private Option getSupprimer()
	{
		return new List<>("Supprimer", "s",
				() -> gestionContacts.getContacts(),
				(indice, contact) -> 
					{
						gestionContacts.supprimer(contact);
					}
				);
	}

	private Option getModifier()
	{
		return new List<>("Modifier", "m",
				() -> gestionContacts.getContacts(),
				(indice, contact) -> 
					{
						contact.setPrenom(InOut.getString("Prénom : "));
						contact.setNom(InOut.getString("Nom : "));
						gestionContacts.sauvegarder(contact);
					}
				);
	}

	private Menu menuPrincipal()
	{
		Menu menu = new Menu("Gestionnaire de contacts");
		menu.add(getAfficher());
		menu.add(getAjouter());
		menu.add(getSupprimer());
		menu.add(getModifier());
		menu.addQuit("q");
		return menu;
	}

	public static void main(String[] args)
	{
		new GestionContactsLigneCommande(GestionContacts.getGestionContacts());
	}
}
