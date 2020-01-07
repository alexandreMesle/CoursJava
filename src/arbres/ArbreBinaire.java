package arbres;

public class ArbreBinaire 
{
	private int valeur;
	private ArbreBinaire gauche, droite;

	ArbreBinaire(int valeur, ArbreBinaire gauche, ArbreBinaire droite)
	{
		this.valeur = valeur;
		this.gauche = gauche;
		this.droite = droite;
	}

	@Override
	public String toString()
	{
		String res = "(";
		if (this.gauche != null)
			res += this.gauche.toString();
		res += ", ";
		res += this.valeur;
		res += ", " ;
		if (this.droite!= null)
			res += this.droite.toString();
		res += ")";
		return res;
	}
	
	public static void main(String[] args) 
	{
		ArbreBinaire arbre = new ArbreBinaire (1, new ArbreBinaire(2, null, null), null);
		System.out.println(arbre);
	}

}
