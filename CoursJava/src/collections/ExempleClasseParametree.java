package collections;

public class ExempleClasseParametree<T>
{
	T data;

	public ExempleClasseParametree(T data)
	{
		this.data = data;
	}

	public T get()
	{
		return data;
	}    

	public void set(T data)
	{
		this.data = data;
	}
	
	public static void main(String[] args)
	{
		ExempleClasseParametree<String> conteneurString = new ExempleClasseParametree<>("toto");
		String chaine = conteneurString.get();
		System.out.println(chaine);
		
		ExempleClasseParametree<Integer> conteneurInt = new ExempleClasseParametree<>(5);
		int entier = conteneurInt.get();
		System.out.println(entier);		
	}
}
