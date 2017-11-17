package hibernate.gestionPersonnes;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;

public abstract class HibernateManagePersonnes
{
	private static java.util.List<Personne> personnes;;

	private static void refreshList()
	{
		personnes = Passerelle.refreshList();
	}

	private static Option getAfficher()
	{
		return new Option("Afficher", "l", 
				() -> 
				{
					refreshList();
					for (Personne personne : personnes)
						System.out.println(personne);
				}
			);
	}

	private static Option getAjouter()
	{
		return new Option("Ajouter", "a", 
				() -> 
				{
					Passerelle.save(new Personne(InOut
						.getString("Prénom : "), InOut
						.getString("Nom : ")));
					refreshList();
				}
			);
	}

	private static Option getSupprimer()
	{
		return new List<>("Supprimer", "s",
				() -> personnes,
				(indice, element) -> 
					{
						Passerelle.delete(element);
						refreshList();
					}
				);
	}

	private static Option getModifier()
	{
		return new List<>("Modifier", "m",
				() -> personnes,
				(indice, element) -> 
					{
						element.setPrenom(InOut
								.getString("Prénom : "));
						element.setNom(InOut.getString("Nom : "));
						Passerelle.save(element);
					}
				);
	}

	private static Menu menuPrincipal()
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
		menuPrincipal().start();
	}
}
