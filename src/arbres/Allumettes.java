package arbres;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Allumettes
{
	private int allumettesRestantes;
	private boolean monTour;
	private int score;
	private Map<Integer, Allumettes> enfants = new HashMap<>();
	
	public Allumettes(int allumettesRestantes, boolean monTour)
	{
		this.allumettesRestantes = allumettesRestantes;
		this.monTour = monTour;
		for (int nombre = 1 ; nombre <= 3 && nombre <= allumettesRestantes ; nombre++)
			enfants.put(nombre, new Allumettes(allumettesRestantes - nombre, !monTour));
	}

	public int calculeScores()
	{
		if (monTour)
		{
			score = -1;
			for (Allumettes enfant : enfants.values())
			{
				int scoreEnfant = enfant.calculeScores();
				score = score > scoreEnfant ? score : scoreEnfant; 
			}
		}
		else
		{
			score = 1;
			for (Allumettes enfant : enfants.values())
			{
				int scoreEnfant = enfant.calculeScores();
				score = score < scoreEnfant ? score: scoreEnfant; 
			}
		}
		return score;
	}
	
	public int nombreChoisi()
	{
		int meilleurNombreAllumettes = 1;
		calculeScores();
		for (Integer nombreAllumettes: enfants.keySet())
			meilleurNombreAllumettes = enfants.get(meilleurNombreAllumettes).score > enfants.get(nombreAllumettes).score 
					? meilleurNombreAllumettes : nombreAllumettes;
		return meilleurNombreAllumettes;
	}
	
	public String enChaine(int profondeur)
	{
		String res = "";
		res += "allumettes = " + allumettesRestantes + ", ";
		res += monTour ? "IA" : "Humain";
		res += ", score = " + score;
		res += "\n";
		for (Allumettes allumettes: enfants.values())
		{
			for (int i = 1 ; i <= profondeur ; i++)
				res += " ";
			res += allumettes.enChaine(profondeur + 1);
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int nombreAllumettes = 17;
		boolean tourIA = false; 
		while(nombreAllumettes != 0)
		{
			System.out.println("Il reste " + nombreAllumettes + " allumettes.");
			if (tourIA)
			{
				Allumettes allumettes = new Allumettes(nombreAllumettes, true);
				int nombreChoisi = allumettes.nombreChoisi();
//				System.err.println(allumettes.affiche(1));
				System.out.println("L'IA prend " + nombreChoisi + " allumette(s).");
				nombreAllumettes -= nombreChoisi;
			}
			else
			{
				int nombreChoisi;
				do
				{
					System.out.println("Combien souhaitez-vous en prendre ?");
					nombreChoisi = scanner.nextInt();
				}
				while(nombreChoisi < 1 || nombreChoisi > 3);
				System.out.println("Vous prennez " + nombreChoisi + " allumette(s).");
				nombreAllumettes -= nombreChoisi;				
			}
			tourIA = !tourIA;
		}
		if (tourIA)
			System.out.println("Vous avez gagné !");
		else
			System.out.println("Vous avez perdu !");
		scanner.close();
	}

}
