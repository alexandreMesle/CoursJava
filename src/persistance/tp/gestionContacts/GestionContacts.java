package persistance.tp.gestionContacts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import utilitaires.EntreesSorties;
import utilitaires.ligneDeCommande.*;

class Contact implements Serializable, Comparable<Contact>
{
	private static final long serialVersionUID = 692955532183439742L;
	private String nom, eMail;

	public Contact(String nom, String eMail)
	{
		super();
		this.nom = nom;
		this.eMail = eMail;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String geteMail()
	{
		return eMail;
	}

	public void setEMail(String eMail)
	{
		this.eMail = eMail;
	}

	@Override
	public int compareTo(Contact autre)
	{
		return getNom().compareTo(autre.getNom());
	}

	@Override
	public String toString()
	{
		return nom + " " + eMail;
	}
}

class ListeContacts implements Serializable
{
	private static final long serialVersionUID = -6646400100032738037L;
	private SortedMap<String, Contact> contacts = new TreeMap<>();
	private static ListeContacts listeContacts;
	private static String FILE = "bin/persistance/tp/gestionContacts/gestionEmails.srz";

	public static ListeContacts getListeContacts()
	{
		if (listeContacts == null)
			listeContacts = lire();
		if (listeContacts == null)
			listeContacts = new ListeContacts();
		return listeContacts;
	}

	ListeContacts()
	{
	}

	public List<Contact> getContacts()
	{
		return new ArrayList<>(contacts.values());
	}

	public Contact getContact(String nom)
	{
		return contacts.get(nom);
	}

	protected void ajouter(Contact contact)
	{
		contacts.put(contact.getNom(), contact);
	}

	public void ajouter(String nom, String email)
	{
		ajouter(new Contact(nom, email));
	}

	public void supprimer(Contact contact)
	{
		contacts.remove(contact.getNom());
	}

	@Override
	public String toString()
	{
		if (getContacts().isEmpty())
			return "Aucun contact enregistré";
		String res = "";
		for (Contact contact : getContacts())
			res += contact + "\n";
		return res;
	}

	public void ecrire()
	{
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fos = new FileOutputStream(FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (oos != null)
					oos.close();
			}
			catch (IOException e)
			{
				System.out.println("Impossible de fermer le fichier " + FILE
						+ ".");
			}
		}
	}

	public void annuler()
	{

	}

	private static ListeContacts lire()
	{
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(FILE);
			ois = new ObjectInputStream(fis);
			return (ListeContacts) (ois.readObject());
		}
		catch (IOException | ClassNotFoundException e)
		{
			return null;
		}
		finally
		{
			try
			{
				if (ois != null)
					ois.close();
			}
			catch (IOException e)
			{
				System.out.println("Impossible de fermer le fichier " + FILE
						+ ".");
			}
		}
	}
}

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