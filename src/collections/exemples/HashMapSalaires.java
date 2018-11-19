package collections.exemples;

import java.util.TreeMap;
import java.util.SortedMap;

public class HashMapSalaires
{
	public static void main(String[] args)
	{
		SortedMap<String, Integer> salaires = new TreeMap<>();
		salaires.put("Raymond", 1000);
		salaires.put("Marcel", 2000);
		salaires.put("Ursule", 3000);
		for(String nom : salaires.keySet())
			System.out.println("Le salaire de " + nom + " est " 
				+ salaires.get(nom) + " euros.");
	}
}
