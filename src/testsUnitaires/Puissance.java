package testsUnitaires;

public interface Puissance
{
	/**
	 * Retourne x + 1. x quelconque.
	 */

	public int succ(int x);

	/**
	 * Retourne x - 1. x quelconque.
	 */

	public int pred(int x);

	/**
	 * Retourne a + b. a et b quelconques.
	 */

	public int somme(int a, int b);

	/**
	 * Retourne a * b. a et b quelconques.
	 */

	public int produit(int a, int b);

	/**
	 * Retourne base^exp. 
	 * base quelconque, exp positif ou nul.
	 */

	public int puissance(int base, int exp);
}
