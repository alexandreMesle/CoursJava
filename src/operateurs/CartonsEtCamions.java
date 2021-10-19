package operateurs;

import java.util.Scanner;

public class CartonsEtCamions
{

    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Saisissez le poids d'un carton : ");
	float poidsCarton = scanner.nextFloat();
	System.out.print("Saisissez la capacité d'un camion : ");
	float capaciteCamion = scanner.nextFloat();
	int nombreCartons = (int)(capaciteCamion/poidsCarton);
	System.out.println("Vous pouvez placer " + nombreCartons
			   + " dans ce camion.");
	scanner.close();
    }
}
