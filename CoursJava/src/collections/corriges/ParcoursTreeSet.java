package collections.corriges;

import java.util.TreeSet;
import java.util.Random;

public class ParcoursTreeSet
{
    public static void main(String[] args)
    {
	TreeSet<PaireOrdonnee<Integer>> a = new TreeSet<PaireOrdonnee<Integer>>();
	Random r = new Random();
	for (int i = 1 ; i <= 40 ; i++)
	    a.add(new PaireOrdonnee<Integer>(r.nextInt(), r.nextInt()));
	for(PaireOrdonnee<Integer> i : a)
	    System.out.println(i);
    }
}
