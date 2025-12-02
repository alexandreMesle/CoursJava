package heritage.tp.rpg.corrige;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class HeroStructureTest {

    /* =========================================================
       Classe Hero : abstraction, champs, méthodes
       ========================================================= */

    @Test
    public void testHeroEstAbstraite() {
        assertTrue(Modifier.isAbstract(Hero.class.getModifiers()),
                "La classe Hero doit être abstraite.");
    }

    @Test
    public void testChampsNomEtPointsVieSontPrivesDansHero() throws NoSuchFieldException {
        Field nom = Hero.class.getDeclaredField("nom");
        Field pointsVie = Hero.class.getDeclaredField("pointsVie");

        assertTrue(Modifier.isPrivate(nom.getModifiers()),
                "Le champ 'nom' de Hero doit être private.");
        assertTrue(Modifier.isPrivate(pointsVie.getModifiers()),
                "Le champ 'pointsVie' de Hero doit être private.");
    }

    @Test
    public void testConstructeurHeroSignatureCorrecte() throws NoSuchMethodException {
        // Hero(String, int)
        assertNotNull(Hero.class.getDeclaredConstructor(String.class, int.class),
                "Hero doit avoir un constructeur Hero(String, int).");
    }

    @Test
    public void testMethodesGetNomGetVieEtEstMortSignatures() throws NoSuchMethodException {
        Method getNom = Hero.class.getDeclaredMethod("getNom");
        Method getVie = Hero.class.getDeclaredMethod("getVie");
        Method estMort = Hero.class.getDeclaredMethod("estMort");

        assertEquals(String.class, getNom.getReturnType(),
                "getNom() doit retourner un String.");
        assertEquals(int.class, getVie.getReturnType(),
                "getVie() doit retourner un int.");
        assertEquals(boolean.class, estMort.getReturnType(),
                "estMort() doit retourner un boolean.");

        assertTrue(Modifier.isPublic(getNom.getModifiers()), "getNom() doit être public.");
        assertTrue(Modifier.isPublic(getVie.getModifiers()), "getVie() doit être public.");
        assertTrue(Modifier.isPublic(estMort.getModifiers()), "estMort() doit être public.");
    }

    @Test
    public void testCalculerDegatsEstAbstraiteEtProtegee() throws NoSuchMethodException {
        Method calculerDegats = Hero.class.getDeclaredMethod("calculerDegats");

        int mod = calculerDegats.getModifiers();

        assertTrue(Modifier.isAbstract(mod),
                "calculerDegats() doit être abstraite.");
        assertTrue(Modifier.isProtected(mod),
                "calculerDegats() doit être protected.");
        assertEquals(int.class, calculerDegats.getReturnType(),
                "calculerDegats() doit retourner un int.");
    }

    @Test
    public void testAttaquerSignatureCorrecte() throws NoSuchMethodException {
        Method attaquer = Hero.class.getDeclaredMethod("attaquer", Hero.class);
        assertEquals(boolean.class, attaquer.getReturnType(),
                "attaquer(Hero) doit retourner un boolean.");
        assertTrue(Modifier.isPublic(attaquer.getModifiers()),
                "attaquer(Hero) doit être public.");
    }

    @Test
    public void testSubirDegatsSignatureCorrecte() throws NoSuchMethodException {
        Method subirDegats = Hero.class.getDeclaredMethod("subirDegats", int.class);

        assertEquals(void.class, subirDegats.getReturnType(),
                "subirDegats(int) doit être void.");
        assertTrue(Modifier.isPublic(subirDegats.getModifiers()),
                "subirDegats(int) doit être public.");
    }

    /* =========================================================
       Héritage : Guerrier et Archer doivent étendre Hero
       ========================================================= */

    @Test
    public void testGuerrierEtendHero() {
        assertEquals(Hero.class, Guerrier.class.getSuperclass(),
                "Guerrier doit étendre Hero.");
    }

    @Test
    public void testArcherEtendHero() {
        assertEquals(Hero.class, Archer.class.getSuperclass(),
                "Archer doit étendre Hero.");
    }

    /* =========================================================
       Champs et constructeurs dans Guerrier et Archer
       ========================================================= */

    @Test
    public void testChampPointsAttaqueDansGuerrierEstPrive() throws NoSuchFieldException {
        Field pointsAttaque = Guerrier.class.getDeclaredField("pointsAttaque");
        assertTrue(Modifier.isPrivate(pointsAttaque.getModifiers()),
                "Le champ pointsAttaque dans Guerrier doit être private.");
    }

    @Test
    public void testChampAgiliteDansArcherEstPrive() throws NoSuchFieldException {
        Field agilite = Archer.class.getDeclaredField("agilite");
        assertTrue(Modifier.isPrivate(agilite.getModifiers()),
                "Le champ agilite dans Archer doit être private.");
    }

    @Test
    public void testConstructeurGuerrierSignatureCorrecte() throws NoSuchMethodException {
        assertNotNull(Guerrier.class.getDeclaredConstructor(String.class, int.class, int.class),
                "Guerrier doit avoir un constructeur (String, int, int).");
    }

    @Test
    public void testConstructeurArcherSignatureCorrecte() throws NoSuchMethodException {
        assertNotNull(Archer.class.getDeclaredConstructor(String.class, int.class, int.class),
                "Archer doit avoir un constructeur (String, int, int).");
    }

    @Test
    public void testGetPointsAttaquePublicRetourneInt() throws NoSuchMethodException {
        Method m = Guerrier.class.getDeclaredMethod("getPointsAttaque");
        assertTrue(Modifier.isPublic(m.getModifiers()),
                "getPointsAttaque() doit être public.");
        assertEquals(int.class, m.getReturnType(),
                "getPointsAttaque() doit retourner un int.");
    }

    @Test
    public void testGetAgilitePublicRetourneInt() throws NoSuchMethodException {
        Method m = Archer.class.getDeclaredMethod("getAgilite");
        assertTrue(Modifier.isPublic(m.getModifiers()),
                "getAgilite() doit être public.");
        assertEquals(int.class, m.getReturnType(),
                "getAgilite() doit retourner un int.");
    }

    /* =========================================================
       Redéfinition de subirDegats dans Archer uniquement
       ========================================================= */

    @Test
    public void testArcherRedefinitSubirDegats() throws NoSuchMethodException {
        // getDeclaredMethod réussit seulement si la méthode est déclarée dans la classe
        Method m = Archer.class.getDeclaredMethod("subirDegats", int.class);
        assertNotNull(m, "Archer doit redéfinir la méthode subirDegats(int).");
    }

    @Test
    public void testGuerrierNeRedefinitPasSubirDegats() {
        // Guerrier ne doit PAS redéfinir subirDegats -> pas de méthode déclarée localement
        assertThrows(NoSuchMethodException.class,
                () -> Guerrier.class.getDeclaredMethod("subirDegats", int.class),
                "Guerrier ne doit pas redéfinir subirDegats(int) (hérite du comportement standard de Hero).");
    }

    /* =========================================================
       toString redéfini dans Hero
       ========================================================= */

    @Test
    public void testHeroRedefinitToString() throws NoSuchMethodException {
        Method toString = Hero.class.getDeclaredMethod("toString");
        assertEquals(String.class, toString.getReturnType(),
                "toString() doit retourner un String.");
        assertTrue(Modifier.isPublic(toString.getModifiers()),
                "toString() doit être public.");
    }
}
