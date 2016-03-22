package tableaux;

public class ExerciceUn
{
	public static void main(String[] args)
	{
		char[] c = new char[4];
		c[0] = 'a';
		c[3] = 'J';
		c[2] = 'k';
		c[1] = 'R';
		for(int k = 0 ; k < 4 ; k++)
		        System.out.println(c[k]);
		for(int k = 0 ; k < 4 ; k++)
		        c[k]++;
		for(int k = 0 ; k < 4 ; k++)
		       System.out.println(c[k]);
	}
}
