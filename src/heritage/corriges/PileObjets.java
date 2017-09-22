package heritage.corriges;

import java.util.ArrayList;

public class PileObjets
{
	/*
	 * Liste contenant les elements de la pile.
	 */

	private ArrayList<Object> array;

	/*
	 * Constructeur
	 */

	PileObjets()
	{
		array = new ArrayList<>();
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

	public Object sommet()
	{
		if (!estVide())
			return array.get(array.size() - 1);
		return -1;
	}

	/*
	 * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
	 * pile est vide.
	 */

	public void depile()
	{
		if (!estVide())
			array.remove(array.size() - 1);
	}

	/*
	 * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
	 */

	public void empile(Object data)
	{
		array.add(data);
	}

	/*
	 * Retourne une representation de la pile au format chaine de caracteres.
	 */

	@Override
	public String toString()
	{
		return array.toString();
	}

	/*
	 * Teste le fonctionnement de la pile.
	 */

	public static void main(String[] args)
	{
		int nb = 20;
		PileObjets p = new PileObjets();
		int i = 1;
		while (i <= 20)
			p.empile(new Integer(i++));
		System.out.println(p);
		while (!p.estVide())
		{
			System.out.println(p.sommet());
			p.depile();
		}
	}
}
