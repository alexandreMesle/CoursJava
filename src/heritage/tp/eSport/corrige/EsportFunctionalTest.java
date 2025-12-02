package heritage.tp.eSport.corrige;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EsportFunctionalTest {

    /* =========================================================
       HIERARCHIE D'EXCEPTIONS
       ========================================================= */

    @Test
    public void testJeuExceptionEstRuntimeException() {
        assertTrue(RuntimeException.class.isAssignableFrom(JeuException.class),
                "JeuException doit hériter de RuntimeException.");
    }

    @Test
    public void testSousExceptionsHeritentDeJeuException() {
        assertTrue(JeuException.class.isAssignableFrom(PseudoInvalideException.class),
                "PseudoInvalideException doit hériter de JeuException.");
        assertTrue(JeuException.class.isAssignableFrom(NomEquipeInvalideException.class),
                "NomEquipeInvalideException doit hériter de JeuException.");
        assertTrue(JeuException.class.isAssignableFrom(StatistiqueInvalideException.class),
                "StatistiqueInvalideException doit hériter de JeuException.");
    }

    /* =========================================================
       CONSTRUCTEURS / INIT (Guerrier, Mage, Equipe)
       ========================================================= */

    @Test
    public void testConstructeurGuerrierInitialiseChamps() {
        Guerrier g = new Guerrier("Gandalf", 2, 3, 4);

        assertEquals("Gandalf", g.getNom(), "Le nom du guerrier doit être initialisé par le constructeur.");
        assertEquals(2, g.getNiveau(), "Le niveau du guerrier doit être initialisé par le constructeur.");
        assertEquals(3, g.getForce(), "La force du guerrier doit être initialisée par le constructeur.");
        assertEquals(4, g.getArmure(), "L'armure du guerrier doit être initialisée par le constructeur.");
    }

    @Test
    public void testConstructeurMageInitialiseChamps() {
        Mage m = new Mage("Merlin", 2, 10, 5);

        assertEquals("Merlin", m.getNom(), "Le nom du mage doit être initialisé par le constructeur.");
        assertEquals(2, m.getNiveau(), "Le niveau du mage doit être initialisé par le constructeur.");
        assertEquals(10, m.getMana(), "Le mana du mage doit être initialisé par le constructeur.");
        assertEquals(5, m.getSagesse(), "La sagesse du mage doit être initialisée par le constructeur.");
    }

    @Test
    public void testConstructeurEquipeInitialiseNom() {
        Equipe e = new Equipe("TeamA");
        assertEquals("TeamA", e.getNom(), "Le nom de l'équipe doit être initialisé par le constructeur.");
    }

    /* =========================================================
       VALIDATION / EXCEPTIONS DANS LES CONSTRUCTEURS ET SETTERS
       (Attendus sur la version complète, échoueront tant que non implémentés)
       ========================================================= */

    @Test
    public void testPseudoInvalideDeclencheExceptionDansConstructeurGuerrier() {
        assertThrows(PseudoInvalideException.class,
                () -> new Guerrier("", 1, 10, 5),
                "Un pseudo vide doit déclencher une PseudoInvalideException.");
    }

    @Test
    public void testNomEquipeInvalideDeclencheExceptionDansConstructeurEquipe() {
        assertThrows(NomEquipeInvalideException.class,
                () -> new Equipe("   "),
                "Un nom d'équipe vide doit déclencher une NomEquipeInvalideException.");
    }

    @Test
    public void testForceNegativeDeclencheStatistiqueInvalide() {
        Guerrier g = new Guerrier("Tank", 1, 5, 5);
        assertThrows(StatistiqueInvalideException.class,
                () -> g.setForce(-1),
                "Une force négative doit déclencher une StatistiqueInvalideException.");
    }

    @Test
    public void testManaNegatifDeclencheStatistiqueInvalide() {
        Mage m = new Mage("Mage", 1, 10, 3);
        assertThrows(StatistiqueInvalideException.class,
                () -> m.setMana(-5),
                "Un mana négatif doit déclencher une StatistiqueInvalideException.");
    }

    /* =========================================================
       PUISSANCE ET BOOST (Guerrier / Mage)
       ========================================================= */

    @Test
    public void testPuissanceGuerrierUtiliseNiveauForceArmure() {
        Guerrier g = new Guerrier("Gandalf", 2, 3, 4);
        // Attendu dans le corrigé : niveau * (force + armure) = 2 * (3 + 4) = 14
        assertEquals(14, g.getPuissance(),
                "La puissance du guerrier devrait dépendre du niveau, de la force et de l'armure.");
    }

    @Test
    public void testPuissanceMageUtiliseNiveauManaSagesse() {
        Mage m = new Mage("Merlin", 2, 10, 5);
        // Attendu dans le corrigé : niveau * (mana + 2 * sagesse) = 2 * (10 + 2*5) = 40
        assertEquals(40, m.getPuissance(),
                "La puissance du mage devrait dépendre du niveau, du mana et de la sagesse.");
    }

    @Test
    public void testBoosterGuerrierAugmenteNiveauEtStats() {
        Guerrier g = new Guerrier("Tank", 1, 5, 5);
        g.booster();
        // Dans le corrigé : niveau, force et armure augmentent
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

    /* =========================================================
       EQUIPE : AJOUT DE JOUEURS, PUISSANCE, BOOST
       ========================================================= */

    @Test
    public void testEquipeGetPuissanceSommeDesJoueurs() {
        // Sous-classe simple pour contrôler la puissance
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

    @Test
    public void testEquipeAjouterJoueurVarargsFonctionne() {
        class JoueurFixe extends Joueur {
            private final int puissance;
            public JoueurFixe(String nom, int puissance) { super(nom, 1); this.puissance = puissance; }
            @Override public int getPuissance() { return puissance; }
        }

        Equipe e = new Equipe("Team");
        Joueur j1 = new JoueurFixe("A", 10);
        Joueur j2 = new JoueurFixe("B", 20);
        Joueur j3 = new JoueurFixe("C", 30);

        e.ajouterJoueur(j1, j2, j3);

        assertEquals(60, e.getPuissance(),
                "La méthode ajouterJoueur(Joueur... nouveaux) devrait ajouter tous les joueurs fournis.");
    }

    /* =========================================================
       EQUALS ET TOSTRING
       ========================================================= */

    @Test
    public void testEqualsJoueurDifferentsIdsNeSontPasEgaux() {
        Guerrier g1 = new Guerrier("A", 1, 1, 1);
        Guerrier g2 = new Guerrier("B", 1, 1, 1);

        assertFalse(g1.equals(g2),
                "Deux joueurs distincts ne doivent pas être considérés comme égaux.");
    }

    @Test
    public void testEqualsJoueurReflexiviteEtNull() {
        Guerrier g1 = new Guerrier("A", 1, 1, 1);

        assertTrue(g1.equals(g1), "equals doit être réflexive (x.equals(x) est toujours vrai).");
        assertFalse(g1.equals(null), "equals(x, null) doit renvoyer false.");
    }

    @Test
    public void testEqualsEquipeDifferentesNeSontPasEgales() {
        Equipe e1 = new Equipe("Team1");
        Equipe e2 = new Equipe("Team2");

        assertFalse(e1.equals(e2),
                "Deux équipes distinctes ne doivent pas être considérées comme égales.");
    }

    @Test
    public void testToStringGuerrierContientInfosPrincipales() {
        Guerrier g = new Guerrier("Hero", 2, 3, 4);
        String s = g.toString();

        assertTrue(s.contains("Guerrier"), "toString de Guerrier devrait contenir le nom de la classe.");
        assertTrue(s.contains("Hero"), "toString de Guerrier devrait contenir le nom du joueur.");
        assertTrue(s.contains("puissance"), "toString de Guerrier devrait contenir la puissance.");
    }

    @Test
    public void testToStringEquipeContientInfosPrincipales() {
        Equipe e = new Equipe("TeamA");
        String s = e.toString();

        assertTrue(s.contains("Equipe"), "toString d'Equipe devrait contenir le nom de la classe.");
        assertTrue(s.contains("TeamA"), "toString d'Equipe devrait contenir le nom de l'équipe.");
    }

    /* =========================================================
       DUELS
       ========================================================= */

    @Test
    public void testDuelJoueurRetourneVainqueur() {
        Guerrier faible = new Guerrier("Faible", 1, 1, 1);   // puissance faible
        Guerrier fort   = new Guerrier("Fort",   1, 10, 10); // puissance forte

        Joueur gagnant = Joueur.duel(faible, fort);

        assertNotNull(gagnant, "Un duel entre deux joueurs de puissances différentes doit renvoyer un gagnant.");
        assertEquals("Fort", gagnant.getNom(),
                "Le duel doit renvoyer le joueur le plus puissant.");
    }

    @Test
    public void testDuelJoueurEgaliteRetourneNull() {
        Guerrier g1 = new Guerrier("A", 1, 5, 5);
        Guerrier g2 = new Guerrier("B", 1, 5, 5);

        Joueur gagnant = Joueur.duel(g1, g2);

        assertNull(gagnant,
                "En cas d'égalité parfaite de puissance, le duel doit retourner null.");
    }

    @Test
    public void testDuelEquipeRetourneEquipeLaPlusForte() {
        // Joueurs simples avec puissance contrôlée
        class JoueurFixe extends Joueur {
            private final int puissance;
            public JoueurFixe(String nom, int puissance) { super(nom, 1); this.puissance = puissance; }
            @Override public int getPuissance() { return puissance; }
        }

        Equipe e1 = new Equipe("E1");
        Equipe e2 = new Equipe("E2");

        e1.ajouterJoueur(new JoueurFixe("A", 10));
        e1.ajouterJoueur(new JoueurFixe("B", 10));  // total 20

        e2.ajouterJoueur(new JoueurFixe("C", 5));
        e2.ajouterJoueur(new JoueurFixe("D", 5));   // total 10

        Equipe gagnante = Equipe.duel(e1, e2);

        assertNotNull(gagnante, "Un duel entre deux équipes de puissance totale différente doit renvoyer une équipe.");
        assertEquals("E1", gagnante.getNom(),
                "L'équipe la plus puissante devrait gagner le duel.");
    }
}
