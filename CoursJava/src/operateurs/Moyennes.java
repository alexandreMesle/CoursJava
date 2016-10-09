package operateurs;

import java.util.Scanner;

public class Moyennes
{
    public static void main(String[] args)
    {
	Scanner scanner = new Scanner(System.in);
	float a, b;
	System.out.print("Saissez deux flottants : \n * ");
	a = scanner.nextFloat();
	System.out.print(" * ");
	b = scanner.nextFloat();
	double arithmetique = (a + b) / 2, 
	    geometrique = Math.sqrt(a * b);
	System.out.println("La différence entre les moyennes "
			   + "arithmétiques et géométriques est " + 
			   (arithmetique - geometrique));
	scanner.close();
    }
}
