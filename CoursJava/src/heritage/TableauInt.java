package heritage;

import java.util.Random;

public class TableauInt
{
    private int[] t;
    
    /*-----------------------------------------------*/

    public TableauInt(int taille)
    {
	t = new int[taille];
    }
     
    /*-----------------------------------------------*/

    public TableauInt(TableauInt other)
    {
	t = new int[other.t.length];
	for (int i = 0 ; i < t.length ; i++)
	    t[i] = other.t[i];
    }
    
    /*-----------------------------------------------*/

    public TableauInt copie()
    {
	return new TableauInt(this);
    }
    
    /*-----------------------------------------------*/

    public String toString()
    {
	String res = "[";
	if (t.length >= 1)
	    res += t[0];
	for (int i = 1 ; i < t.length ; i++)
	    res += ", " + t[i];
	res += "]";
	return res;
    }
    
    /*-----------------------------------------------*/

    public int get(int index)
    {
	return t[index];
    }
    
    /*-----------------------------------------------*/

    public void set(int index, int value)
    {
	t[index] = value;
    }
    
    /*-----------------------------------------------*/

    public void echange(int i, int j)
    {
	int temp = t[i];
	t[i] = t[j];
	t[j] = temp;
    }
    
    /*-----------------------------------------------*/

    public void triSelection()
    {
	for (int i = 0 ; i < t.length - 1 ; i++)
	    {
		int indiceMin = i;
		for (int j = i + 1 ; j < t.length; j++)
		    if (t[indiceMin] > t[j])
			indiceMin = j;
		echange(i, indiceMin);
	    }
    }

    /*-----------------------------------------------*/
    
    public static void main(String[] args)
    {
	int n = 10;
	Random r = new Random();
	TableauInt tab = new TableauInt(n);
	for (int i = 0 ; i < n  ;i++)
	    tab.set(i, r.nextInt()%100);
	System.out.println(tab);
	tab.triSelection();
	System.out.println(tab);
    }
    
}
