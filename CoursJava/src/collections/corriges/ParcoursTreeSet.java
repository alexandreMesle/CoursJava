package collections.corriges;

import java.util.TreeSet;
import java.util.Random;

public class ParcoursTreeSet
{
    public static void main(String[] args)
    {
	TreeSet<DeuxObjets<Integer>> a = new TreeSet<DeuxObjets<Integer>>();
	Random r = new Random();
	for (int i = 1 ; i <= 40 ; i++)
	    a.add(new DeuxObjets<Integer>(r.nextInt(), r.nextInt()));
	for(DeuxObjets<Integer> i : a)
	    System.out.println(i);
    }
}
