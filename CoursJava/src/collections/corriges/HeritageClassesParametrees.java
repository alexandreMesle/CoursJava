package collections.corriges;

import collections.exemples.ClasseParametree;

public class HeritageClassesParametrees
{

	public static void main(String[] args)
	{
		ClasseParametree<Object> o = new ClasseParametree<>(null);
		ClasseParametree<String> s = new ClasseParametree<>("coucou");
		/*
		 * Illégal !!!!!
		o = s;
		*/
		o.set(new Object());
		// Affectation d'un Object à une référence de type String
		String str = s.get();
	}
}
