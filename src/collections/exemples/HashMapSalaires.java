package collections.exemples;

import java.util.HashMap;
import java.util.Map;

public class HashMapSalaires
{
	public static void main(String[] args)
	{
		Map<String, Integer> salaires = new HashMap<>();
		salaires.put("Raymond", 1000);
		salaires.put("Marcel", 2000);
		salaires.put("Ursule", 3000);
		for(String nom : salaires.keySet())
			System.out.println("Le salaire de " + nom + " est " 
				+ salaires.get(nom) + " euros.");
	}
}
