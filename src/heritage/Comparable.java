package heritage;

public interface Comparable
{
	/*
	 * Retourne un nombre négatif si l'objet courant est plus petit que other,
	 * 0 s'ils sont égaux, et un nombre positif l'objet courant est plus grand
	 * que other.
	 */

	public int compareTo(Comparable other);
}
