package encapsulation.corriges;

import java.util.ArrayList;

public class PileArrayListInt
{
	/*
	 * Liste contenant les elements de la pile.
	 */

	private ArrayList<Integer> array;

	/*
	 * Constructeur
	 */

	PileArrayListInt()
	{
		array = new ArrayList<>();
	}

	/*
	 * Constructeur de copie.
	 */

	PileArrayListInt(PileArrayListInt other)
	{
		this();
		for(Integer item : other.array)
			array.add(item);
	}

	/*
	 * Retourne vrai si et seulement si la pile est vide
	 */

	public boolean estVide()
	{
		return array.isEmpty();
	}

	/*
	 * Retourne l'element se trouvant au sommet de la pile, -1 si la pile est
	 * vide.
	 */

	public int sommet()
	{
		if (!estVide())
			return array.get(array.size() - 1);
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
			array.remove(array.size() - 1);
		}
	}

	/********************************************/

	/*
	 * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
	 */

	public void empile(int data)
	{
		array.add(data);
	}

	/********************************************/

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

	public String toString()
	{
		return array.toString();
	}

	/********************************************/

	/*
	 * Teste le fonctionnement de la pile.
	 */

	public static void main(String[] args)
	{
		int nb = 30;
		PileArrayListInt p = new PileArrayListInt();
		int i = 0;
		while (i < nb)
			p.empile(i++);
		System.out.println(p);
		while (!p.estVide())
		{
			System.out.println(p.sommet());
			p.depile();
		}
	}
}
