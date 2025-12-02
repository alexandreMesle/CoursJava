package heritage.tp.rpg.corrige;

/**
 * Classe de base abstraite pour tous les héros.
 * Un héros a un nom, des points de vie et sait attaquer un autre héros.
 */
abstract class Hero
{
    private String nom;
    private int pointsVie;

    /**
     * @param nom nom du héros
     * @param pointsVie points de vie de départ
     */
    public Hero(String nom, int pointsVie)
    {
        this.nom = nom;
        this.pointsVie = pointsVie;
    }

    public String getNom()
    {
        return nom;
    }

    public int getVie()
    {
        return pointsVie;
    }

    public boolean estMort()
    {
        return pointsVie <= 0;
    }

    /**
     * Algorithme commun d'attaque :
     * - calcule les dégâts via la méthode abstraite calculerDegats()
     * - applique ces dégâts à la cible via subirDegats()
     * Retourne true si l'attaque est possible, false sinon.
     */
    public boolean attaquer(Hero cible)
    {
        if (cible == null || this.estMort() || cible.estMort())
            return false; // attaque impossible

        int degats = this.calculerDegats(); // MÉTHODE ABSTRAITE → POLYMORPHISME OBLIGATOIRE
        // sécurisation minimale : éviter les dégâts négatifs
        if (degats < 0)
            degats = 0;

        cible.subirDegats(degats);
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
        pointsVie -= degats;
        if (pointsVie < 0)
            pointsVie = 0;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "{nom=" + nom + ", vie=" + pointsVie + "}";
    }
}


/**
 * Un guerrier qui inflige des dégâts en fonction de sa force.
 */
class Guerrier extends Hero
{
    private int pointsAttaque;

    public Guerrier(String nom, int pointsVie, int pointsAttaque)
    {
        super(nom, pointsVie);
        this.pointsAttaque = pointsAttaque;
    }

    public int getPointsAttaque()
    {
        return pointsAttaque;
    }

    /**
     * Le guerrier inflige deux fois sa force en dégâts.
     */
    @Override
    protected int calculerDegats()
    {
        return pointsAttaque * 2;
    }
}


/**
 * Un archer qui inflige des dégâts en fonction de son agilité.
 * S'il est très agile, il esquive partiellement les dégâts.
 */
class Archer extends Hero
{
    private int agilite;

    public Archer(String nom, int pointsVie, int pointsAgilite)
    {
        super(nom, pointsVie);
        this.agilite = pointsAgilite;
    }

    public int getAgilite()
    {
        return agilite;
    }

    @Override
    protected int calculerDegats()
    {
        return agilite;
    }
    
    @Override
    public void subirDegats(int degats)
    {
        // Un archer avec plus de 10 points d'agilité ne subit que la moitié des dégâts
        if (agilite > 10)
            degats /= 2;

        super.subirDegats(degats);
    }
}
