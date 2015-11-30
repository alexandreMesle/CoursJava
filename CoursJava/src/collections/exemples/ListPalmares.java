package collections.exemples;

import java.util.LinkedList;
import java.util.List;

public class ListPalmares
{
	public static void main(String[] args)
	{
		List<String> palmares = new LinkedList<>();
		palmares.add("Ginette");
		palmares.add("Gertrude");
		palmares.add("Maurice");
		for (String nom : palmares)
			System.out.println(nom);
	}
}
