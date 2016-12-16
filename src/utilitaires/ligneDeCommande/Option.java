package utilitaires.ligneDeCommande;

/**
 * Option figurant dans un menu.
 */

public class Option
{
	protected String raccourci;
	private String titre;
	protected Action action;

	public Option(String titre, String raccourci, Action action)
	{
		this.titre = titre;
		this.raccourci = raccourci;
		this.action = action;
	}
	
	/**
	 * Créée une option.
	 * @param titre titre de l'option.
	 * @param raccourci raccourci à saisir pour activer l'option.
	 */
	
	public Option(String titre, String raccourci)
	{
		this.titre = titre;
		this.raccourci = raccourci;
	}
	
	/**
	 * Retourne le raccourci permettant de sélectioner cette option.
	 */
	
	public String getRaccourci()
	{
		return raccourci;
	}

	/**
	 * Retourne le libellé de l'option.
	 */
	
	public String getTitre()
	{
		return titre;
	}

	/**
	 * Affecte une action à la sélection de l'option.
	 * @param action l'objet dont la méthode optionSelectionnee() sera 
	 * appelé une fois une option choisie.
	 */
	
	public void setAction(Action action)
	{
		this.action = action;
	}
	
	/**
	 * Retourne l'action associé à la sélection de l'option.
	 * @return l'objet dont la méthode optionSelectionnee() sera 
	 * appelé une fois une option choisie.
	 */
	
	public Action getAction()
	{
		return action;
	}
	
	void optionSelectionnee()
	{
		if (action != null)
			action.optionSelectionnee();
	}
	
	public String stringOfOption()
	{
		return raccourci + " : " + titre;
	}
}
