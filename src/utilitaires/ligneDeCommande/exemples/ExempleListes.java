package utilitaires.ligneDeCommande.exemples;

import java.util.ArrayList;

import java.util.List;

import utilitaires.ligneDeCommande.*;

public class ExempleListes
{
	public static void main(String[] args)
	{
		// Création d'une liste contenant les trois chaînes "Ginette", "Marcel" et "Gisèle"
		final ArrayList<String> personnes = new ArrayList<>();
		personnes.add("Ginette");
		personnes.add("Marcel");
		personnes.add("Gisèle");
		// Création d'un menu proposant une option par personne
		Liste<String> menu = new Liste<String>("Liste des Personnes", 
				new ActionListe<String>()
		{
			// Retourne la liste des personnes formant le menu
			public List<String> getListe()
			{
				return personnes;
			}

			// Exécutée automatiquement lorsqu'un élément de liste est sélectionné
			public void elementSelectionne(int indice, String element)
			{
				System.out.println("Vous avez sélectionné "+ element+ ", qui a l'indice " + indice);
			}

			// Retourne l'option que l'on souhaite créer, null si l'on préfère que l'option soit 
			// crée automatiquement
			public Menu getOption(final String element)
			{
				return null;
			}
		});
		// Ajoute une option quitter à la fin de la liste
		menu.ajouteQuitter("q");
		// Lancement du menu
		menu.start();
	}
}
