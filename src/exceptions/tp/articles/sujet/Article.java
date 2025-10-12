package exceptions.tp.articles.sujet;

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
    int nombreArticles;

    /**
     * Met en place un article
     */
    public Article(String nom, double prix, int stock)
    {
        /* [EXPERT 2] Bloque les valeurs qui n'ont pas de sens économique 
        * - prix négatif
        * - stock négatif
        */
    	
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;

        // [EXPERT 1] Met à jour le nombre d'articles créés.
        this.nombreArticles = 0;
    }

    public String getNom()  { return nom;  }
    public double getPrix() { return prix; }
    public int getStock()   { return stock; }

    /**
     * [EXPERT 1] Retourne le nombre d'articles qui ont été créés.
     */
    public int getTotalCrees() 
    {
        return 0; 
    }

    /**
     * [EXPERT 3] Met à jour le stock lors d'un ajout d'article au panier :
     * - L'opération attend une quantité "raisonnable" (strictement positive).
     * - Elle ne doit pas permettre d'aller "au-delà du stock disponible".
     */
    public void ajouterAuPanier(int quantite) {
        // Effet attendu : le stock diminue de la quantité demandée
    }
}
