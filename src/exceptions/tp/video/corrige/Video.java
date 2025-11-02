package exceptions.tp.video.corrige;

/*
- [Expert 1]  Encapsulation + constructeurs chaînés (this(...)) + gestion des vues
- [Expert 2]  Instanciation dérivée : créer une version HD ; empêcher la "re-HD" via HDException
- [Expert 3]  Validation métier : bornes de durée (DUREE_MIN | DUREE_MAX) + DureeException avec message précis
*/

public class Video {

    // [Expert 1] 
    private String titre;   // titre "brut" de la vidéo (sans suffixes ni vues)
    private int duree;      // durée en minutes
    private int vues;       // compteur de vues pour CETTE vidéo
    private boolean hd;     // indicateur : cette vidéo est-elle en version HD ?

    // [Expert 1] Compteur global de vues toutes vidéos confondues
    private static int totalVues = 0;

    // Constantes du catalogue
    // [Expert 2] prix unique d'une vidéo
    public static final double PRIX_CATALOGUE = 4.99; 
    // [Expert 3] durées minimale et maximale d'une vidéo
    public static final int DUREE_MIN = 1, DUREE_MAX = 600;

    // [Expert 1]  créer une vidéo "standard" (non HD) avec 0 vue.
    public Video(String titre, int duree) throws DureeException {
        this(titre, duree, /* hd= */false);
    }

    // [Expert 1] Point central d'initialisation, appelé par :
    //   - le constructeur public
    //   - la méthode d'instanciation dérivée versionHD()
    private Video(String titre, int duree, boolean hd) throws DureeException {

        // [Expert 3] Validation de la durée avec bornes "catalogue"
        if (duree < DUREE_MIN || duree > DUREE_MAX)
            // Exception "métier" portant la valeur fautive.
            throw new DureeException(duree);
        // [Expert 1]
        this.titre = titre;
        this.duree = duree;
        this.hd    = hd;
        this.vues  = 0;
    }

    // ------------------------------------------------------------------------
    // [Expert 2] produit une nouvelle vidéo qui représente la version HD de celle-ci.
    //  - Interdiction de "re-passer en HD" une vidéo déjà HD → HDException
    //  - la durée de la version HD est la même.
    //  - la version normale et HD ont chacune leur compteur de vues 
    public Video versionHD() throws HDException {
        if (hd)
            throw new HDException(this);
        try {
            // On crée un NOUVEL objet Video, validé par le constructeur privé.
            // Durée identique, état HD = true, vues réinitialisées à 0.
            return new Video(this.titre, this.duree, /*hd=*/true);
        } catch (DureeException e) {
            // La durée actuelle a déjà été validée à la création de this.
            // Ce bloc ne devrait donc jamais s'exécuter.
            throw new RuntimeException("Cette erreur n'aurait pas dû se produire (durée déjà validée).");
        }
    }

    // [Expert 1] Ajoute une vue à la vidéo
    public void visionner() 
    {
        this.vues++;
        totalVues++;
    }

 // [Expert 1]  Retourne le titre éventuellement suivi de "(HD)"
    public String getTitreComplet() {
        return getTitreBrut() + (hd ? " (HD)" : "");
    }

    // [Expert 1]  Retourne le titre
    public String getTitreBrut() {
        return titre;
    }
    
    // [Expert 1]
    public int getDuree() {
        return duree;
    }

    // [Expert 1]
    public int getVues() {
        return vues;
    }

    // [Expert 1]
    // Retourne le prix d'une vidéo. 
    public static double getPrixCatalogue() {
        return PRIX_CATALOGUE;
    }

    // retourne le nombre total vues sur l'intégralité du catalogue. 
    public static int getTotalVues() {
        return totalVues;
    }
}

/*
[Expert 3] Déclenchée si une vidéo a une durée en dehors des bornes DUREE_MIN et DUREE_MAX 
*/
class DureeException extends Exception {
    private int dureeInvalide;

    public DureeException(int dureeInvalide) {
        this.dureeInvalide = dureeInvalide;
    }

    public String getErrorMessage() {
        if (dureeInvalide < Video.DUREE_MIN) {
            return "La durée " + dureeInvalide + " min est trop courte. Minimum autorisé : " + Video.DUREE_MIN + " min.";
        } else {
            return "La durée " + dureeInvalide + " min est trop longue. Maximum autorisé : " + Video.DUREE_MAX + " min.";
        }
    }
}

/*
[Expert 2] Déclenchée quand on tente de créer une version HD d'une vidéo qui est déjà en HD.
*/
class HDException extends Exception {
    private Video video; // titre BRUT (sans "(HD)" et sans compteur de vues)

    public HDException(Video video) {
        this.video = video;
    }

    public String getErrorMessage() {
        return "La vidéo " + video.getTitreBrut() + " est déjà en HD.";
    }
}
