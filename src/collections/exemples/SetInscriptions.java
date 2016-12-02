package collections.exemples;

import java.util.HashSet;
import java.util.Set;

public class SetInscriptions
{
	public static void main(String[] args)
	{
		Set<String> inscrits = new HashSet<>();
		inscrits.add("Lucien");
		inscrits.add("Raymond");
		inscrits.add("Huguette");
		System.out.println(inscrits.contains("Gégé"));
		System.out.println(inscrits.contains("Raymond"));
		for (String nom : inscrits)
			System.out.println(nom);
	}
}
