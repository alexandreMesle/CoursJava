package utilitaires.ligneDeCommande.exemples;

import utilitaires.ligneDeCommande.*;

public class ExempleFonctions
{
	static Menu getMenuPrincipal()
	{
		Menu menuPrincipal = new Menu("Menu Principal");
		menuPrincipal.ajoute(getOptionCalculatrice());
		menuPrincipal.ajouteQuitter("q");
		return menuPrincipal;
	}

	static Option getOptionCalculatrice()
	{
		Option calculatrice = new Option("Calculatrice", "c", getActionCalculatrice());
		return calculatrice;
	}

	static Action getActionCalculatrice()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la première opérande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxième opérande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Action getActionDireBonjour()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				System.out.println("Bonjour !");
			}
		};
	}
	
	static Option getOptionDireBonjour()
	{
		return new Option("Dire bonjour", "b", getActionDireBonjour());
	}
	
	static Menu getMenuDireBonjour()
	{
		Menu direBonjour = new Menu("Menu bonjour", "Bonjour", "b");
		direBonjour.ajoute(getOptionDireBonjour());
		direBonjour.ajouteRevenir("r");;
		direBonjour.setRetourAuto(true);
		return direBonjour;
	}
	
	public static void main(String[] args)
	{
		Menu menu = getMenuPrincipal();
		menu.start();
	}
}
