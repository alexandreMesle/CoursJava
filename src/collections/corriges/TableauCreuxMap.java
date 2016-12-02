package collections.corriges;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import collections.interfaces.TableauCreux;

public class TableauCreuxMap<T> implements TableauCreux<T>
{
	private Map<Integer, T> map = new TreeMap<>();

	@Override
	public T get(int i)
	{
		return map.get(i);
	}

	@Override
	public void set(int i, T item)
	{
		map.put(i, item);
	}

	@Override
	public Iterator<T> iterator()
	{
		return map.values().iterator();
	}

	@Override
	public String toString()
	{
		String res = "[ ";
		for (T item : this)
			res += item + " ";
		return res + "]";
	}
}
