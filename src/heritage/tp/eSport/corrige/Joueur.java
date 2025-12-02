package heritage.tp.eSport.corrige;

import java.util.ArrayList;

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
        if (e.estElimine())
        {
            throw new JeuException("Impossible de jouer : " + e.getNom() + " est déjà éliminé");
        }
    }
}

interface Boostable
{
	void booster();
}

abstract class Joueur implements Identifiable, Boostable, Eliminable
{

	// Numéro du prochain joueur qui sera créé (variable de classe)
	private static int prochainNumeroJoueur = 1;

	private final int id;
	private String pseudo;
	private int niveau;
	private boolean elimine = false;

	// Le niveau par défaut est 1
	public Joueur(String pseudo)
	{
		this(pseudo, 1);
	}

	public Joueur(String pseudo, int niveau)
	{
		if (pseudo == null || pseudo.isBlank())
		{
			throw new PseudoInvalideException("Le pseudo ne peut pas être vide");
		}
		if (niveau < 1)
		{
			throw new StatistiqueInvalideException("Le niveau doit être >= 1");
		}
		this.id = prochainNumeroJoueur++;
		this.pseudo = pseudo;
		this.niveau = niveau;
	}	

	// Calcule la puissance d'un joueur (méthode abstraite : chaque sous-classe a sa formule)
	public abstract int getPuissance();

	@Override
	public void elimination()
	{
		elimine = true;
	}
	
	@Override
	public boolean estElimine()
	{
		return elimine;
	}
	
	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public void booster()
	{
		this.niveau++;
	}

	// Getters / setters
	@Override
	public String getNom()
	{
		// Cette implémentation répond à la fois à :
		// - Identifiable.getNom()
		// - Eliminable.getNom()
		// Les deux interfaces déclarent la même méthode, donc une seule
		// implémentation suffit : pas de conflit.
		return pseudo;
	}

	public void setPseudo(String pseudo)
	{
		if (pseudo == null || pseudo.isBlank())
		{
			throw new PseudoInvalideException("Le pseudo ne peut pas être vide");
		}
		this.pseudo = pseudo;
	}

	public int getNiveau()
	{
		return niveau;
	}

	// Redéfinition de toString et equals (pas de hashCode)
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "{" + id + ", pseudo=" + pseudo + ", niveau=" + niveau + ", puissance="
				+ getPuissance() + "}";
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

	    // Deux joueurs sont considérés égaux s'ils ont le même id.
	    // (Les id sont uniques et attribués automatiquement.)
	    return this.getId() == autre.getId();
	}
	
	public static Joueur duel(Joueur j1, Joueur j2)
	{		
		// On vérifie que les deux joueurs ne sont pas déjà éliminés
		Eliminable.verifierNonElimine(j1);
	    Eliminable.verifierNonElimine(j2);
	    
	    int p1 = j1.getPuissance();
	    int p2 = j2.getPuissance();

	    if (p1 > p2)
	    {
	        j2.elimination();
	        return j1;
	    }
	    if (p2 > p1)
	    {
	        j1.elimination();
	        return j2;
	    }

	    // Egalité : les deux sont éliminés (double KO)
	    j1.elimination();
	    j2.elimination();
	    return null;
	}
}

/* ========== Sous-classes concrètes : Guerrier / Mage ========== */

class Guerrier extends Joueur
{

	private int force;
	private int armure;

	// Constructeur “rapide” par défaut
	public Guerrier(String pseudo)
	{
		this(pseudo, 1, 10, 5);
	}

	// Constructeur complet
	public Guerrier(String nom, int niveau, int force, int armure)
	{
		super(nom, niveau);
		setForce(force);
		setArmure(armure);
	}

	public int getForce()
	{
		return force;
	}

	public void setForce(int force)
	{
		if (force < 0)
		{
			throw new StatistiqueInvalideException("La force doit être >= 0");
		}
		this.force = force;
	}

	public int getArmure()
	{
		return armure;
	}

	public void setArmure(int armure)
	{
		if (armure < 0)
		{
			throw new StatistiqueInvalideException("L'armure doit être >= 0");
		}
		this.armure = armure;
	}

	@Override
	public int getPuissance()
	{
		return getNiveau() * (force + armure);
	}

	// Augmente de 1 le niveau, la force et l'armure
	@Override
	public void booster()
	{
		super.booster();
		force++;
		armure++;
	}
}

class Mage extends Joueur
{

	private int mana;
	private int sagesse;

	public Mage(String pseudo)
	{
		this(pseudo, 1, 20, 10);
	}

	public Mage(String pseudo, int niveau, int mana, int sagesse)
	{
		super(pseudo, niveau);
		setMana(mana);
		setSagesse(sagesse);
	}

	public int getMana()
	{
		return mana;
	}

