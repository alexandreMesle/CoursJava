package hibernate.gestionContacts;

import java.util.List;

public class GestionContacts
{
	private static GestionContacts gestionContacts = null;
	
	public List<Contact> getContacts()
	{
		return Passerelle.refreshList();		
	}
	
	public static GestionContacts getGestionContacts()
	{
		if (gestionContacts == null)
			gestionContacts = new GestionContacts();
		return gestionContacts;
	}
	
	private GestionContacts(){}
	
	public void sauvegarder(Contact contact)
	{
		Passerelle.save(contact);
	}

	public void supprimer(Contact contact)
	{
		Passerelle.delete(contact);
	}
}
