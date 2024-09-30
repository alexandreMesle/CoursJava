package exceptions;

import java.util.Scanner;

class XEstFauxException extends Exception
{
    private boolean x;
    
    XEstFauxException(boolean x)
    {
        this.x = x;
    }
    
    public String getMessage()
    {
        return "T'as saisi " + x + " !!!!!!";
    }
}

public class XEstVrai
{
    public static void xEstVrai(boolean x) 
        throws XEstFauxException // propagation 
    {
        if (x)
            System.out.println("OK");
        else // détection d'un problème
        {
            
            XEstFauxException erreur = new XEstFauxException(x);
            // Déclenchement (levée) d'une exception 
            throw erreur;
        };        
    }
    
    public static void appelleXEstVrai(boolean k) 
        throws XEstFauxException // propagation
    {
        xEstVrai(k);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.print("Saisis true : ");
            boolean i = scanner.nextBoolean();
            try
            {
                appelleXEstVrai(i);// interruption
            }
            catch(XEstFauxException erreur) // Rattrapage
            {// traitement du problème
                System.out.println(erreur.getMessage());
            }
        }
    }
}