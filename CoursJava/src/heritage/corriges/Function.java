package heritage.corriges;

/**
 * Fonction d'une variable.
 */

public abstract class Function
{
	/**
	 * Retourne l'image de x.
	 */
	public abstract double evaluate(double x);

	/**
	 * Retourne la d&eacute;riv&eacute;e.
	 */
	public abstract Function derivate();

	/**
	 * Retourne la fonction simplifi&eacute;e.
	 */
	public abstract Function simplify();

	/**
	 * Ssi la fonction ne contient pas de variable.
	 */
	public abstract boolean isConstant();

	/**
	 * Ssi la fonction est une feuille valant 0.
	 */
	public abstract boolean isZero();

	/**
	 * Ssi la fonction est une feuille valant 1.
	 */
	public abstract boolean isOne();

	/**
	 * Retourne l'integrale entre a et b (a < b), calcul&eacute;e avec la
	 * m&eacute;thode des trap&egrave;zes en effectuant nbSubdivisions
	 * subdivisions de l'intervalle &agrave; int&eacute;grer.
	 */
	public double integrate(double a, double b, int nbSubdivisions)
	{
		if (b < a)
			return integrate(b, a, nbSubdivisions);
		double eps = 1. / nbSubdivisions;
		double integral = (evaluate(a) + evaluate(b)) / 2;
		for (; a < b; a += eps)
		{
			integral += evaluate(a);
		}
		return integral * eps;
	}

	public static void main(String args[])
	{
		Function f = new Minus(new Times(new Constant(4), new Variable()),
				new Div(new Constant(1), new Variable()));
		System.out.println(f);
		System.out.println(f.evaluate(2));
		System.out.println(f.derivate());
		System.out.println(f.derivate().simplify());
		System.out.println(f.evaluate(20) - f.evaluate(2));
		for (int i = 100000; i <= 10000000; i += 100000)
			System.out.println("i = " + i + " : "
					+ f.derivate().integrate(2, 20, i));
	}
}

/**
 * f(x) = g(x) / h(x), o&ugrave; g et h sont les sous-arbres gauche et droit.
 */

class Div extends BinaryOperator
{
	Div(Function leftSon, Function rightSon)
	{
		super(leftSon, rightSon);
	}

	@Override
	public char toChar()
	{
		return '/';
	}

	@Override
	public double evaluate(double x)
	{
		return leftSon.evaluate(x) / rightSon.evaluate(x);
	}

	@Override
	public Function derivate()
	{
		return new Div(new Minus(new Times(leftSon.derivate(), rightSon),
				new Times(leftSon, rightSon.derivate())), new Times(rightSon,
				rightSon));
	}

	@Override
	public Function simplify()
	{
		Function f = simplifySubTrees();
		if (f != null)
			return f;
		if (leftSon.isZero())
			return new Constant(0);
		if (rightSon.isOne())
			return leftSon;
		if (leftSon.isOne())
			return rightSon;
		return this;
	}
}

/**
 * f(x) = c, o&ugrave; c est une constante r&eacute;elle.
 */

class Constant extends Function
{
	private double value;

	Constant(double value)
	{
		this.value = value;
	}

	@Override
	public boolean isZero()
	{
		return value == 0;
	}

	@Override
	public boolean isOne()
	{
		return value == 1;
	}

	@Override
	public boolean isConstant()
	{
		return true;
	}

	@Override
	public Function derivate()
	{
		return new Constant(0);
	}

	@Override
	public double evaluate(double x)
	{
		return value;
	}

	@Override
	public Function simplify()
	{
		return this;
	}

	@Override
	public String toString()
	{
		return "" + value;
	}
}

/**
 * f(x) = g(x) - h(x), o&ugrave; g et h sont les sous-arbres gauche et droit.
 */

class Minus extends BinaryOperator
{
	Minus(Function leftSon, Function rightSon)
	{
		super(leftSon, rightSon);
	}

	@Override
	public char toChar()
	{
		return '-';
	}

	@Override
	public double evaluate(double x)
	{
		return leftSon.evaluate(x) - rightSon.evaluate(x);
	}

