package persistance.tp.gestionContacts;

public class GestionContactsJDBC
{
	public static void main(String[] args)
	{
		new GestionContacts(new ListeContactsJDBC());
	}
}
