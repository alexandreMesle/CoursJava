package backtrack;

public class HuitReines
{
	private int nbReines;
	private int nbNoeuds;
	private int[] reines;
	
	public HuitReines(int nbReines)
	{
		this.nbReines = nbReines;
		this.reines = new int[nbReines];
	}
	
	public boolean solve()
	{
		nbNoeuds = 0;
		return solve(nbReines);
	}

	private boolean solve(int aPlacer)
	{
		nbNoeuds ++;
		if (aPlacer == 0)
			return verifie(aPlacer);
		else
		{
			if (!verifie(aPlacer))
				return false;
			for(int colonne = 0 ; colonne < this.nbReines ; colonne++)
			{
					this.reines[aPlacer - 1] = colonne;
					if (solve(aPlacer - 1))
						return true;
			}
			return false;
		}		
	}
	
	private int abs(int x)
	{
		return x >= 0 ? x : -x;
	}
	
	private int dist(int a, int b)
	{
		return abs(a - b);
	}
	
	private boolean verifie(int aPlacer)
	{
		for (int i = aPlacer + 1 ; i < nbReines; i ++)
			if(reines[aPlacer] == reines[i] 
				|| dist(aPlacer, i) == dist(reines[aPlacer], reines[i]))
				return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for (int i = 0 ; i < nbReines ; i++)
		{
			for (int j = 0 ; j < nbReines ; j++)
				s += reines[i] == j ? "Q " : ". ";
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args)
	{
		for (int i = 1 ; i <= 30 ; i++)
		{
			HuitReines huitReines = new HuitReines(i);
			boolean found = huitReines.solve(); 
			System.out.println("taille = " + i + ", Nb noeuds = " + huitReines.nbNoeuds);
			if (found)
				System.out.println(huitReines);
			else
				System.out.println("Pas de solution");
		}
	}

}

