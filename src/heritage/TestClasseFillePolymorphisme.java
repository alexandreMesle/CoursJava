package heritage;

public class TestClasseFillePolymorphisme
{
	public static void main(String[] args)
	{
		ClasseMere o = new ClasseFille(1, 2);
		System.out.println(o.getX()); 
		System.out.println(((ClasseFille) o).getY());
	}
}
