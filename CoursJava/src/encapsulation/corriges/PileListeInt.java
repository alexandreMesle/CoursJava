package encapsulation.corriges;

public class PileListeInt
{
	/*
	 * Liste contenant les elements de la pile.
	 */

	private ListeInt l;

	/********************************************/

	/*
	 * Taille de la pile
	 */

	private final int taille;

	/********************************************/

	/*
	 * Nombre d'elements dans la liste
	 */

	private int nbItems;

	/********************************************/

	/*
	 * Constructeur
	 */

	PileListeInt(int taille)
	{
		l = null;
		this.taille = taille;
		nbItems = 0;
	}

	/********************************************/

	/*
	 * Constructeur de copie.
	 */

	PileListeInt(PileListeInt other)
	{
		taille = other.taille;
		l = new ListeInt(other.l);
		nbItems = other.nbItems;
	}

	/********************************************/

	/*
	 * Retourne vrai si et seulement si la pile est vide
	 */

	public boolean estVide()
	{
		return nbItems == 0;
	}

	/********************************************/

	/*
	 * Retourne vrai si et seulement si la pile est pleine.
	 */

	public boolean estPleine()
	{
		return nbItems == taille;
	}

	/********************************************/

	/*
	 * Retourne l'element se trouvant au sommet de la pile, -1 si la pile est
	 * vide.
	 */

	public int sommet()
	{
		if (!estVide())
			return l.getData();
		return -1;
	}

	/********************************************/

	/*
	 * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
	 * pile est vide.
	 */

	public void depile()
	{
		if (!estVide())
		{
			l = l.getNext();
			nbItems--;
		}
	}

	/********************************************/

	/*
	 * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
	 */

	public void empile(int data)
	{
		l = new ListeInt(data, l);
		nbItems++;
	}

	/********************************************/

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

	public String toString()
	{
		return l.toString();
	}

	/********************************************/

	/*
	 * Teste le fonctionnement de la pile.
	 */

	public static void main(String[] args)
	{
		PileListeInt p = new PileListeInt(30);
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
