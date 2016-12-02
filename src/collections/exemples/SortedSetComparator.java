package collections.exemples;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetComparator
{
	public static void main(String[] args)
	{
		SortedSet<String> dico = new TreeSet<>(new Comparator<String>()
		{
			@Override
			public int compare(String str1, String str2)
			{
				return str1.length() - str2.length();
			}
		});
		dico.add("abc");
		dico.add("abcde");
		dico.add("ab");
		dico.add("abcdefg");
		for (String s : dico)
			System.out.println(s);

	}
}
