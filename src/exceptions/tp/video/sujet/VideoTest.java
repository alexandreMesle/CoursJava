package exceptions.tp.video.sujet;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class VideoTest {

    // ------------------------------------------------------------
    // [Structure] Vérifie la visibilité et le statut des membres
    // ------------------------------------------------------------

    @Test
    void expert1Structure_visibiliteChampsInstance() throws Exception {
        Class<?> c = Video.class;
        Field fTitre = c.getDeclaredField("titre");
        Field fDuree = c.getDeclaredField("duree");
        Field fVues  = c.getDeclaredField("vues");
        Field fHd    = c.getDeclaredField("hd");

        assertTrue(Modifier.isPrivate(fTitre.getModifiers()),
                "La variable 'titre' devrait être interne à la classe et non accessible directement de l'extérieur.");
        assertTrue(Modifier.isPrivate(fDuree.getModifiers()),
                "La variable 'duree' devrait être interne à la classe et non accessible directement de l'extérieur.");
        assertTrue(Modifier.isPrivate(fVues.getModifiers()),
                "La variable 'vues' devrait être interne à la classe et non accessible directement de l'extérieur.");
        assertTrue(Modifier.isPrivate(fHd.getModifiers()),
                "La variable 'hd' devrait être interne à la classe et non accessible directement de l'extérieur.");
    }

    @Test
    void expert2Structure_parametresCatalogue_conformiteStatut() throws Exception {
        Class<?> c = Video.class;
        Field prix = c.getDeclaredField("PRIX_CATALOGUE");
        Field min  = c.getDeclaredField("DUREE_MIN");
        Field max  = c.getDeclaredField("DUREE_MAX");

        // Doivent être des "règles communes" consultables partout
        assertTrue(Modifier.isStatic(prix.getModifiers()),
                "La règle tarifaire devrait être commune à toutes les vidéos, or elle dépend ici de l'instance.");
        assertTrue(Modifier.isStatic(min.getModifiers()),
                "La borne inférieure de durée devrait être commune à toutes les vidéos.");
        assertTrue(Modifier.isStatic(max.getModifiers()),
                "La borne supérieure de durée devrait être commune à toutes les vidéos.");

        // Devraient être stables (non modifiables à l’exécution)
        assertTrue(Modifier.isFinal(prix.getModifiers()),
                "La règle tarifaire ne devrait pas pouvoir changer au cours de l'exécution.");
        assertTrue(Modifier.isFinal(min.getModifiers()),
                "La borne inférieure ne devrait pas pouvoir être altérée après compilation.");
        assertTrue(Modifier.isFinal(max.getModifiers()),
                "La borne supérieure ne devrait pas pouvoir être altérée après compilation.");
    }

    @Test
    void expert1Structure_compteurGlobal_catalogueConforme() throws Exception {
        Field total = Video.class.getDeclaredField("totalVues");
        assertTrue(Modifier.isPrivate(total.getModifiers()),
                "Le compteur global ne devrait pas être accessible directement depuis l’extérieur.");
        assertTrue(Modifier.isStatic(total.getModifiers()),
                "Le compteur global devrait agréger les vues de toutes les vidéos (valeur partagée).");
    }

    @Test
    void expert1Structure_constructeurMasque_existeEtFonctionne() throws Exception {
        Constructor<Video> priv = Video.class.getDeclaredConstructor(String.class, int.class, boolean.class);
        assertTrue(Modifier.isPrivate(priv.getModifiers()),
                "Le constructeur interne devrait être réservé à un usage contrôlé (masqué à l’extérieur).");

        // Accès via une instance pour éviter tout appel statique direct
        Video ref = new Video("Ref", 5);
        int dureeMin = (int) ref.getClass().getField("DUREE_MIN").get(ref);

        priv.setAccessible(true);
        Object o = priv.newInstance("Demo", dureeMin, true);

        assertNotNull(o, "L'appel réfléchi du constructeur interne n'a pas produit d'objet valide.");

        Method getTitreBrut = Video.class.getDeclaredMethod("getTitreBrut");
        Method getDuree     = Video.class.getDeclaredMethod("getDuree");
        Method getVues      = Video.class.getDeclaredMethod("getVues");
        Method getTitreComp = Video.class.getDeclaredMethod("getTitreComplet");

        assertEquals("Demo", getTitreBrut.invoke(o));
        assertEquals(dureeMin, (int) getDuree.invoke(o));
        assertEquals(0, (int) getVues.invoke(o));
        assertEquals("Demo (HD)", (String) getTitreComp.invoke(o),
                "Le titre complet ne correspond pas à l’état HD attendu après création via le constructeur interne.");
    }

    // ------------------------------------------------------------
    // [Comportement] Exceptions et bornes strictes
    // ------------------------------------------------------------

    @Test
    void expert3Duree_messageExacte_tropCourte_et_bornesStrictesBas() throws Exception {
        Video ref = new Video("Ref", 5);
        int dureeMin = (int) ref.getClass().getField("DUREE_MIN").get(ref);

        int invalide = dureeMin - 1;
        DureeException ex = assertThrows(
            DureeException.class,
            () -> new Video("Court", invalide),
            "Une durée inférieure à la limite devrait déclencher une erreur, or elle semble acceptée."
        );

        String attendu = "La durée " + invalide + " min est trop courte. Minimum autorisé : " + dureeMin + " min.";
        assertEquals(attendu, ex.getErrorMessage(),
                "Le message ne décrit pas fidèlement la valeur rejetée et la borne appliquée.");

        // Borne exacte doit être autorisée
        assertDoesNotThrow(() -> new Video("OK", dureeMin),
                "La valeur égale à la borne basse devrait être autorisée.");
    }

    @Test
    void expert3Duree_messageExacte_tropLongue_et_bornesStrictesHaut() throws Exception {
        Video ref = new Video("Ref", 5);
        int dureeMax = (int) ref.getClass().getField("DUREE_MAX").get(ref);

        int invalide = dureeMax + 1;
        DureeException ex = assertThrows(
            DureeException.class,
            () -> new Video("Longue", invalide),
            "Une durée supérieure à la limite devrait déclencher une erreur, or elle semble acceptée."
        );

        String attendu = "La durée " + invalide + " min est trop longue. Maximum autorisé : " + dureeMax + " min.";
        assertEquals(attendu, ex.getErrorMessage(),
                "Le message ne décrit pas fidèlement la valeur rejetée et la borne appliquée.");

        assertDoesNotThrow(() -> new Video("MaxOK", dureeMax),
                "La valeur égale à la borne haute devrait être autorisée.");
    }

    @Test
    void expert2HD_messageExact_siDejaHd() throws Exception {
        Video v = new Video("Film", 120);
        Video hd = v.versionHD();

        HDException ex = assertThrows(
            HDException.class,
            hd::versionHD,
            "Une demande de transformation déjà effectuée aurait dû être signalée comme redondante."
        );

        String attendu = "La vidéo Film est déjà en HD.";
        assertEquals(attendu, ex.getErrorMessage(),
                "Le message d'erreur ne décrit pas clairement le caractère redondant de l’opération.");
    }

    // ------------------------------------------------------------
    // [Instanciation dérivée] versionHD()
    // ------------------------------------------------------------

    @Test
    void expert2HD_pasDePropagation_nouvelObjet_et_titreExact() throws Exception {
        Video v = new Video("Docu", 90);
        Video hd = assertDoesNotThrow(v::versionHD,
                "Créer une version dérivée devrait réutiliser une durée déjà validée.");

        assertNotSame(v, hd, "La méthode devrait produire un nouvel objet distinct.");
        assertEquals("Docu", v.getTitreComplet(),
                "Le titre de la version standard ne devrait pas inclure l'indication de version.");
        assertEquals("Docu (HD)", hd.getTitreComplet(),
                "Le titre de la variante devrait indiquer explicitement la version HD.");
        assertEquals(0, hd.getVues(),
                "La variante devrait commencer avec un compteur de vues vierge.");
    }

    // ------------------------------------------------------------
    // [Visionnage] Instance + Global via appels d’objets
    // ------------------------------------------------------------

    @Test
    void expert1Vues_instanceEtGlobal_appelCatalogueViaInstance() throws Exception {
        Video a = new Video("A", 60);
        Video b = new Video("B", 61);

        int totalAvant = (int) a.getClass().getDeclaredMethod("getTotalVues").invoke(a);

        a.visionner(); // +1
        a.visionner(); // +2
        b.visionner(); // +1

        assertEquals(2, a.getVues(),
                "Le compteur de vues local ne s’incrémente pas correctement pour la première vidéo.");
        assertEquals(1, b.getVues(),
                "Le compteur de vues local ne s’incrémente pas correctement pour la seconde vidéo.");

        int totalApres = (int) b.getClass().getDeclaredMethod("getTotalVues").invoke(b);
        assertEquals(totalAvant + 3, totalApres,
                "Le cumul global des vues ne correspond pas au total observé après les visionnages.");
    }

    // ------------------------------------------------------------
    // [Prix catalogue] Appel via instance
    // ------------------------------------------------------------

    @Test
    void expert2PrixCatalogue_recuperationViaInstance() throws Exception {
        Video v = new Video("Tarif", 100);
        double prixViaInstance = (double) v.getClass().getDeclaredMethod("getPrixCatalogue").invoke(v);

        Field fPrix = v.getClass().getDeclaredField("PRIX_CATALOGUE");
        double prixReference = fPrix.getDouble(v);

        assertEquals(prixReference, prixViaInstance, 1e-9,
                "Le tarif obtenu par l’appel d’instance ne correspond pas à la règle tarifaire du catalogue.");
    }

    // ------------------------------------------------------------
    // [Constructeurs] Public et indirect via versionHD()
    // ------------------------------------------------------------

    @Test
    void expert1Constructeurs_usageHabituel_publicEtIndirectPrive() throws Exception {
        Video base = new Video("Base", 75);
        assertEquals("Base", base.getTitreComplet(),
                "L’objet créé via le constructeur public ne correspond pas à l’état attendu.");

        Video variante = base.versionHD();
        assertEquals("Base (HD)", variante.getTitreComplet(),
                "La variante créée via la méthode dérivée ne correspond pas à l’intitulé attendu.");
    }
}
