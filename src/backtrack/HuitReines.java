package backtrack;

public class HuitReines
{
	private int nbReines;
	private int nbNoeuds;
	private boolean[][] reines;
	
	public HuitReines(int nbReines)
	{
		this.nbReines = nbReines;
		this.reines = new boolean[nbReines][nbReines];
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
			return verifie();
		else
		{
			if (!verifie())
				return false;
			int ligne = aPlacer - 1;
			for(int colonne = 0 ; colonne < this.nbReines ; colonne++)
			{
					this.reines[ligne][colonne] = true;
					if (solve(aPlacer - 1))
						return true;
					this.reines[ligne][colonne] = false;
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
	
	private boolean verifie()
	{
		for (int i1 = 0 ; i1 < nbReines - 1; i1++)
			for (int j1 = 0 ; j1 < nbReines ; j1++)
				for (int i2 = i1 + 1 ; i2 < nbReines ; i2++)
					for (int j2 = 0 ; j2 < nbReines ; j2++)
						if(reines[i1][j1] && reines[i2][j2]
							&& (j1 == j2 || dist(i1, i2) == dist(j1, j2)))
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
				s += reines[i][j] ? "Q " : ". ";
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args)
	{
		for (int i = 1 ; i <= 30 ; i++)
		{
			HuitReines huitReines = new HuitReines(i);
			huitReines.solve();
			System.err.println("taille = " + i + ", Nb noeuds = " + huitReines.nbNoeuds);
			System.out.println(huitReines);
		}
	}

}

