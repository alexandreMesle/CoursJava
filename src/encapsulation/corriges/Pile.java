package encapsulation.corriges;

public class Pile
{
	/*
	 * Tableau contenant les elements de la pile.
	 */

	private int[] tab;

	/********************************************/

	/*
	 * Taille de la pile
	 */

	private final int taille;

	/********************************************/

	/*
	 * Indice du premier element non occupe dans le tableau.
	 */

	private int firstFree;

	/********************************************/

	/*
	 * Constructeur
	 */

	Pile(int taille)
	{
		this.taille = taille;
		tab = new int[taille];
		firstFree = 0;
	}

	/********************************************/

	/*
	 * Constructeur de copie.
	 */

	Pile(Pile other)
	{
		this(other.taille);
		firstFree = other.firstFree;
		for (int i = 0; i < firstFree; i++)
			tab[i] = other.tab[i];
	}

	/********************************************/

	/*
	 * Retourne vrai si et seulement si la pile est vide
	 */

	public boolean estVide()
	{
		return firstFree == 0;
	}

	/********************************************/

	/*
	 * Retourne vrai si et seulement si la pile est pleine.
	 */

	public boolean estPleine()
	{
		return firstFree == taille;
	}

	/********************************************/

	/*
	 * Retourne l'element se trouvant au sommet de la pile, -1 si la pile est
	 * vide.
	 */

	public int sommet()
	{
		if (estVide())
			return -1;
		return tab[firstFree - 1];
	}

	/********************************************/

	/*
	 * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
	 * pile est vide.
	 */

	public void depile()
	{
		if (!estVide())
			firstFree--;
	}

	/********************************************/

	/*
	 * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
	 */

	public void empile(int data)
	{
		if (!estPleine())
			tab[firstFree++] = data;
	}

	/********************************************/

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

	public String toString()
	{
		String res = "[";
		for (int i = 0; i < firstFree; i++)
			res += " " + tab[i];
		return res + " ]";
	}

	/********************************************/

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
