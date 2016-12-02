package testsUnitaires.tp;

/**
 * 
 * Spécifie un point dans le plan (on remarquera qu'un point est aussi un
 * vecteur).
 *
 */

public interface InterfacePoint
{
	public int getOrd();

	public int getAbs();

	public void setOrd(int ord);

	public void setAbs(int abs);

	/**
	 * Retourne la somme des deux points.
	 */

	public InterfacePoint add(InterfacePoint p);

	public boolean equals(InterfacePoint p);
}
