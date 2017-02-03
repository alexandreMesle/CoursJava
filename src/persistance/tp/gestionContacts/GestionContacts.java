package persistance.tp.gestionContacts;

import java.util.List;

import utilitaires.EntreesSorties;
import utilitaires.ligneDeCommande.*;

public class GestionContacts
{
	private ListeContacts listeContacts = ListeContacts.getListeContacts();

	private Option getAfficher()
	{
		return new Option("Liste des contacts", "l", new Action()
		{
			public void optionSelectionnee()
			{
				System.out.println(listeContacts);
			}
		});
	}

	private Option getAfficher(final Contact contact)
	{
		return new Option("Afficher", "a", new Action()
		{
			public void optionSelectionnee()
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
			public void optionSelectionnee()
			{
				listeContacts.ajouter(EntreesSorties.getString("nom : "),
						EntreesSorties.getString("e-mail : "));
			}
		});
	}

	private Option getModifier(final Contact contact, final char champ)
	{
		final String lib = (champ == 'n') ? "nom" : "mail";
		return new Option("Modifier le " + lib, "" + champ, new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				String str = "nouveau " + lib + " : ";
				if (champ == 'n')
					contact.setNom(EntreesSorties.getString(str));
				else
					contact.setEMail(EntreesSorties.getString(str));
			}
		});
	}

	private Menu getModifier(Contact contact)
	{
		Menu menu = new Menu("Modifier un contact");
		menu.ajoute(getAfficher(contact));
		menu.ajoute(getModifier(contact, 'n'));
		menu.ajoute(getModifier(contact, 'm'));
		menu.ajouteRevenir("r");
		return menu;
	}

	private Option getModifier()
	{
		Liste<Contact> modifier = new Liste<>("Modifier un contact", "m",
				new ActionListe<Contact>()
				{
					@Override
					public void elementSelectionne(int indice, Contact element)
					{
						getModifier(element).start();
					}

					@Override
					public List<Contact> getListe()
					{
						return listeContacts.getContacts();
					}

					@Override
					public Option getOption(Contact element)
					{
						return null;
					}
				});
		return modifier;
	}

	private Option getSupprimer()
	{
		Liste<Contact> liste = new Liste<>("Supprimer un contact", "s",
				new ActionListe<Contact>()
				{
					@Override
					public void elementSelectionne(int indice, Contact element)
					{
						listeContacts.supprimer(element);
					}

					@Override
					public List<Contact> getListe()
					{
						return listeContacts.getContacts();
					}

					@Override
					public Option getOption(Contact element)
					{
						return null;
					}
				});
		return liste;
	}

	private Option getRechercher()
	{
		return new Option("Rechercher un contact", "r", new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				String nom = EntreesSorties.getString("nom : ");
				Contact contact = listeContacts.getContact(nom);
				if (contact == null)
					System.out.println("Ce contact n'existe pas");
				else
					System.out.println(contact);
			}
		});
	}

	private Option getQuitter(final boolean enregistrer)
	{
		return new Option((enregistrer) ? "Enregistrer et quitter"
				: "Quitter sans enregistrer", (enregistrer) ? "r" : "q",
				new Action()
				{
					@Override
					public void optionSelectionnee()
					{
						if (enregistrer)
							listeContacts.ecrire();
						else
							listeContacts.annuler();
						Action.QUITTER.optionSelectionnee();
					}
				});
	}

	private Menu getQuitter()
	{
		Menu menu = new Menu("Quitter", "q");
		menu.ajoute(getQuitter(true));
		menu.ajoute(getQuitter(false));
		return menu;
	}

	private Menu getMenu()
	{
		Menu menu = new Menu("Gestion des e-mails");
		menu.ajoute(getAfficher());
		menu.ajoute(getAjouter());
		menu.ajoute(getModifier());
		menu.ajoute(getSupprimer());
		menu.ajoute(getRechercher());
		menu.ajoute(getQuitter());
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