	@Override
	public Function derivate()
	{
		return new Minus(leftSon.derivate(), rightSon.derivate());
	}

	@Override
	public Function simplify()
	{
		Function f = simplifySubTrees();
		if (f != null)
			return f;
		if (rightSon.isZero())
			return leftSon;
		if (leftSon.isZero())
			return new Times(new Constant(-1), rightSon);
		return this;
	}
}

/**
 * f(x) = g(x) + h(x), o&ugrave; g et h sont les sous-arbres gauche et droit.
 */

class Plus extends BinaryOperator
{
	Plus(Function leftSon, Function rightSon)
	{
		super(leftSon, rightSon);
	}

	@Override
	public char toChar()
	{
		return '+';
	}

	@Override
	public double evaluate(double x)
	{
		return leftSon.evaluate(x) + rightSon.evaluate(x);
	}

	@Override
	public Function derivate()
	{
		return new Plus(leftSon.derivate(), rightSon.derivate());
	}

	@Override
	public Function simplify()
	{
		Function f = simplifySubTrees();
		if (f != null)
			return f;
		if (leftSon.isZero())
			return rightSon;
		if (rightSon.isZero())
			return leftSon;
		return this;
	}

}

/**
 * f(x) = x.
 */

class Variable extends Function
{
	Variable()
	{
	}

	@Override
	public boolean isZero()
	{
		return false;
	}

	@Override
	public boolean isOne()
	{
		return false;
	}

	@Override
	public boolean isConstant()
	{
		return false;
	}

	@Override
	public Function derivate()
	{
		return new Constant(1);
	}

	@Override
	public double evaluate(double x)
	{
		return x;
	}

	@Override
	public Function simplify()
	{
		return this;
	}

	@Override
	public String toString()
	{
		return "x";
	}
}

/**
 * Fonction s'exprimant comme une op&eacute;ration binaire entre deux autres
 * fonctions.
 */

abstract class BinaryOperator extends Function
{
	protected Function leftSon;
	protected Function rightSon;

	BinaryOperator(Function leftSon, Function rightSon)
	{
		this.leftSon = leftSon;
		this.rightSon = rightSon;
	}

	/**
	 * Retourne l'op&eacute;rateur binaire sous forme de caract&egrave;re ('+'
	 * pour une addition '-' pour une soustraction, etc).
	 */
	public abstract char toChar();

	@Override
	public String toString()
	{
		return "(" + leftSon + " " + toChar() + " " + rightSon + ")";
	}

	@Override
	public boolean isZero()
	{
		return false;
	}

	@Override
	public boolean isOne()
	{
		return false;
	}

	@Override
	public boolean isConstant()
	{
		return leftSon.isConstant() && rightSon.isConstant();
	}

	/**
	 * Remplace les sous-arbres par leurs versions simplifi&eacute;es, retourne
	 * une feuille si l'arbre est constant.
	 */
	protected Function simplifySubTrees()
	{
		leftSon = leftSon.simplify();
		rightSon = rightSon.simplify();
		if (isConstant())
			return new Constant(evaluate(0.0));
		return null;
	}

}

/**
 * f(x) = g(x) * h(x), o&ugrave; g et h sont les sous-arbres gauche et droit.
 */

class Times extends BinaryOperator
{
	Times(Function leftSon, Function rightSon)
	{
		super(leftSon, rightSon);
	}

	@Override
	public char toChar()
	{
		return '*';
	}

	@Override
	public double evaluate(double x)
	{
		return leftSon.evaluate(x) * rightSon.evaluate(x);
	}

	@Override
	public Function derivate()
	{
		return new Plus(new Times(leftSon.derivate(), rightSon), new Times(
				leftSon, rightSon.derivate()));
	}

	@Override
	public Function simplify()
	{
		Function f = simplifySubTrees();
		if (f != null)
			return f;
		if (rightSon.isZero() || leftSon.isZero())
			return new Constant(0);
		if (rightSon.isOne())
			return leftSon;
		if (leftSon.isOne())
			return rightSon;
		return this;
	}

}
