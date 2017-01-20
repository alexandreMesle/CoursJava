package utilitaires.ligneDeCommande;

import java.util.List;

/**
 * Permet de gérer les listes. C'est-à-dire : affecter une action au choix d'un élément 
 * dans une liste, et actualiser les éléments de la liste devant être affichée.
 */

public interface ActionListe<T>
{
	/**
	 * Fonction permettant de rafraîchir la liste juste avant de l'afficher.
	 * @returns la liste des éléments parmi lesquels la sélection devra 
	 * se faire.
	 */
	
	public List<T> getListe();

	/**
	 * Fonction exécutée lorsqu'un élément est choisi dans une liste.
	 * @param indice indice de l'élément sélectionné.
	 * @param element élément sélectionné.
	 */
	
	public void elementSelectionne(int indice, T element);

	/**
	 * Fonction permettant d'ajouter un menu dans la liste. Le raccourci sera écrasé par l'indice
	 * de l'élément dans la liste affichée.
	 * @param element élément de la liste affiché dans ce menu.
	 * @returns Le sous-menu qui sera affichée dans la liste.
	 */
	
	public Option getOption(T element);
}
