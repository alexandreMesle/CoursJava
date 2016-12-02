package collections.interfaces;

public interface TableauCreux<T> extends Iterable<T>
{
	public T get(int i);

	public void set(int i, T item);
}
