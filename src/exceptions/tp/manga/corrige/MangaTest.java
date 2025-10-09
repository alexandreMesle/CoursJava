package exceptions.tp.manga.corrige;

// ==============================
// Fichier de tests : MangaTest.java
// (JUnit 5 – vérifie les messages EXACTS des exceptions)
// ==============================
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MangaTest {

    @Test
    void constructeur_refuse_prix_negatif_message_exact() {
        double prixInvalide = -2.5;
        try {
            new Manga("Naruto", prixInvalide, 200);
            fail("Une PrixException était attendue");
        } catch (PrixException e) {
            String attendu = "Le prix " + prixInvalide + " ne devrait pas être inférieur à " + Manga.MIN_PRIX + ".";
            assertEquals(attendu, e.getErrorMessage(), "Message exact attendu pour PrixException");
        } catch (PagesException e) {
            fail("PrixException attendue, pas PagesException");
        }
    }

    @Test
    void constructeur_refuse_pages_trop_petites_message_exact() {
        int invalide = Manga.MIN_PAGES - 1;
        try {
            new Manga("Naruto", 6.9, invalide);
            fail("Une PagesException était attendue (pages trop petites)");
        } catch (PagesException e) {
            String attendu = "Le nombre de pages " + invalide + " ne devrait pas être inférieur à " + Manga.MIN_PAGES + ".";
            assertEquals(attendu, e.getErrorMessage(), "Message exact attendu pour PagesException (inférieur)");
        } catch (PrixException e) {
            fail("PagesException attendue, pas PrixException");
        }
    }

    @Test
    void constructeur_refuse_pages_trop_eleves_message_exact() {
        int invalide = Manga.MAX_PAGES + 1;
        try {
            new Manga("Naruto", 6.9, invalide);
            fail("Une PagesException était attendue (pages trop élevées)");
        } catch (PagesException e) {
            String attendu = "Le nombre de pages " + invalide + " ne devrait pas être supérieur à " + Manga.MAX_PAGES + ".";
            assertEquals(attendu, e.getErrorMessage(), "Message exact attendu pour PagesException (supérieur)");
        } catch (PrixException e) {
            fail("PagesException attendue, pas PrixException");
        }
    }

    @Test
    void constructeur_ok_et_getters() throws Exception {
        Manga m = new Manga("Naruto", 6.9, 200);
        assertEquals("Naruto (volume 1)", m.getTitreVolume());
        assertEquals(6.9, m.getPrix(), 1e-9);
        assertEquals(200, m.getPages());
    }

    @Test
    void volume_suivant_herite_titre_et_prix_et_incremente_volume() throws Exception {
        Manga m1 = new Manga("Bleach", 7.2, 220);
        Manga m2 = m1.volumeSuivant(250);
        assertNotSame(m1, m2, "Le volume suivant doit être un nouvel objet");
        assertEquals("Bleach (volume 2)", m2.getTitreVolume()); // format exact
        assertEquals(m1.getPrix(), m2.getPrix(), 1e-9);         // même prix
        assertEquals(250, m2.getPages());                        // nouvelles pages
    }

    @Test
    void volume_suivant_declenche_pagesException_message_exact() throws Exception {
        Manga m1 = new Manga("One Piece", 6.9, 180);
        int invalide = Manga.MAX_PAGES + 10;
        try {
            m1.volumeSuivant(invalide);
            fail("Une PagesException était attendue pour volumeSuivant avec pages invalides");
        } catch (PagesException e) {
            String attendu = "Le nombre de pages " + invalide + " ne devrait pas être supérieur à " + Manga.MAX_PAGES + ".";
            assertEquals(attendu, e.getErrorMessage());
        }
    }
}
