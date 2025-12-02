package heritage.tp.rpg.corrige;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HeroFunctionalTest {

    @Test
    public void testGuerrierInfligeDeuxFoisSesPointsAttaque() {
        Hero guerrier = new Guerrier("Conan", 30, 5);    // pointsAttaque = 5
        Hero archer   = new Archer("Legolas", 30, 5);    // pointsAgilite = 5

        boolean attaquePossible = guerrier.attaquer(archer);

        assertTrue(attaquePossible, "L'attaque doit être possible si les deux héros sont vivants.");
        // Attendu : dégâts = 5 * 2 = 10 -> vie de l'archer : 30 - 10 = 20
        assertEquals(20, archer.getVie(),
                "Le guerrier doit infliger deux fois ses points d'attaque en dégâts.");
    }

    @Test
    public void testArcherInfligeDesDegatsEgauxAsonAgilite() {
        Hero guerrier = new Guerrier("Conan", 30, 5);
        Hero archer   = new Archer("Legolas", 30, 7);  // agilite = 7

        boolean attaquePossible = archer.attaquer(guerrier);

        assertTrue(attaquePossible, "L'attaque doit être possible si les deux héros sont vivants.");
        // Attendu : dégâts = 7 -> vie du guerrier : 30 - 7 = 23
        assertEquals(23, guerrier.getVie(),
                "L'archer doit infliger un nombre de dégâts égal à son agilité.");
    }

    @Test
    public void testArcherTresAgileSubitMoinsDeDegats() {
        // Archer très agile
        Hero archer = new Archer("Robin", 30, 12);   // agilite > 10
        Hero guerrier = new Guerrier("Conan", 30, 5); // dégâts = 2 * 5 = 10

        boolean attaquePossible = guerrier.attaquer(archer);

        assertTrue(attaquePossible, "L'attaque doit être possible si les deux héros sont vivants.");

        // Attendu dans le corrigé :
        // dégâts calculés = 10, mais comme agilite > 10, dégâts réels = 10 / 2 = 5
        // vie archer = 30 - 5 = 25
        assertEquals(25, archer.getVie(),
                "Un archer avec plus de 10 d'agilité ne doit subir que la moitié des dégâts.");
    }

    @Test
    public void testAttaquerImpossibleSiAttaquantMort() {
        Hero guerrierMort = new Guerrier("Ghost", 0, 10);
        Hero archer = new Archer("Legolas", 30, 10);

        boolean attaquePossible = guerrierMort.attaquer(archer);

        assertFalse(attaquePossible, "Un héros mort ne doit pas pouvoir attaquer.");
        assertEquals(30, archer.getVie(),
                "Si l'attaque est impossible, la vie de la cible ne doit pas changer.");
    }

    @Test
    public void testAttaquerImpossibleSiCibleMorte() {
        Hero guerrier = new Guerrier("Conan", 30, 10);
        Hero archerMort = new Archer("Ghost", 0, 10);

        boolean attaquePossible = guerrier.attaquer(archerMort);

        assertFalse(attaquePossible, "On ne doit pas pouvoir attaquer une cible déjà morte.");
        assertEquals(0, archerMort.getVie(),
                "La vie de la cible morte ne doit pas changer.");
    }

    @Test
    public void testEstMortFonctionne() {
        Hero g1 = new Guerrier("Conan", 10, 5);
        Hero g2 = new Guerrier("Dead", 0, 5);

        assertFalse(g1.estMort(), "Un héros avec des points de vie positifs ne doit pas être considéré comme mort.");
        assertTrue(g2.estMort(), "Un héros avec 0 points de vie doit être considéré comme mort.");
    }

    @Test
    public void testToStringContientNomClasseEtNomHero() {
        Hero guerrier = new Guerrier("Conan", 30, 5);
        String s = guerrier.toString();

        assertTrue(s.contains("Guerrier"),
                "toString() doit contenir le nom de la classe (Guerrier).");
        assertTrue(s.contains("Conan"),
                "toString() doit contenir le nom du héros.");
    }
}
