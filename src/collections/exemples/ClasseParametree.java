package collections.exemples;

public class ClasseParametree<T>
{
	private T data;

	public ClasseParametree(T data)
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
		ClasseParametree<String> conteneurString = new ClasseParametree<>(
				"toto");
		String chaine = conteneurString.get();
		System.out.println(chaine);

		ClasseParametree<Integer> conteneurInt = new ClasseParametree<>(5);
		int entier = conteneurInt.get();
		System.out.println(entier);
	}
}

