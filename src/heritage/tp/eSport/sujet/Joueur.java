package heritage.tp.eSport.sujet;

interface Identifiable
{
	int getId();
	String getNom();
}

interface Eliminable
{
	void elimination();
	boolean estElimine();
	String getNom(); 
	// Ici, getNom a la même signature que dans Identifiable.
	// Ce n'est PAS un problème : tant que la signature est identique,
	// la classe qui implémente les deux interfaces ne fournit qu'une seule
	// implémentation de getNom(), qui "satisfait" les deux interfaces.

	// Méthode statique utilitaire
    static void verifierNonElimine(Eliminable e)
    {
    }
}

interface Boostable
{
	void booster();
}


abstract class Joueur
{

	// Numéro du prochain joueur qui sera créé
	private int prochainNumeroJoueur = 1;

	// Constructeur vide pour que les classes filles compilent
	// sans constructeur
	public Joueur() {}
	
	// Le niveau par défaut est 1
	public Joueur(String pseudo)
	{
	}

	public Joueur(String pseudo, int niveau)
	{
	}	

	// Calcule la puissance d'un joueur (méthode abstraite : chaque sous-classe a sa formule)
	public abstract int getPuissance();

	// Getters / setters
	public String getNom()
	{
		// Cette implémentation répond à la fois à :
		// - Identifiable.getNom()
		// - Eliminable.getNom()
		// Les deux interfaces déclarent la même méthode, donc une seule
		// implémentation suffit : pas de conflit.
		return null;
	}

	public void setNom(String nom)
	{
	}

	public int getNiveau()
	{
		return 0;
	}

	// Redéfinition de toString et equals (pas de hashCode)
	// il faut mettre un exemple de format ici.
	@Override
	public String toString()
	{
		return null;
	}

	@Override
	public boolean equals(Object obj)
	{
	    // Réflexivité : tout objet est égal à lui-même
	    if (this == obj) return true;

	    // Pour éviter un ClassCastException, on vérifie le type :
	    // si obj n'est pas un Joueur, alors ce n'est pas "égal".
	    if (!(obj instanceof Joueur)) return false;

	    // Ici, on sait que obj est un Joueur, on peut donc le caster.
	    Joueur autre = (Joueur) obj;
	    
	    return true;
	}

	// Retourne le joueur le plus puissant parmi j1 et j2, élimine l'autre.
	// Si les 2 joueurs ont la même puissance, les deux sont éliminés et 
	// null est retourné.
	// Déclenche si avant le duel un des 2 joueurs était déjà éliminé.  
	public static Joueur duel(Joueur j1, Joueur j2)
	{		
	    return null;
	}
}

class Guerrier extends Joueur
{
	// Constructeur “rapide” par défaut
	public Guerrier(String nom)
	{
		this(nom, 1, 10, 5);
	}

	// Constructeur complet
	public Guerrier(String nom, int niveau, int force, int armure)
	{
	}

	public int getForce()
	{
		return 0;
	}

	public void setForce(int force)
	{
	}

	public int getArmure()
	{
		return 0;
	}

	public void setArmure(int armure)
	{
	}

	// Retourne niveau + (force + armure)
	@Override
	public int getPuissance()
	{
		return 0;
	}

	// Augmente de 1 le niveau, la force et l'armure
	public void booster()
	{
	}
}

class Mage extends Joueur
{
	public Mage(String nom)
	{
		this(nom, 1, 20, 10);
	}

	public Mage(String nom, int niveau, int mana, int sagesse)
	{
	}

	public int getMana()
	{
		return 0;
	}

	public void setMana(int mana)
	{
	}

	public int getSagesse()
	{
		return 0;
	}

	public void setSagesse(int sagesse)
	{
	}

	// Retourne niveau * (mana + 2 * sagesse) 
	public int getPuissance()
	{
		return 0;
	}

	// Augmente de 1 le niveau et la sagesse.
	public void booster()
	{
	}
}

class Equipe
{

	private int prochaineEquipeId = 1;

	public Equipe(String nom)
	{
	}

	public int getId()
	{
		return 0;
	}

	public String getNom()
	{
		// Comme pour Joueur, cette implémentation de getNom
		// satisfait à la fois Identifiable.getNom et Eliminable.getNom.
		// Avoir la même méthode dans plusieurs interfaces n'est pas un problème
		// tant que la signature est identique.
		return null;
	}

	public void setNom(String nom)
	{
	}

	// Surcharge : ajouter un joueur
	public void ajouterJoueur(Joueur joueur)
	{
	}

	// Surcharge + varargs : ajouter plusieurs joueurs d'un coup
	// L'utilisation de "Joueur... nouveaux" permet d'appeler :
	//   equipe.ajouterJoueur(j1, j2, j3);
	// au lieu de faire trois appels séparés. C'est de la SURENCHARGE par rapport
	// à la version avec un seul Joueur en paramètre.
	public void ajouterJoueur(Joueur... nouveaux)
	{
	}

	// Retourne la somme des puissances des joueurs
	public int getPuissance()
	{
		return 0;
	}

	// Booste tous les joueurs de l'équipe
	public void booster()
	{
	}

	// Exemple à insérer
	@Override
	public String toString()
	{
		return null;
	}

	@Override
	public boolean equals(Object obj)
	{
		return true;
	}
	
	// Retourne le premier joueur non éliminé 
	private Joueur premierJoueurNonElimine()
	{
	    return null;
	}

	// Explications à insérer
	public static Equipe duel(Equipe e1, Equipe e2)
	{
		return null;
	}
}

class JeuException extends RuntimeException
{
	public JeuException(String message)
	{
		super(message);
	}
}

class PseudoInvalideException extends JeuException
{
	public PseudoInvalideException(String message)
	{
		super(message);
	}
}

class NomEquipeInvalideException extends JeuException
{
	public NomEquipeInvalideException(String message)
	{
		super(message);
	}
}

class StatistiqueInvalideException extends JeuException
{
	public StatistiqueInvalideException(String message)
	{
		super(message);
	}
}
