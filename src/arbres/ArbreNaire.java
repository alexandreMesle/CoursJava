package arbres;

import java.util.HashSet;
import java.util.Set;

public class ArbreNaire 
{
	private int valeur;
	private Set<ArbreNaire> enfants = new HashSet<>();

	public ArbreNaire(int valeur)
	{
		this.valeur = valeur;
	}
	
	public void add(ArbreNaire enfant)
	{
		enfants.add(enfant);
	}

	public static ArbreNaire compteARebours(int n)
	{
		if (n < 0)
			return null;
		ArbreNaire arbre = new ArbreNaire(n);
		for (int i = 1 ; i <= n-1 ; i++)
			arbre.add(compteARebours(n - 1));
		return arbre;
	}
	
	@Override
	public String toString()
	{
		String res = "(";
		res += this.valeur;
		for(ArbreNaire enfant : enfants)
			res += ", " + enfant.toString();
		res += ")";
		return res;
	}
	
	public static void main(String[] args) 
	{
		ArbreNaire arbre = new ArbreNaire (1),
				arbre2 = new ArbreNaire (2);
		arbre.add(arbre2);
		arbre.add(new ArbreNaire (3));
		arbre2.add(new ArbreNaire (4));
		arbre.add(new ArbreNaire (5));
		arbre = compteARebours(4);
		System.out.println(arbre);
	}
}
