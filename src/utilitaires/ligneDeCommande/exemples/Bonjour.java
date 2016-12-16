package utilitaires.ligneDeCommande.exemples;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

class Bonjour
{
	public static void main(String[] args)
	{
		// Création d'un menu dont le titre est "Menu Bonjour"
		Menu menu = new Menu("Menu bonjour");
		// Création d'une option de menu dont le titre est "Dire bonjour"
		// et dont le raccourci clavier est "b"
		Option direBonjour = new Option("Dire Bonjour", "b");
		// Ajout de l'option au menu
		menu.ajoute(direBonjour);
		// Ajout d'une option permettant de quitter l'application
		menu.ajouteQuitter("q");
		// Spécifation de l'action à effectuer lorsqu'une option est sélectionée
		Action action = new Action()
		{
			// Méthode appelée automatiquement lorsqu'une option 
			// est sélectionnée
			@Override
			public void optionSelectionnee()
			{
				System.out.println("Bonjour !");
			}
		};
		// Affectation d'une action à l'option direBonjour
		direBonjour.setAction(action);
		// Lancement du menu
		menu.start();
	}
}
