package collections.exemples;

import java.util.TreeSet;
import java.util.SortedSet;

public class SortedSetDictionnaire
{
	public static void main(String[] args)
	{
		SortedSet<String> dico = new TreeSet<>();
		dico.add("tutu");
		dico.add("toto");
		dico.add("tata");
		dico.add("titi");
		for (String s : dico)
			System.out.println(s);
	}
}
