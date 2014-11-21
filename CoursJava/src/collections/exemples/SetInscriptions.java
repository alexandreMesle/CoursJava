package collections.exemples;

import java.util.TreeSet;
import java.util.Set;

public class SetInscriptions
{
	public static void main(String[] args)
	{
		Set<String> inscrits = new TreeSet<>();
		inscrits.add("Lucien");
		inscrits.add("Raymond");
		inscrits.add("Huguette");
		System.out.println(inscrits.contains("Gégé"));
		System.out.println(inscrits.contains("Raymond"));
		for (String nom : inscrits)
			System.out.println(nom);
	}
}
