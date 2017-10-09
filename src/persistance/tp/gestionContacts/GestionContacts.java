package persistance.tp.gestionContacts;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;

public class GestionContacts
{
	private ListeContacts listeContacts = ListeContacts.getListeContacts();

	private Option getAfficher()
	{
		return new Option("Liste des contacts", "l", new Action()
		{
			public void optionSelected()
			{
				System.out.println(listeContacts);
			}
		});
	}

	private Option getAfficher(final Contact contact)
	{
		return new Option("Afficher", "a", new Action()
		{
			public void optionSelected()
			{
				System.out.println(contact);
			}
		});
	}

	private Option getAjouter()
	{
		return new Option("Ajouter un contact", "a", new Action()
		{
			@Override
			public void optionSelected()
			{
				listeContacts.ajouter(InOut.getString("nom : "),
						InOut.getString("e-mail : "));
			}
		});
	}

	private Option getModifier(final Contact contact, final char champ)
	{
		final String lib = (champ == 'n') ? "nom" : "mail";
		return new Option("Modifier le " + lib, "" + champ, new Action()
		{
			@Override
			public void optionSelected()
			{
				String str = "nouveau " + lib + " : ";
				if (champ == 'n')
					listeContacts.renommer(contact, InOut.getString(str));
				else
					contact.setEMail(InOut.getString(str));
			}
		});
	}

	private Menu getModifier(Contact contact)
	{
		Menu menu = new Menu("Modifier " + contact.getNom());
		menu.add(getAfficher(contact));
		menu.add(getModifier(contact, 'n'));
		menu.add(getModifier(contact, 'm'));
		menu.addBack("r");
		return menu;
	}

	private Option getModifier()
	{
		return new List<Contact>("Modifier un contact", "m",
				() -> listeContacts.getContacts(),
				(contact) -> getModifier(contact));
	}

	private Option getSupprimer()
	{
		return new List<>("Supprimer un contact", "s",
				() -> listeContacts.getContacts(),
				(indice, element) -> listeContacts.supprimer(element));
	}

	private Option getRechercher()
	{
		return new Option("Rechercher un contact", "r", 
				() ->
				{
					String nom = InOut.getString("nom : ");
					Contact contact = listeContacts.getContact(nom);
					if (contact == null)
						System.out.println("Ce contact n'existe pas");
					else
						System.out.println(contact);
				}
			);
	}

	private Option getQuitter(final boolean enregistrer)
	{
		return new Option((enregistrer) ? "Enregistrer et quitter"
				: "Quitter sans enregistrer", (enregistrer) ? "r" : "q",
				() -> 
				{
					if (enregistrer)
						listeContacts.ecrire();
					else
						listeContacts.annuler();
					Action.QUIT.optionSelected();
				}
			);
	}

	private Menu getQuitter()
	{
		Menu menu = new Menu("Quitter", "q");
		menu.add(getQuitter(true));
		menu.add(getQuitter(false));
		return menu;
	}

	private Menu getMenu()
	{
		Menu menu = new Menu("Gestion des e-mails");
		menu.add(getAfficher());
		menu.add(getAjouter());
		menu.add(getModifier());
		menu.add(getSupprimer());
		menu.add(getRechercher());
		menu.add(getQuitter());
		return menu;
	}

	public GestionContacts(ListeContacts listeContact)
	{
		this.listeContacts = listeContact;
		getMenu().start();
	}

	public static void main(String[] args)
	{
		new GestionContacts(ListeContacts.getListeContacts());
	}
}