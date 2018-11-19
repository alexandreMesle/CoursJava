package collections.exemples;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetComparator
{
	public static void main(String[] args)
	{
		SortedSet<String> dico = new TreeSet<>
		(
		 		(str1, str2) -> str1.length() - str2.length()
		);
		// ou bien
		/*
		SortedSet<String> dico = new TreeSet<>(new Comparator<String>()		
		{
			@Override
			public int compare(String str1, String str2)
			{
				return str1.length() - str2.length();
			}			
		});
		*/	
		dico.add("xyz");
		dico.add("abcde");
		dico.add("mp");
		dico.add("gfeadcba");
		for (String s : dico)
			System.out.println(s);

	}
}
