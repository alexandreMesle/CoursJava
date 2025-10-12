package exceptions.tp.articles.corrige;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.lang.reflect.*;

/**
 * Batterie de tests pour la classe Article.
 * Ces tests visent à vérifier la cohérence fonctionnelle et conceptuelle,
 * sans fournir directement les mots-clés de solution.
 */
public class ArticleTest {

    // --------- Utilitaires réflexion ---------
    private Field getNombreArticlesField() throws Exception {
        Field f = Article.class.getDeclaredField("nombreArticles");
        f.setAccessible(true);
        return f;
    }

    private Method getGetTotalCreesMethod() throws Exception {
        Method m = Article.class.getDeclaredMethod("getTotalCrees");
        m.setAccessible(true);
        return m;
    }

    @BeforeEach
    void Expert1ResetCompteurSiPossible() {
        try {
            Field f = getNombreArticlesField();
            if (Modifier.isStatic(f.getModifiers()) && f.getType() == int.class) {
                f.setInt(null, 0);
            }
        } catch (Throwable ignore) {
            // champ manquant ou non conforme → on laisse tel quel
        }
    }

    // --------- Smoke test : compilation & comportement minimal ---------
    @Test
    void creationArticleMinimal() throws ArticleException {
        Article a = new Article("X", 10.0, 2);
        a.ajouterAuPanier(1);
        assertEquals(1, a.getStock(), "Le stock doit diminuer de la quantité demandée");
    }

    // --------- Vérifications conceptuelles par réflexion ---------
    @Test
    void Expert1NombreArticles() throws Exception {
        Field f = getNombreArticlesField();

        assertEquals(int.class, f.getType(), 
            "Le compteur d’articles doit être un entier représentant le nombre total créé.");
        assertTrue(Modifier.isStatic(f.getModifiers()), 
            "Le nombre d’articles créés doit être commun à tous les objets, " +
            "et non propre à chaque article.");
    }

    @Test
    void Expert1GetterNombreArticles() throws Exception {
        Method m = getGetTotalCreesMethod();
        assertEquals(int.class, m.getReturnType(),
            "La méthode de comptage doit renvoyer un nombre entier.");
        assertTrue(Modifier.isStatic(m.getModifiers()),
            "La méthode de comptage doit donner la même information pour tous les articles, " +
            "quelle que soit l’instance utilisée.");
    }

    @Test
    void Expert1NombreArticlesIndependantArticle() throws Exception {
        Article a = new Article("A", 1.0, 1);
        int start = a.getTotalCrees(); // Appel via objet, toléré par Java

        Article b = new Article("B", 2.0, 1);
        Article c = new Article("C", 3.0, 1);

        int ca = a.getTotalCrees();
        int cb = b.getTotalCrees();
        int cc = c.getTotalCrees();

        assertEquals(ca, cb,
            "Tous les articles devraient indiquer le même total d’articles créés.");
        assertEquals(cb, cc,
            "Le compteur de créations doit donner la même valeur pour toutes les instances.");
        assertEquals(start + 2, ca,
            "Le compteur de créations doit augmenter à chaque nouvel article instancié.");
    }

    // --------- Vérifications métier ---------
    @Test
    void Expert2RefusePrixNegatif() {
        assertThrows(ArticleException.class, () -> new Article("P", -1.0, 0),
            "Un article ne peut pas être créé avec un prix négatif.");
    }

    @Test
    void Expert2RefuseStockNegatif() {
        assertThrows(ArticleException.class, () -> new Article("P", 1.0, -1),
            "Un article ne peut pas être créé avec un stock négatif.");
    }

    @Test
    void Expert3StockMisAJour() throws Exception {
        Article a = new Article("A", 10.0, 5);
        a.ajouterAuPanier(2);
        assertEquals(3, a.getStock(),
            "Ajouter 2 au panier devrait diminuer le stock de 2 unités.");
    }

    @Test
    void Expert3PanierQuantiteNegative() throws Exception {
        Article a = new Article("A", 10.0, 5);
        assertThrows(ArticleException.class, () -> a.ajouterAuPanier(0),
            "Impossible d’ajouter une quantité nulle au panier.");
        assertThrows(ArticleException.class, () -> a.ajouterAuPanier(-3),
            "Impossible d’ajouter une quantité négative au panier.");
    }

    @Test
    void Expert3PanierDepassementStock() throws Exception {
        Article a = new Article("A", 10.0, 1);
        assertThrows(ArticleException.class, () -> a.ajouterAuPanier(2),
            "Impossible d’ajouter au panier plus d’articles qu’il n’en reste en stock.");
    }
}
