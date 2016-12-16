package utilitaires.ligneDeCommande.exemples;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

class ExempleMenus
{
	public static void main(String[] args)
	{
		// Création du menu racine de l'application.
		Menu menuPrincipal = new Menu("Menu Principal");
		// Création de deux options
		Option calculatrice = new Option("Calculatrice", "c");
		Menu direBonjour = new Menu("Menu bonjour", "Bonjour", "b");
		// Imbrication des deux options dans le menu
		menuPrincipal.ajoute(calculatrice);
		// Vous remarquez que comme Menu hérite de Option, on peut mettre un menu dans un menu
		menuPrincipal.ajoute(direBonjour);
		menuPrincipal.ajouteQuitter("q");
		// Définition de l'action pour la calculatrice
		calculatrice.setAction(new Action()
		{
			// Méthode exécutée lorsque l'option calculatrice est sélectionnée.
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la première opérande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxième opérande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		});
		// Il est possible de passer l'action en paramètre directement dans le constructeur.
		direBonjour.ajoute(new Option("Dire bonjour", "b", new Action()
		{
			public void optionSelectionnee()
			{
				System.out.println("Bonjour !");
			}
		}));
		// Ajout d'une option permettant de revenir au menu parent
		direBonjour.ajouteRevenir("r");;
		// Retour automatique au menu parent si une option est exécutée.
		direBonjour.setRetourAuto(true);
		// Lancement du menu
		menuPrincipal.start();
	}
}
