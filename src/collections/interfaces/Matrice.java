package collections.interfaces;

public interface Matrice<T> extends Iterable<T>
{
	public T get(int i, int j);

	public void set(int i, int j, T value);
}
