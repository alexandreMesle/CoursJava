package utilitaires.ligneDeCommande;

/**
 * Permet d'affecter des actions au choix d'un élément dans un menu.
 */

public interface Action
{
	/**
	 * Action prédéfinie permettant de quitter le programme.
	 */
	
	public static final Action 
	QUITTER = new Action()
	{
		@Override 
		public void optionSelectionnee()
		{
			System.exit(0);
		}
	};
	
	/**
	 * Action prédéfinie permettant de revenir au menu précédent.
	 */
	
	public static final Action REVENIR = new Action()
	{
		@Override 
		public void optionSelectionnee(){}
	};

	/**
	 * Fonction automatiquement exécutée quand une option est sélectionnée.
	 */
	
	public void optionSelectionnee();
}
