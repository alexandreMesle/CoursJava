package exceptions;

public class ObjectStack
{
    /*
        Liste contenant les elements de la pile.
    */

    private ObjectList l;

    /********************************************/    

    /*
        Taille de la pile
    */
    
    private final int taille;

    /********************************************/    

    /*
        Nombre d'elements dans la liste
    */
    
    private int nbItems;
    
    /********************************************/    

    /*
        Constructeur
    */
    
    ObjectStack(int taille)
    {
	l = null;
	this.taille = taille;
	nbItems = 0;
    }

    /********************************************/    

    /*
        Retourne vrai si et seulement 
        si la pile est vide
    */
    
    public boolean estVide()
    {
	return nbItems == 0;
    }

    /********************************************/    

    /*
        Retourne vrai si et seulement si la pile est 
        pleine.
    */
    
    public boolean estPleine()
    {
	return nbItems == taille;
    }

    /********************************************/    

    /*
        Retourne l'element se trouvant au sommet de 
        la pile, -1 si la pile est vide.
    */
    
    public Object sommet()
    {
	if (!estVide())
	    return l.getData();
	return -1;
    }
    
    /********************************************/    

    /*
        Supprime l'element se trouvant au sommet 
        de la pile, ne fait rien si la pile est 
        vide.
    */
    
    public void depile() throws PileVideException
    {
	if (!estVide())
	    {
		l = l.getNext();
		nbItems--;
	    }
	else
	    {
		throw new PileVideException();
	    }
    }

    /********************************************/    

    /*
        Ajoute data en haut de la pile, ne fait rien 
        si la pile est pleine.
    */
    
    public void empile(int data)
    {
	l = new ObjectList(data, l);
	nbItems ++;
    }
    
    /********************************************/    

    /*
        Retourne une representation de la pile 
        au format chaine de caracteres.
    */
    
    public String toString()
    {
	return l.toString();
    }

    /********************************************/    

    /*
        Teste le fonctionnement de la pile.
    */
    
    public static void main(String[] args)
    {
	ObjectStack p = new ObjectStack (30);
	int i = 0;
	while(!p.estPleine())
	    p.empile(new Integer(i++));
	System.out.println(p);
	while(!p.estVide())
	    {
		System.out.println(p.sommet());
		try
		    {
		    p.depile();
		    }
		catch(PileVideException e)
		    {
			System.out.println(e);
		    }
	    }
    }
}
