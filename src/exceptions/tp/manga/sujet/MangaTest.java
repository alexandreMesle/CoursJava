package exceptions.tp.manga.sujet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MangaTest {

    // --------- A) TESTS STRUCTURELS (communs à tous) ---------

    @Test
    void testStructureChampsInstancePrives() throws Exception {
        Class<?> c = Manga.class;
        Field fTitre  = c.getDeclaredField("titre");
        Field fPrix   = c.getDeclaredField("prix");
        Field fPages  = c.getDeclaredField("pages");
        Field fVolume = c.getDeclaredField("volume");

        assertTrue(Modifier.isPrivate(fTitre.getModifiers()),  "Le champ 'titre' doit être private");
        assertTrue(Modifier.isPrivate(fPrix.getModifiers()),   "Le champ 'prix' doit être private");
        assertTrue(Modifier.isPrivate(fPages.getModifiers()),  "Le champ 'pages' doit être private");
        assertTrue(Modifier.isPrivate(fVolume.getModifiers()), "Le champ 'volume' doit être private");
    }

    @Test
    void testStructureConstantesStatiques() throws Exception {
        Class<?> c = Manga.class;
        Field minPages = c.getDeclaredField("MIN_PAGES");
        Field maxPages = c.getDeclaredField("MAX_PAGES");
        Field minPrix  = c.getDeclaredField("MIN_PRIX");

        assertTrue(Modifier.isStatic(minPages.getModifiers()), "MIN_PAGES doit être static");
        assertTrue(Modifier.isStatic(maxPages.getModifiers()), "MAX_PAGES doit être static");
        assertTrue(Modifier.isStatic(minPrix.getModifiers()),  "MIN_PRIX doit être static");

        assertEquals(int.class,    minPages.getType(), "MIN_PAGES doit être un int");
        assertEquals(int.class,    maxPages.getType(), "MAX_PAGES doit être un int");
        assertEquals(double.class, minPrix.getType(),  "MIN_PRIX doit être un double");
    }

    @Test
    void testStructureConstructeursEtMethodes() throws Exception {
        Constructor<Manga> pub = Manga.class.getConstructor(String.class, double.class, int.class);
        Constructor<Manga> priv = Manga.class.getDeclaredConstructor(String.class, double.class, int.class, int.class);
        Method volumeSuivant = Manga.class.getDeclaredMethod("volumeSuivant", int.class);

        assertTrue(Modifier.isPublic(pub.getModifiers()),  "Le constructeur public à 3 paramètres doit être public");
        assertTrue(Modifier.isPrivate(priv.getModifiers()), "Le constructeur à 4 paramètres doit être private");
        assertTrue(Modifier.isPublic(volumeSuivant.getModifiers()), "volumeSuivant(int) doit être public");
        assertEquals(Manga.class, volumeSuivant.getReturnType(), "volumeSuivant doit renvoyer un Manga");
    }

    @Test
    void testStructureGetters() throws Exception {
        Method gt  = Manga.class.getDeclaredMethod("getTitreVolume");
        Method gp  = Manga.class.getDeclaredMethod("getPrix");
        Method gps = Manga.class.getDeclaredMethod("getPages");

        assertEquals(String.class, gt.getReturnType(),  "getTitreVolume() doit renvoyer String");
        assertEquals(double.class, gp.getReturnType(),  "getPrix() doit renvoyer double");
        assertEquals(int.class,    gps.getReturnType(), "getPages() doit renvoyer int");
    }

    // --------- B) TESTS COMPORTEMENTAUX ---------

    // [2] PrixException
    @Test
    void expert2ConstructeurRefusePrixNegatifMessageExact() throws Exception {
        Manga probe = new Manga("probe", 0.0, 5);
        double prixInvalide = -2.5;

        PrixException ex = assertThrows(
            PrixException.class,
            () -> new Manga("Naruto", prixInvalide, probe.MIN_PAGES),
            "Une PrixException est attendue pour un prix négatif"
        );
        String attendu = "Le prix " + prixInvalide + " ne devrait pas être inférieur à " + probe.MIN_PRIX + ".";
        assertEquals(attendu, ex.getErrorMessage(), "Message exact attendu pour PrixException");
    }

    // [3] PagesException
    @Test
    void expert3ConstructeurRefusePagesTropPetitesMessageExact() throws Exception {
        Manga probe = new Manga("probe", 0.0, 5);
        int invalide = probe.MIN_PAGES - 1;

        PagesException ex = assertThrows(
            PagesException.class,
            () -> new Manga("Naruto", 6.9, invalide),
            "Une PagesException est attendue pour un nombre de pages trop petit"
        );
        String attendu = "Le nombre de pages " + invalide
                + " ne devrait pas être inférieur à " + probe.MIN_PAGES + ".";
        assertEquals(attendu, ex.getErrorMessage(), "Message exact attendu (inférieur)");
    }

    // [3] PagesException
    @Test
    void expert3ConstructeurRefusePagesTropEleveesMessageExact() throws Exception {
        Manga probe = new Manga("probe", 0.0, 5);
        int invalide = probe.MAX_PAGES + 1;

        PagesException ex = assertThrows(
            PagesException.class,
            () -> new Manga("Naruto", 6.9, invalide),
            "Une PagesException est attendue pour un nombre de pages trop élevé"
        );
        String attendu = "Le nombre de pages " + invalide
                + " ne devrait pas être supérieur à " + probe.MAX_PAGES + ".";
        assertEquals(attendu, ex.getErrorMessage(), "Message exact attendu (supérieur)");
    }

    // [1] Constructeurs / Getters
    @Test
    void expert1ConstructeurOkEtGetters() throws Exception {
        Manga m = new Manga("Naruto", 6.9, 200);
        assertEquals("Naruto (volume 1)", m.getTitreVolume());
        assertEquals(6.9, m.getPrix(), 1e-9);
        assertEquals(200, m.getPages());
    }

    // [1] Instanciation dérivée
    @Test
    void expert1VolumeSuivantHeriteTitreEtPrixEtIncrementeVolume() throws Exception {
        Manga probe = new Manga("probe", 0.0, 5);
        Manga m1 = new Manga("Bleach", 7.2, probe.MIN_PAGES);
        Manga m2 = m1.volumeSuivant(probe.MIN_PAGES + 10);

        assertNotSame(m1, m2, "Le volume suivant doit être un nouvel objet");
        assertEquals("Bleach (volume 2)", m2.getTitreVolume());
        assertEquals(m1.getPrix(), m2.getPrix(), 1e-9);
        assertEquals(probe.MIN_PAGES + 10, m2.getPages());
    }

    // [3] PagesException sur volume suivant
    @Test
    void expert3VolumeSuivantDeclenchePagesExceptionMessageExact() throws Exception {
        Manga probe = new Manga("probe", 0.0, 5);
        Manga m1 = new Manga("One Piece", 6.9, probe.MIN_PAGES);
        int invalide = probe.MAX_PAGES + 10;

        PagesException ex = assertThrows(
            PagesException.class,
            () -> m1.volumeSuivant(invalide),
            "Une PagesException est attendue pour volumeSuivant avec pages invalides"
        );
        String attendu = "Le nombre de pages " + invalide
                + " ne devrait pas être supérieur à " + probe.MAX_PAGES + ".";
        assertEquals(attendu, ex.getErrorMessage());
    }
}
