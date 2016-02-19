package utilitaires.ligneDeCommande;

import java.util.List;

/**
 * Liste de valeurs (de type T) dans laquelle l'utilisateur
 * doit faire une sélection. Les valeurs de trouvant dans le champs
 * {@link liste} sont affichées et l'utilisateur est invité à saisir
 * l'indice de l'élément qu'il souhaite. Par défaut, la méthode toString
 * héritée de Object est utilisée pour afficher les éléments de menu, 
 * mais vous pouvez le modifier en utilisant la méthode 
 * {@link setToString}.
 */

public class Liste<T> extends Menu
{
	private ActionListe<T> action;
	private ToString<T> convertisseur = null;
	private Option optionQuitter = null, optionRevenir = null;
	
	/**
	 * Créée une liste.
	 * @param titre intitulé affiché au dessus-de la liste.
	 * @param action l'objet permettant de gérer la liste.
	 */
	
	public Liste(String titre, ActionListe<T> action)
	{
		super(titre);
		this.action = action;
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
	 * @param action l'objet permettant de gérer la liste.
	 * @param raccourci raccourci utilisé dans le cas où cette liste est utilisé comme option dans un menu.
	 */
	
	public Liste(String titre, String raccourci, ActionListe<T> action)
	{
		this(titre, action);
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
		List<T> liste = action.getListe();
		clearOptions();
		for (int i = 0 ; i < liste.size() ; i++)
		{
			T element = liste.get(i);
			String string = (convertisseur == null) ? element.toString() : convertisseur.toString(element); 
			super.ajoute(new Option(string, "" + (i + 1), getAction(i, element))) ;
		}
		if (optionQuitter != null)
			super.ajoute(optionQuitter);
		if (optionRevenir!= null)
			super.ajoute(optionRevenir);
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
	
	/**
	 * Définit de quelle façon vont s'afficher les éléments de menu.
	 */
	
	public void setToString(ToString<T> convertisseur)
	{
		this.convertisseur = convertisseur;
	}
	
	public interface ToString<T>
	{
		public String toString(T item);
	}
	
	/**
	 * Déclenche une erreur, il est interdit de modifier les options d'une Liste.
	 */
	
	@Override
	public void ajoute(Option option)
	{
		throw new RuntimeException("Il est interdit d'ajouter manuellement une option dans une liste.");
	}
	
	@Override
	public void ajouteQuitter(String raccourci)
	{
		optionQuitter = new Option("Quitter", raccourci, Action.QUITTER);
	}

	@Override
	public void ajouteRevenir(String raccourci)
	{
		optionRevenir = new Option("Revenir", raccourci, Action.REVENIR);
	}
}
	
