package collections.corriges;

public class DeuxObjets<T extends Comparable<T>> 
    implements Comparable<DeuxObjets<T>> 
{
    private T first;
    private T second;
    
    public DeuxObjets(T first, T second)
	{
	    this.first = first;
	    this.second = second;
	}
    
    public T getPetit()
    {
	if (first.compareTo(second) < 0)
	    return first;
	else
	    return second;
    }
    
    public T getGrand()
    {
	if (first.compareTo(second) >= 0)
	    return first;
	else
	    return second;
    }
    
    public int compareTo(DeuxObjets<T> other)
    {
	return  getGrand().compareTo(other.getGrand());
    }

    public String toString()
    {
	return "(" + first + ", " + second + ")";
    }
    
    public static void main(String args[])
    {
	DeuxObjets<Integer> a = new DeuxObjets<Integer>(2, 7);
	System.out.println(a.getGrand());
    }
}
