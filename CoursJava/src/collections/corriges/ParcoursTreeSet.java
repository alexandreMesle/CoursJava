package collections.corriges;

import java.util.TreeSet;
import java.util.Random;

public class ParcoursTreeSet
{
	public static void main(String[] args)
	{
		TreeSet<PaireOrdonneeComparable<Integer>> a = new TreeSet<>();
		Random r = new Random();
		for (int i = 1; i <= 40; i++)
			a.add(new PaireOrdonneeComparable<>(r.nextInt(), r.nextInt()));
		for (PaireOrdonnee<Integer> i : a)
			System.out.println(i);
	}
}
