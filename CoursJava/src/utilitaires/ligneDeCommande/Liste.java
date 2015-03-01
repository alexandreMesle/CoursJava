package utilitaires.ligneDeCommande;

import java.util.List;

/**
 * Liste de valeurs (de type T) dans laquelle l'utilisateur
 * doit faire une sélection. Les valeurs de trouvant dans le champs
 * {@link liste} sont affichées et l'utilisateur est invité à saisir
 * l'indice de l'élément qu'il souhaite.
 */

public class Liste<T> extends Menu
{
	private ActionListe<T> action;
	private List<T> liste;
	
	/**
	 * Créée une liste.
	 * @param titre intitulé affiché au dessus-de la liste.
	 * @param liste liste affichée.
	 */
	
	public Liste(String titre, List<T> liste)
	{
		super(titre);
		this.liste = liste;
		setRetourAuto(true);
	}
	
	private Action getAction(final int indice, final T element)
	{
		return new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				elementSelectionne(indice, element);
			}
		};
	}

	/**
	 * Créée une liste.
	 * @param titre intitulé affiché au dessus-de la liste.
	 * @param liste liste affichée.
	 * @param raccourci raccourci utilisé dans le cas où cette liste est utilisé comme option dans un menu.
	 */
	
	public Liste(String titre, List<T> liste, String raccourci)
	{
		this(titre, liste);
		this.raccourci = raccourci;
	}
	
	/**
	 * Détermine la fonction à appeler quand un élément est sélectionné.
	 * @param action L'objet dont la fonction elementSelectionne() va être appelé.
	 */
	
	public void setAction(ActionListe<T> action)
	{
		this.action = action;
	}
	
	private void elementSelectionne(int indice, T element)
	{
		if (action != null)
			action.elementSelectionne(indice, element);
	}
	
	private void actualise()
	{
		for (int i = 0 ; i < liste.size() ; i++)
		{
			T element = liste.get(i);
			ajoute(new Option(element.toString(), "" + (i + 1), getAction(i, element))) ;
		}				
	}
	
	/**
	 * Modifie la liste des éléments à sélectionner.
	 * @param liste la nouvelle liste.
	 */
	
	public void setListe(List<T> liste)
	{
		this.liste = liste;
		actualise();
	}
	
	/**
	 * Lance l'exécution de la liste.
	 */
	
	@Override
	public void start()
	{
		actualise();
		super.start();
	}
}