	public void setMana(int mana)
	{
		if (mana < 0)
		{
			throw new StatistiqueInvalideException("Le mana doit être >= 0");
		}
		this.mana = mana;
	}

	public int getSagesse()
	{
		return sagesse;
	}

	public void setSagesse(int sagesse)
	{
		if (sagesse < 0)
		{
			throw new StatistiqueInvalideException("La sagesse doit être >= 0");
		}
		this.sagesse = sagesse;
	}

	@Override
	public int getPuissance()
	{
		return getNiveau() * (mana + 2 * sagesse);
	}

	// Augmente de 1 le niveau et la sagesse.
	@Override
	public void booster()
	{
		super.booster();
		sagesse++;
	}
}

class Equipe implements Identifiable, Boostable, Eliminable
{

	private static int prochaineEquipeId = 1;

	private final int id;
	private String nom;
	private final ArrayList<Joueur> joueurs = new ArrayList<>();
	private boolean elimine = false;

	public Equipe(String nom)
	{
		if (nom == null || nom.isBlank())
		{
			throw new NomEquipeInvalideException("Le nom d'équipe ne peut pas être vide");
		}
		this.id = prochaineEquipeId++;
		this.nom = nom;
	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public String getNom()
	{
		// Comme pour Joueur, cette implémentation de getNom
		// satisfait à la fois Identifiable.getNom et Eliminable.getNom.
		// Avoir la même méthode dans plusieurs interfaces n'est pas un problème
		// tant que la signature est identique.
		return nom;
	}

	public void setNom(String nom)
	{
		if (nom == null || nom.isBlank())
		{
			throw new NomEquipeInvalideException("Le nom d'équipe ne peut pas être vide");
		}
		this.nom = nom;
	}

	// Surcharge : ajouter un joueur
	public void ajouterJoueur(Joueur joueur)
	{
		if (joueur != null && !joueurs.contains(joueur))
		{
			joueurs.add(joueur);
		}
	}

	// Surcharge + varargs : ajouter plusieurs joueurs d'un coup
	// L'utilisation de "Joueur... nouveaux" permet d'appeler :
	//   equipe.ajouterJoueur(j1, j2, j3);
	// au lieu de faire trois appels séparés. C'est de la SURENCHARGE par rapport
	// à la version avec un seul Joueur en paramètre.
	public void ajouterJoueur(Joueur... nouveaux)
	{
		if (nouveaux != null)
		{
			for (Joueur j : nouveaux)
			{
				// On réutilise la version "un seul joueur" pour éviter
				// de dupliquer la logique (null, contains, etc.).
				ajouterJoueur(j);
			}
		}
	}

	public int getPuissance()
	{
		int total = 0;
		for (Joueur j : joueurs)
			total += j.getPuissance();
		return total;
	}

	@Override
	public void booster()
	{
		for (Joueur j : joueurs)
			j.booster();
	}

	@Override
	public String toString()
	{
		return "Equipe{" + id + ", nom=" + nom + ", joueurs=" + joueurs.size() + ", puissanceTotale="
				+ getPuissance() + "}";
	}

	@Override
	public boolean equals(Object obj)
	{
	    if (this == obj) return true;
	    if (!(obj instanceof Equipe)) return false;
	    Equipe autre = (Equipe) obj;
	    return this.id == autre.id;
	}
	
	@Override
	public boolean estElimine()
	{
		return elimine;
	}
	
	@Override
	public void elimination()
	{
		elimine = true;		
	}
	
	private Joueur premierJoueurNonElimine()
	{
	    for (Joueur j : joueurs)
	    {
	        if (!j.estElimine())
	        {
	            return j;
	        }
	    }
	    return null;
	}

	
	public static Equipe duel(Equipe e1, Equipe e2)
	{
		// On vérifie que les deux équipes ne sont pas déjà éliminées
		Eliminable.verifierNonElimine(e1);
		Eliminable.verifierNonElimine(e2);

	    if (e1.joueurs.isEmpty() || e2.joueurs.isEmpty())
	    {
	        throw new JeuException("Chaque équipe doit avoir au moins un joueur");
	    }

	    while (true)
	    {
	        Joueur j1 = e1.premierJoueurNonElimine();
	        Joueur j2 = e2.premierJoueurNonElimine();

	        // Plus de joueurs vivants dans les deux équipes -> match nul
	        if (j1 == null && j2 == null)
	        {
	            e1.elimination();
	            e2.elimination();
	            return null;
	        }

	        // Plus de joueurs côté e1
	        if (j1 == null)
	        {
	            e1.elimination();
	            return e2;
	        }

	        // Plus de joueurs côté e2
	        if (j2 == null)
	        {
	            e2.elimination();
	            return e1;
	        }

	        // Les deux ont un joueur -> duel de joueurs
	        Joueur.duel(j1, j2);
	        // les éliminations se font dans Joueur.duel
	    }
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