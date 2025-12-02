package heritage.tp.rpg.sujet;

/**
 * Classe de base abstraite pour tous les héros.
 * Un héros a un nom, des points de vie et sait attaquer un autre héros.
 */
abstract class Hero
{
    /**
     * @param nom nom du héros
     * @param pointsVie points de vie de départ
     */	
    public Hero(String nom, int pointsVie)
    {
    }

    public String getNom()
    {
        return null;
    }

    public int getVie()
    {
        return 0;
    }

    public boolean estMort()
    {
        return true;
    }

    /**
     * Algorithme commun d'attaque :
     * - calcule les dégâts via la méthode abstraite calculerDegats()
     * - applique ces dégâts à la cible via subirDegats()
     * Retourne true si l'attaque est possible, false sinon.
     */
    public boolean attaquer(Hero cible)
    {
        return true;
    }

    /**
     * Méthode abstraite : chaque classe fille possède son propre calcul.
     * - Le guerrier inflige deux fois sa force en dégâts.
     * - les dégâts infligés par un archer sont égaux à son agilité.
     */
    protected abstract int calculerDegats();

    /**
     * Perte de points de vie standard.
     * Un archer avec plus de 10 points d'agilité 
     * ne subit que la moitié des dégâts (voir redéfinition dans Archer).
     */
    public void subirDegats(int degats)
    {
    	
    }

    @Override
    public String toString()
    {
        return null;
    }
}


/**
 * Un guerrier qui inflige des dégâts en fonction de sa force.
 */
class Guerrier
{
    public Guerrier(String nom, int pointsVie, int pointsAttaque)
    {
    }

    public int getPointsAttaque()
    {
        return 0;
    }
}


/**
 * Un archer qui inflige des dégâts en fonction de son agilité.
 * S'il est très agile, il esquive partiellement les dégâts.
 */
class Archer
{
    public Archer(String nom, int pointsVie, int pointsAgilite)
    {
    }

    public int getAgilite()
    {
        return 0;
    }
}
