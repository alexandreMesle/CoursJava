package collections.exemples;

import java.util.HashMap;

public class HashMapSalaires
{
	public static void main(String[] args)
	{
		HashMap<String, Integer> salaires = new HashMap<>();
		salaires.put("Jojo", 1000);
		salaires.put("Marcel", 2000);
		salaires.put("Ursule", 3000);
		System.out.println("Le salaire de Marcel est " + 
				salaires.get("Marcel") + " euros.");
	}
}
