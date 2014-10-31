package encapsulation.corriges;

public class ListeInt
{
    /*
      Donnee stockee dans le maillon
     */

    private int data;

    /*********************************/
    
    /*
      Pointeur vers le maillon suivant
     */
    
    private ListeInt next;

    /*********************************/
    
    /*
      Constructeur initialisant la donnee et 
      le pointeur vers l'element suivant.
     */
        
    ListeInt(int data, ListeInt next)
    {
	this.data = data;
	this.next = next;
    }

    /*********************************/
    
    /*
      Constructeur initialisant la donnee et 
      mettant le suivant a null.
     */
        
    ListeInt(int data)
    {
	this(data, null);
    }

    /*********************************/
    
    /*
      Constructeur initialisant la donnee et 
      mettant le suivant a null.
     */
        
    ListeInt(ListeInt other)
    {
	this(other.getData(), new ListeInt(other.getNext()));
    }

    /*********************************/
    
    /*
      Retourne la donnee.
     */
        
    public int getData()
    {
	return data;
    }
    /*********************************/
    
    /*
      Modifie la donnee
     */
        
    public void setData(int data)
    {
	 this.data = data;
    }
    /*********************************/
    
    /*
      Retourne le maillon suivant.
     */
        
    public ListeInt getNext()
    {
	return next;
    }

    /*********************************/
    
    /*
      Modifie le maillon suivant
     */
        
    public void setNext(ListeInt next)
    {
	this.next = next;
    }

    /*********************************/
    
    /*
      Retourne une représentation sous forme de 
      chaine de la liste.      
     */
        
    public String toString()
    {
	String res = "" + data;
	if (next != null)
	    res += " -> " + next.toString();
	return res;
    }

    /*********************************/
    
    /*
      Teste le fonctionnement de la liste.
     */
        
    public static void main(String[] args)
    {
	ListeInt l = new ListeInt(20);
	int i = 19;
	while (i >= 0)
	    l = new ListeInt(i--, l);
	System.out.println(l);
    }
    
}
