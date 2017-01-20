package utilitaires.ligneDeCommande.exemples;

import java.util.ArrayList;
import java.util.List;

import utilitaires.ligneDeCommande.*;

public class ExempleActionListe
{
	public static void main(String[] args)
	{
		List<String> personnes = new ArrayList<>();
		personnes.add("Ginette");
		personnes.add("Marcel");
		personnes.add("Gisèle");
		Liste<String> liste = getListePersonne(personnes);
		liste.start();
	} 

	// Retourne La liste à afficher
	private static Liste<String> getListePersonne(final List<String> personnes)
	{
		Liste<String> liste = new Liste<>("Choisissez une personne pour l'afficher", 
				getActionListePersonnes(personnes));
		return liste;
	}
	
	private static ActionListe<String> getActionListePersonnes(final List<String> personnes)
	{
		return new ActionListe<String>()
		{
			// Retourne les éléments affichés dans le menu.
			public List<String> getListe()
			{
				return personnes;
			}

			// Vide, car on souhaite créer manuellement chaque option.
			public void elementSelectionne(int indice, String element){}

			// Retourne l'option associée à element.
			public Option getOption(final String personne)
			{
				// Crée une option, le raccourci est laissé null car il sera écrasé par l'indice
				return new Option("Afficher " + personne, null, new Action()
				{
					// Action exécutée si l'option est sélectionnée.
					public void optionSelectionnee()
					{
						System.out.println("Affichage de " + personne);
					}
				});
			}
		};
	}
}
