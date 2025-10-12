package exceptions.tp.articles.corrige;

/**
 * Exception déclenchée en cas d'erreur relative à un article.
 */

class ArticleException extends Exception {
    public ArticleException(String message){ super(message); }
}

/**
 * Classe métier minimale pour une boutique d'articles.
 */

public class Article {

    // ------------------ ÉTAT ------------------
    private String nom;     // ex. "Épée magique"
    private double prix;    // ex. 49.99
    private int stock;      // ex. unités disponibles

    /**
     * [EXPERT 1] Compteur d'articles créés. 
     */
    private static int nombreArticles = 0;

    /**
     * Met en place un article
     */
    public Article(String nom, double prix, int stock) throws ArticleException
    {
        /* [EXPERT 2] Bloque les valeurs qui n'ont pas de sens économique 
        * - prix négatif
        * - stock négatif
        */
    	if (prix < 0) throw new ArticleException("prix negatif");
        if (stock < 0) throw new ArticleException("stock negatif");
    	
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;

        // Compte chaque création d'article.
        nombreArticles = nombreArticles + 1;
    }

    public String getNom()  { return nom;  }
    public double getPrix() { return prix; }
    public int getStock()   { return stock; }

    /**
     * [EXPERT 1] Retourne le nombre d'articles qui ont été créés.
     */
    public static int getTotalCrees() 
    {
        return nombreArticles; 
    }

    /**
     * [EXPERT 3] Met à jour le stock lors d'un ajout d'article au panier :
     * - L'opération attend une quantité "raisonnable" (strictement positive).
     * - Elle ne doit pas permettre d'aller "au-delà du stock disponible".
     */
    public void ajouterAuPanier(int quantite) throws ArticleException {
    	if (quantite <= 0) throw new ArticleException("quantite <= 0");
        if (quantite > stock) throw new ArticleException("stock insuffisant");
        // Effet attendu : le stock diminue de la quantité demandée
        stock = stock - quantite;
    }
}
