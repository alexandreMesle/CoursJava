package tableaux;

public class ExerciceTrois
{
	public static void main(String[] args)
	{
		int[] k;
		k = new int[10];
		k[0] = 1;
		k[1] = 1;
		for(int i = 2 ; i < 10 ; i++)
		        k[i] = 0;
		for(int j = 1 ; j <= 3 ; j++)
		        for(int i = 1 ; i < 10 ; i++)
		                k[i] += k[i - 1];       
		for(int i = 0 ; i < 10 ; i++)
		        System.out.println(k[i]);
	}
}
