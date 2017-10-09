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

public class ListeContacts implements Serializable
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
	
	public void renommer(Contact contact, String nom)
	{
		contacts.remove(contact.getNom());
		contact.setNom(nom);
		ajouter(contact);
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
