package utilitaires.ligneDeCommande;

/**
 * Permet d'affecter une action au choix d'un élément dans une liste.
 */

public interface ActionListe<T>
{
	/**
	 * Fonction exécutée lorsqu'un élément est choisi dans une liste.
	 * @param indice indice de l'élément sélectionné.
	 * @param element élément sélectionné.
	 */
	
	public void elementSelectionne(int indice, T element);
}
