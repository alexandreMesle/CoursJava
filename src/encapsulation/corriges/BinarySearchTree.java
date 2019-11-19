package encapsulation.corriges;

import java.util.Random;

public class BinarySearchTree 
{
	int data;
	BinarySearchTree left, right;
	
	public BinarySearchTree(BinarySearchTree left, int data, BinarySearchTree right) 
	{
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public BinarySearchTree(int data) 
	{
		this(null, data, null);
	}

	public String toString()
	{
		String s = "";
		if (left != null)
			s += left.toString() + " ";
		s += data;
		if (right != null)
			s += " " + right.toString();
		return s;
	}
	
	public static BinarySearchTree insert(BinarySearchTree tree, int data)
	{
		if (tree == null)
			return new BinarySearchTree(data);
		if (tree.data >= data)
			tree.left = insert(tree.left, data);
		if (tree.data < data)
			tree.right = insert(tree.right, data);
		return tree;
	}
	
	public static BinarySearchTree random(int size)
	{
		Random r = new java.util.Random();
		BinarySearchTree tree = null;
		for(int i = 1 ; i <= size ; i++)
			tree = insert(tree, r.nextInt() % 100);
		return tree;
	}
	
	public static ListeInt toList(BinarySearchTree tree, ListeInt accumulator)
	{
		if (tree.right != null)
			accumulator = toList(tree.right, accumulator);
		accumulator = new ListeInt(tree.data, accumulator);
		if (tree.left != null)
			return toList(tree.left, accumulator);
		return accumulator;
	}
	
	public static BinarySearchTree toBinarySearchTree(ListeInt liste)
	{
		BinarySearchTree tree = null;
		while (liste != null)
		{
			tree = insert(tree, liste.getData());
			liste = liste.getNext();
		}
		return tree;
	}

	public static ListeInt sort(ListeInt liste)
	{
		return toList(toBinarySearchTree(liste));
	}
	
	public static ListeInt toList(BinarySearchTree tree)
	{
		return toList(tree, null);
	}
	
	public static void main(String[] args) 
	{
		ListeInt liste = ListeInt.aleatoire(10);
		System.out.println(liste);
		System.out.println(sort(liste));
	}

}
