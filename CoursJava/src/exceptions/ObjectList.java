package exceptions;

public class ObjectList
{
    /*
      Donnee stockee dans le maillon
     */

    private Object data;

    /*********************************/
    
    /*
      Pointeur vers le maillon suivant
     */
    
    private ObjectList next;

    /*********************************/
    
    /*
      Constructeur initialisant la donnee et 
      le pointeur vers l'element suivant.
     */
        
    ObjectList(Object data, ObjectList next)
    {
	this.data = data;
	this.next = next;
    }

    /*********************************/
    
    /*
      Constructeur initialisant la donnee et 
      mettant le suivant a null.
     */
        
    ObjectList(Object data)
    {
	this(data, null);
    }

    /*********************************/
    
    /*
      Retourne la donnee.
     */
        
    public Object getData()
    {
	return data;
    }
    /*********************************/
    
    /*
      Modifie la donnee
     */
        
    public void setData(Object data)
    {
	 this.data = data;
    }
    /*********************************/
    
    /*
      Retourne le maillon suivant.
     */
        
    public ObjectList getNext()
    {
	return next;
    }

    /*********************************/
    
    /*
      Modifie le maillon suivant
     */
        
    public void setNext(ObjectList next)
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
	ObjectList l = new ObjectList(20);
	int i = 3;
	while (i >= 0)
	    l = new ObjectList(new Integer(i), l);
	System.out.println(l);
    }
    
}
