package testsUnitaires.tp;

/**
 * Représente un object mobile dans le plan.
 */

public interface InterfaceCursor
{
	/**
	 * Retourne la position de l'objet.
	 */
	public InterfacePoint getPosition();

	/**
	 * Retourne la direction vers laquelle l'objet est tourné.
	 */
	public InterfacePoint getDirection();

	/**
	 * Restaure la position à 0 et la direction à (1, 0)
	 */

	/**
	 * Détermine la position de l'objet.
	 */
	public void setPosition(InterfacePoint position);

	/**
	 * Détermine la direction vers laquelle l'objet est tourné.
	 */
	public void setDirection(InterfacePoint direction);

	/**
	 * Restaure la position à 0 et la direction à (1, 0)
	 */
	public void reset();

	/**
	 * Fait avancer le mobile d'un pas dans la direction dans laquelle il est
	 * tourné.
	 */
	public void stepStraigth();

	/**
	 * Fait pivoter l'objet d'un quart de tour vers la gauche.
	 */
	public void turnLeft();

	/**
	 * Fait pivoter l'objet d'un quart de tour vers la droite.
	 */
	public void turnRight();
}
