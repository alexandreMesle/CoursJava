/**
 * Permet de mettre en place un dialogue avec l'utilisateur en ligne 
 * de commande. Le dialogue est fait à partir de menus proposant des 
 * options. 
 * 
 * Par exemple, le code ci-dessous met en place un menu dont les deux 
 * uniques options sont afficher bonjour et quitter :
 * 
 * 
<script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>
 <PRE class="prettyprint">
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
	public void optionSelectionnee()
	{
		System.out.println("Bonjour !");
	}
};
// Affectation d'une action à l'option direBonjour
direBonjour.setAction(action);
// Exécution du menu
menu.start();

  </PRE>
  
  Le code ci-dessus affiche le menu suivant :
  
  <PRE>
Menu bonjour
b : Dire Bonjour
q : Quitter
  </PRE>

La saisie du raccourci "b" active l'option "Dire bonjour", et la saisie 
de "q" ferme l'application. Dans le cas où l'option "Dire bonjour" est 
sélectionnée, la méthode optionSelectionnee() reliée à cette option 
est exécutée.

Vous avez aussi la possibilité d'imbriquer un menu dans un menu, 
comme dans l'exemple ci-dessous :

 <PRE class="prettyprint">
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
</PRE>

Voici un exemple d'exécution du programme :

<PRE>
Menu Principal
c : Calculatrice
b : Bonjour
q : Quitter
c
Saisissez la première opérande : 5
Saisissez la deuxième opérande : 6
5 + 6 = 11
Menu Principal
c : Calculatrice
b : Menu bonjour
q : Quitter
b
Menu bonjour
b : Dire bonjour
r : Revenir
b
Bonjour !
Menu Principal
c : Calculatrice
b : Menu bonjour
q : Quitter
q
</PRE>

La librarie permet aussi de créer automatiquement un menu en utilisant une 
liste :

 <PRE class="prettyprint">
// Création d'une liste contenant les trois chaînes "Ginette", "Marcel" et "Gisèle"
final ArrayList&lt;String&gt; personnes = new ArrayList<>();
personnes.add("Ginette");
personnes.add("Marcel");
personnes.add("Gisèle");
// Création d'un menu proposant une option par personne
Liste&lt;String&gt; menu = new Liste&lt;String&gt;("Liste des Personnes", 
	new ActionListe&lt;String&gt;()
	{
		// Retourne la liste des personnes formant le menu
		public List&lt;String&gt; getListe()
		{
			return personnes;
		}

		// Exécutée automatiquement lorsqu'un élément de liste est sélectionné
		public void elementSelectionne(int indice, String element)
		{
			System.out.println("Vous avez sélectionné "+ element+ ", qui a l'indice " + indice);
		}
	});
// Lancement du menu
menu.start();
</PRE>

Voici un exemple d'exécution : 

<PRE>
1 : Ginette
2 : Marcel
3 : Gisèle
2
Vous avez sélectionné Marcel, qui a l'indice 1
</PRE>

Il est conseillé, pour clarifier le code, de répartir les 
instructions dans des fonctions de la façon suivante :

 <PRE class="prettyprint">
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
	Menu direBonjour = new Menu("Menu bonjour", "bonjour", "b");
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

</PRE>
 * Vous pouvez aussi consulter un 
 * <A HREF="https://github.com/alexandreMesle/personnel">Exemple d'implémentation</A>.
 */

package utilitaires.ligneDeCommande;
