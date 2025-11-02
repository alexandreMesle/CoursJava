package exceptions.tp.video.sujet;

/*
- [Expert 1]  Encapsulation + constructeurs chaînés (this(...)) + gestion des vues
- [Expert 2]  Instanciation dérivée : créer une version HD ; empêcher la "re-HD" via HDException
- [Expert 3]  Validation métier : bornes de durée (DUREE_MIN | DUREE_MAX) + DureeException avec message précis
*/

public class Video {

    // [Expert 1] 
    String titre;   // titre "brut" de la vidéo (sans suffixes ni vues)
    int duree;      // durée en minutes
    int vues;       // compteur de vues pour CETTE vidéo
    boolean hd;     // indicateur : cette vidéo est-elle en version HD ?

    // [Expert 1] Compteur global de vues toutes vidéos confondues
    int totalVues = 0;

    // Constantes du catalogue
    // [Expert 2] prix unique d'une vidéo
    double PRIX_CATALOGUE = 4.99; 
    // [Expert 3] durées minimale et maximale d'une vidéo
    int DUREE_MIN = 1, DUREE_MAX = 600;

    // [Expert 1]  créer une vidéo "standard" (non HD) avec 0 vue.
    public Video(String titre, int duree)  {
        this(null, 0, true);
    }

    // [Expert 1] Point central d'initialisation, appelé par :
    //   - le constructeur public
    //   - la méthode d'instanciation dérivée versionHD()
    Video(String titre, int duree, boolean hd){

        // [Expert 3] Validation de la durée avec bornes "catalogue"

    	// [Expert 1]
        this.titre = titre;
    }

    // ------------------------------------------------------------------------
    // [Expert 2] produit une nouvelle vidéo qui représente la version HD de celle-ci.
    //  - Interdiction de "re-passer en HD" une vidéo déjà HD → HDException
    //  - la durée de la version HD est la même.
    //  - la version normale et HD ont chacune leur compteur de vues 
    public Video versionHD(){
//        try {
            // On crée un NOUVEL objet Video, validé par le constructeur privé.
            // Durée identique, état HD = true, vues réinitialisées à 0.
            return null;
//        } catch (DureeException e) {
//            // La durée actuelle a déjà été validée à la création de this.
//            // Ce bloc ne devrait donc jamais s'exécuter.
//            throw new RuntimeException("Cette erreur n'aurait pas dû se produire (durée déjà validée).");
//        }
    }

    // [Expert 1] Ajoute une vue à la vidéo
    public void visionner() 
    {
    }

 // [Expert 1]  Retourne le titre éventuellement suivi de "(HD)"
    public String getTitreComplet() {
        return null;
    }

    // [Expert 1]  Retourne le titre
    public String getTitreBrut() {
        return null;
    }
    
    // [Expert 1]
    public int getDuree() {
        return 0;
    }

    // [Expert 1]
    public int getVues() {
        return 0;
    }

    // [Expert 1]
    // Retourne le prix d'une vidéo. 
    double getPrixCatalogue() {
        return 0;
    }

    // retourne le nombre total vues sur l'intégralité du catalogue. 
    int getTotalVues() {
        return 0;
    }
}

/*
[Expert 3] Déclenchée si une vidéo a une durée en dehors des bornes DUREE_MIN et DUREE_MAX 
*/
class DureeException extends Exception {
    public DureeException(int dureeInvalide) {
    }

    public String getErrorMessage() {
    	return null;
    }
}

/*
[Expert 2] Déclenchée quand on tente de créer une version HD d'une vidéo qui est déjà en HD.
*/
class HDException extends Exception {
    private Video video; // titre BRUT (sans "(HD)" et sans compteur de vues)

    public HDException(Video video) {
    }

    public String getErrorMessage() {
        return null;
    }
}
