package testsUnitaires;

public class ImplementationPuissance implements Puissance
{
	public int succ(int x)
	{
		return x + 1;
	}

	public int pred(int x)
	{
		return -succ(-x);
	}

	public int somme(int a, int b)
	{
		if (b == 0)
			return a;
		if (b > 0)
			return somme(succ(a), pred(b));
		else
			return somme(pred(a), succ(b));
	}

	public int produit(int a, int b)
	{
		if (b == 0)
			return 0;
		if (b > 0)
			return somme(produit(a, pred(b)), a);
		else
			return somme(produit(a, succ(b)), -a);
	}

	public int puissance(int base, int exp)
	{
		if (exp == 0)
			return 1;
		if ((exp & 1) == 0)
			return puissance(produit(base, base), exp >> 1);
		return produit(puissance(base, pred(exp)), base);
	}
}
