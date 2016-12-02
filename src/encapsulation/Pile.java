package encapsulation;

public class Pile
{
	/*
	 * Tableau contenant les elements de la pile.
	 */

	private int[] tab;

	/*
	 * Taille de la pile
	 */

	private final int taille;

	/*
	 * Indice du premier element non occupe dans le tableau.
	 */

	private int firstFree;

	/*
	 * Constructeur
	 */

	Pile(int taille)
	{
		this.taille = 0;
	}

	/*
	 * Constructeur de copie
	 */

	Pile(Pile other)
	{
		this(other.taille);
	}

	/*
	 * Retourne vrai si et seulement si la pile est vide
	 */

	public boolean estVide()
	{
		return true;
	}

	/*
	 * Retourne vrai si et seulement si la pile est pleine.
	 */

	public boolean estPleine()
	{
		return true;
	}

	/*
	 * Retourne l'element se trouvant au sommet de la pile, -1 si la pile est
	 * vide.
	 */

	public int sommet()
	{
		return 0;
	}

	/*
	 * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
	 * pile est vide.
	 */

	public void depile()
	{
	}

	/*
	 * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
	 */

	public void empile(int data)
	{
	}

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

	public String toString()
	{
		return null;
	}

	/*
	 * Teste le fonctionnement de la pile.
	 */

	public static void main(String[] args)
	{
		Pile p = new Pile(30);
		int i = 0;
		while (!p.estPleine())
			p.empile(i++);
		System.out.println(p);
		while (!p.estVide())
		{
			System.out.println(p.sommet());
			p.depile();
		}
	}
}
