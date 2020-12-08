package parcoursDeGraphes;

import java.util.*;

class Coordonnees
{
	private int col, row;
	
	Coordonnees(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	@Override
	public int hashCode()
	{
		return Graphe.NB_ROWS  * col + row;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Coordonnees other = (Coordonnees)obj;
		return other.row == row && other.col == col;
	}
	
	@Override
	public String toString()
	{
		return "("+ row + ", " + col + ")";
	}
	
	Set<Coordonnees> voisins()
	{
		Set<Coordonnees> voisins = new HashSet<>();
		voisins.add(new Coordonnees(row + 1, col));
		voisins.add(new Coordonnees(row - 1, col));
		voisins.add(new Coordonnees(row, col + 1));
		voisins.add(new Coordonnees(row, col - 1));
		return voisins;
	}
}

class Sommet
{
	private Coordonnees coordonnees;
	
	private Set<Sommet> voisins = new HashSet<>();
	
	Sommet (Coordonnees coordonnees)
	{
		this.coordonnees = coordonnees;
	}
	
	void connecter(Sommet voisin)
	{
		this.voisins.add(voisin);
		voisin.voisins.add(this);
	}
	
	 Coordonnees getCoordonnees()
	 {
		 return coordonnees;
	 }
	
	void parcoursEnProfondeur(Set<Sommet> visite)
	{
		if (!visite.contains(this))
		{
			visite.add(this);
			System.out.println(coordonnees);
			for (Sommet voisin : voisins)
				voisin.parcoursEnProfondeur(visite);
		}
	}
	
	void parcoursEnProfondeur()
	{
		parcoursEnProfondeur(new HashSet<>());
	}
	
	void parcoursEnLargeur()
	{
		Deque<Sommet> file = new LinkedList<>();
		Set<Sommet> visite = new HashSet<>();
		file.add(this);
		visite.add(this);
		while(!file.isEmpty())
		{
			Sommet sommet = file.getFirst();
			file.pop();
			System.out.println(sommet.getCoordonnees());
			for (Sommet voisin : sommet.voisins)
				if (!visite.contains(voisin))
				{
					visite.add(voisin);
					file.add(voisin);
				}
		}
	}
	
	@Override
	public String toString()
	{
		String string = " [ "; 
		for (Sommet voisin : voisins)
			string += voisin.coordonnees + " ";
		return string + "]\n";
	}
}

class Graphe
{
	final static int NB_COLS = 3, NB_ROWS = 3;
	
	private Map<Coordonnees, Sommet> sommets = new HashMap<>();
	
	Sommet creerSommet(Coordonnees coordonnees)
	{
		Sommet sommet = new Sommet(coordonnees);
		sommets.put(coordonnees, sommet);
		return sommet;
	}

	Sommet get(Coordonnees coordonnees)
	{
		return sommets.get(coordonnees); 
	}

	Map<Coordonnees, Sommet> getSommets()
	{
		return sommets;
	}
	
	@Override
	public String toString()
	{
		return sommets.toString();
	}
}

public class ParcoursDeGraphes
{

	public static void main(String[] args)
	{
		Graphe graphe = new Graphe();
		for (int row = 0 ; row < Graphe.NB_ROWS ; row++)
			for (int col = 0 ; col < Graphe.NB_COLS ; col++)
				graphe.creerSommet(new Coordonnees(row, col));
		for (Sommet sommet : graphe.getSommets().values())
			for (Coordonnees voisin : sommet.getCoordonnees().voisins())
			{
				Sommet adjacent = graphe.get(voisin);
				if (adjacent != null)
					sommet.connecter(adjacent);
			}
		System.out.println(graphe);
		graphe.get(new Coordonnees(0, 0)).parcoursEnLargeur();
	}
	
}
