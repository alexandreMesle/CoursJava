package exceptions.tp.manga.sujet;

/*
- [Expert 1] : méthode copyNextVolume() et constructeur privé (instanciation dérivée)
- [Expert 2] : validation du prix et exception dédiée PriceException
- [Expert 3] : validation du nombre de pages et exception dédiée PagesException

*/

public class Manga 
{

 String titre;
 double prix;
 int pages;
 int volume;

 public int MIN_PAGES = 5;   // [Expert 3]
 public int MAX_PAGES = 500;   // [Expert 3]
 public double MIN_PRIX = 0.0; // [Expert 2]

 /*
  * [Expert 1]  Le constructeur PUBLIC ne demande PAS le volume : 
  * un volume créé démarre toujours à volume = 1.		 
  */
 public Manga(String titre, double prix, int pages)
 {
	 // On vous rappelle que this() permet d'appeler un constructeur depuis un autre constructeur.
     this(null, 0, 0, 0);
 }

 
 /* 
  * [Expert 1] Le constructeur PRIVÉ prend "volume" pour factoriser l'initialisation et être réutilisé 
  * par copyNextVolume().	
  */
 private Manga(String titre, double prix, int pages, int volume)
 {

     // [Expert 2] Si le prix est inférieur à MIN_PRIX, on déclenche PriceException
 
     // [Expert 3] Si le nombre de pages est trop petit ou trop élevé, on déclenche PagesException 
 
     this.titre = titre;
     this.prix = prix;
     this.pages = pages;
     this.volume = volume;
 }

 /*
  * [Expert 1] Crée le volume suivant :
  * - le volume suivant a un numéro de volume calculé à partir du volume actuel
  * - le prix et le titres sont identiques à ceux du volume actuel
  * - son nombre de page est passé en paramètre. 
  */

 public Manga volumeSuivant(int newPages) 
 {
//     try
//     {
    	 return new Manga(null, 0, 0, 0);
//     }     
//     catch(PrixException e)
//     {
//    	 throw new RuntimeException("Le prix du volume " + volume + " de " + titre + 
//    			 " n'aurait pas dû déclencher d'exception lors de la création du volume suivant.");
//     }
 }
 
 /*
  * [Expert 1] Crée le volume suivant :
  * - le volume suivant a un numéro de volume calculé à partir du volume actuel
  * - le prix et le titres sont identiques à ceux du volume actuel
  * - son nombre de page est passé en paramètre. 
  */
 public String getTitreVolume() 
 {
     return null;
 }

 public double getPrix()  { return this.prix;  }
 public int getPages()    { return this.pages; } 
}


//[Expert 2] PriceException
class PrixException extends Exception 
{
 private double prixInvalide;

 public PrixException(double prixInvalide) 
 {
 }

 public String getErrorMessage() 
 {
	 return null;
 }
}


//[Expert 3] PagesException
class PagesException extends Exception 
{
 private int pagesInvalide;

 public PagesException(int pagesInvalide) 
 {
 }

 public String getErrorMessage() 
 {
	 return null;
 }
}
