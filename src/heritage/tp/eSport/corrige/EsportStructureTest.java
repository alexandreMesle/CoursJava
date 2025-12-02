package heritage.tp.eSport.corrige;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class EsportStructureTest {

    /* =========================================================
       STRUCTURE DE CLASSE / HÉRITAGE / ABSTRACTION
       ========================================================= */

    @Test
    public void testJoueurEstAbstrait() {
        assertTrue(Modifier.isAbstract(Joueur.class.getModifiers()),
                "La classe Joueur doit être abstraite.");
    }

    @Test
    public void testGuerrierHeriteDeJoueur() {
        assertEquals(Joueur.class, Guerrier.class.getSuperclass(),
                "Guerrier doit hériter de Joueur.");
    }

    @Test
    public void testMageHeriteDeJoueur() {
        assertEquals(Joueur.class, Mage.class.getSuperclass(),
                "Mage doit hériter de Joueur.");
    }

    @Test
    public void testConstructeurGuerrierCompletExiste() {
        assertDoesNotThrow(
                () -> Guerrier.class.getDeclaredConstructor(String.class, int.class, int.class, int.class),
                "Guerrier doit avoir un constructeur (String, int, int, int)."
        );
    }

    @Test
    public void testConstructeurMageCompletExiste() {
        assertDoesNotThrow(
                () -> Mage.class.getDeclaredConstructor(String.class, int.class, int.class, int.class),
                "Mage doit avoir un constructeur (String, int, int, int)."
        );
    }

    @Test
    public void testConstructeurEquipeExiste() {
        assertDoesNotThrow(
                () -> Equipe.class.getDeclaredConstructor(String.class),
                "Equipe doit avoir un constructeur (String)."
        );
    }

    /* =========================================================
       INTERFACES / RELATIONS (attendues sur la version finale)
       ========================================================= */

    @Test
    public void testJoueurImplementeInterfaces() {
        List<Class<?>> interfaces = Arrays.asList(Joueur.class.getInterfaces());

        assertTrue(interfaces.contains(Identifiable.class),
                "Joueur devrait implémenter Identifiable.");
        assertTrue(interfaces.contains(Boostable.class),
                "Joueur devrait implémenter Boostable.");
        assertTrue(interfaces.contains(Eliminable.class),
                "Joueur devrait implémenter Eliminable.");
    }

    @Test
    public void testEquipeImplementeInterfaces() {
        List<Class<?>> interfaces = Arrays.asList(Equipe.class.getInterfaces());

        assertTrue(interfaces.contains(Identifiable.class),
                "Equipe devrait implémenter Identifiable.");
        assertTrue(interfaces.contains(Boostable.class),
                "Equipe devrait implémenter Boostable.");
        assertTrue(interfaces.contains(Eliminable.class),
                "Equipe devrait implémenter Eliminable.");
    }

    /* =========================================================
       VISIBILITÉ DES ATTRIBUTS
       ========================================================= */

    @Test
    public void testAttributProchainNumeroJoueurEstPriveEtStatic() throws NoSuchFieldException {
        Field f = Joueur.class.getDeclaredField("prochainNumeroJoueur");
        int mod = f.getModifiers();

        assertTrue(Modifier.isPrivate(mod),
                "L'attribut prochainNumeroJoueur doit être privé.");
        assertTrue(Modifier.isStatic(mod),
                "L'attribut prochainNumeroJoueur doit être static (variable de classe).");
    }

    @Test
    public void testAucunAttributPublicDansJoueur() {
        for (Field f : Joueur.class.getDeclaredFields()) {
            assertFalse(Modifier.isPublic(f.getModifiers()),
                    "Les attributs de Joueur ne doivent pas être publics : " + f.getName());
        }
    }

    @Test
    public void testAucunAttributPublicDansEquipe() {
        for (Field f : Equipe.class.getDeclaredFields()) {
            assertFalse(Modifier.isPublic(f.getModifiers()),
                    "Les attributs d'Equipe ne doivent pas être publics : " + f.getName());
        }
    }

    /* =========================================================
       MÉTHODES STATIQUES / VARARGS
       ========================================================= */

    @Test
    public void testVerifierNonElimineEstStatiqueSurInterfaceEliminable() throws NoSuchMethodException {
        Method m = Eliminable.class.getDeclaredMethod("verifierNonElimine", Eliminable.class);
        int mod = m.getModifiers();

        assertTrue(Modifier.isStatic(mod),
                "verifierNonElimine doit être une méthode statique de l'interface Eliminable.");
    }

    @Test
    public void testDuelJoueurEstStatique() throws NoSuchMethodException {
        Method m = Joueur.class.getDeclaredMethod("duel", Joueur.class, Joueur.class);
        assertTrue(Modifier.isStatic(m.getModifiers()),
                "La méthode duel de Joueur doit être statique.");
    }

    @Test
    public void testEquipeAjouterJoueurVarargs() throws NoSuchMethodException {
        Method m = Equipe.class.getDeclaredMethod("ajouterJoueur", Joueur[].class);
        assertTrue(m.isVarArgs(),
                "ajouterJoueur(Joueur... nouveaux) doit être une méthode varargs.");
    }

    @Test
    public void testEquipeAjouterJoueurSurchargeExiste() throws NoSuchMethodException {
        Method m1 = Equipe.class.getDeclaredMethod("ajouterJoueur", Joueur.class);
        Method m2 = Equipe.class.getDeclaredMethod("ajouterJoueur", Joueur[].class);
        assertNotNull(m1, "ajouterJoueur(Joueur) doit exister.");
        assertNotNull(m2, "ajouterJoueur(Joueur... nouveaux) doit exister.");
    }

    /* =========================================================
       COMPORTEMENT DE verifierNonElimine
       ========================================================= */

    @Test
    public void testVerifierNonElimineNeLanceRienPourNonElimine() {
        Eliminable nonElimine = new Eliminable() {
            @Override public void elimination() {}
            @Override public boolean estElimine() { return false; }
            @Override public String getNom() { return "Test"; }
        };

        // Doit exécuter sans exception si l'objet n'est pas éliminé
        assertDoesNotThrow(() -> Eliminable.verifierNonElimine(nonElimine),
                "verifierNonElimine ne doit pas lever d'exception pour un objet non éliminé.");
    }

    @Test
    public void testVerifierNonElimineDeclencheJeuExceptionAvecBonMessage() {
        Eliminable dejaElimine = new Eliminable() {
            @Override public void elimination() {}
            @Override public boolean estElimine() { return true; }
            @Override public String getNom() { return "PlayerX"; }
        };

        JeuException ex = assertThrows(JeuException.class,
                () -> Eliminable.verifierNonElimine(dejaElimine),
                "verifierNonElimine doit lever une JeuException si l'objet est déjà éliminé.");

        assertEquals("Impossible de jouer : PlayerX est déjà éliminé", ex.getMessage(),
                "Le message d'erreur de JeuException ne correspond pas à celui attendu.");
    }

    /* =========================================================
       TESTS FONCTIONNELS (puissance, boost, équipe)
       ========================================================= */

    @Test
    public void testPuissanceGuerrierUtiliseForceEtArmure() {
        Guerrier g = new Guerrier("Gandalf", 2, 3, 4);
        // Attendu dans le corrigé : niveau * (force + armure) = 2 * (3 + 4) = 14
        assertEquals(14, g.getPuissance(),
                "La puissance du guerrier devrait dépendre du niveau, de la force et de l'armure.");
    }

    @Test
    public void testPuissanceMageUtiliseManaEtSagesse() {
        Mage m = new Mage("Merlin", 2, 10, 5);
        // Attendu : niveau * (mana + 2 * sagesse) = 2 * (10 + 2*5) = 40
        assertEquals(40, m.getPuissance(),
                "La puissance du mage devrait dépendre du niveau, du mana et de la sagesse.");
    }

    @Test
    public void testBoosterGuerrierAugmenteStats() {
        Guerrier g = new Guerrier("Tank", 1, 5, 5);
        g.booster();
        // Dans le corrigé : booster() augmente le niveau, la force et l'armure de 1
        assertEquals(2, g.getNiveau(), "Le niveau du guerrier devrait avoir augmenté.");
        assertEquals(6, g.getForce(), "La force du guerrier devrait avoir augmenté.");
        assertEquals(6, g.getArmure(), "L'armure du guerrier devrait avoir augmenté.");
    }

    @Test
    public void testBoosterMageAugmenteNiveauEtSagesse() {
        Mage m = new Mage("Mage", 1, 10, 3);
        m.booster();
        assertEquals(2, m.getNiveau(), "Le niveau du mage devrait avoir augmenté.");
        assertEquals(4, m.getSagesse(), "La sagesse du mage devrait avoir augmenté.");
    }

    @Test
    public void testEquipeGetPuissanceSommeJoueurs() {
        // Petit Joueur local pour tester la somme de puissances
        class JoueurFixe extends Joueur {
            private final int puissance;
            public JoueurFixe(String nom, int puissance) { super(nom, 1); this.puissance = puissance; }
            @Override public int getPuissance() { return puissance; }
        }

        Equipe e = new Equipe("Team");
        e.ajouterJoueur(new JoueurFixe("A", 10));
        e.ajouterJoueur(new JoueurFixe("B", 20));

        assertEquals(30, e.getPuissance(),
                "La puissance de l'équipe devrait être la somme des puissances des joueurs.");
    }
}
