package collections.exemples;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapSalaires
{
	public static void main(String[] args)
	{
		SortedMap<String, Integer> salaires = new TreeMap<>();
		salaires.put("Dédé", 5000);
		salaires.put("Marcel", 2000);
		salaires.put("Ginette", 3000);
		salaires.put("Lucienne", 1000);
		for (String e : salaires.keySet())
			System.out.println(e);
		for (int e : salaires.values())
			System.out.println(e);
		for (Entry<String, Integer> e : salaires.entrySet())
			System.out.println("Le salaire de " + e.getKey() + " est " + e.getValue());
	}
}
