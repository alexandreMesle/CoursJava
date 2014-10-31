package heritage;

/**
   Fonction d'une variable.
 */

public abstract class Function
{
    /**
       Retourne l'image de x.
     */    
    public abstract double evaluate(double x);

    /**
       Retourne la d&eacute;riv&eacute;e.
     */
    public abstract Function derivate();

    /**
       Retourne la fonction simplifi&eacute;e.
     */
    public abstract Function simplify();    

    /**
       Ssi la fonction ne contient pas de variable.
     */
    public abstract boolean isConstant();

    /**
       Ssi la fonction est une feuille valant 0.
     */    
    public abstract boolean isZero();

    /**
       Ssi la fonction  est une feuille valant 1.
     */
    public abstract boolean isOne();

    /**
       Retourne l'integrale entre a et b (a < b), calcul&eacute;e avec 
       la m&eacute;thode des trap&egrave;zes en 
       effectuant nbSubdivisions subdivisions de l'intervalle 
       &agrave; int&eacute;grer.
     */
    public double integrate(double a, double b, int nbSubdivisions)
    {
	return 0;
    }
    

    public static void main(String args[])
    {
	System.out.println("Hello world !");
    }
}

/**
f(x) = x.
*/

class Variable extends Function
{
 Variable()
 {
 }
 
 public boolean isZero()
 {
	// à vérifier
	return true;
 }

 public boolean isOne()	
 {
	// à vérifier
	return true;
 }

 public boolean isConstant()
 {
	// à vérifier
	return true;
 }

 public Function derivate()
 {
	return null;
 }    

 public double evaluate(double x)
 {
	return 0;
 }
 
 public Function simplify()
 {
	return null;
 }

 public String toString()
 {
	return "";
 }
}

/**
Fonction s'exprimant comme une op&eacute;ration binaire entre
deux autres fonctions.
*/

abstract class BinaryOperator extends Function
{
 protected Function leftSon;
 protected Function rightSon;


 BinaryOperator(Function leftSon, Function rightSon)
 {
 }

 /**
    Retourne l'op&eacute;rateur binaire sous forme de caract&egrave;re 
    ('+' pour une addition '-' pour une soustraction, etc).
  */
 public abstract char toChar();

 public String toString()
 {
	return "(" + leftSon  + " " + toChar()  + " " + rightSon + ")";
 }

 public boolean isZero()
 {
	// à vérifier !
	return true;
 }

 public boolean isOne()
 {
	// à vérifier !
	return true;
 }

 public boolean isConstant()
 {
	// à vérifier !
	return true;
 }
 
 /**
    Remplace les sous-arbres par leurs versions simplifi&eacute;es, 
    retourne une feuille si l'arbre est constant.
  */
 protected Function simplifySubTrees()
 {
	return null;
 }
 
}

/**
f(x) = c, o&ugrave; c est une constante r&eacute;elle.
*/

class Constant extends Function
{
 private double value;
 
 Constant(double value)
 {
 }

 public boolean isZero()
 {
	// à vérifier
	return true;
 }

 public boolean isOne()	
 {
	// à vérifier
	return  true;
 }

 public boolean isConstant()
 {
	// à vérifier
	return true;
 }

 public Function derivate()
 {
	return null;
 }
 
 public double evaluate(double x)
 {
	return 0;
 }
 
 public Function simplify()
 {
	return null;
 }

 public String toString()
 {
	return "";
 }
}

/**
f(x) = g(x) - h(x), o&ugrave; g et h sont les sous-arbres gauche 
et droit.
*/

class Minus extends BinaryOperator
{
 Minus(Function leftSon, Function rightSon)
 {
	super(leftSon, rightSon);
 }
 
 public char toChar()
 {
	return '?';
 }

 public double evaluate(double x)
 {
	return 0;
 }
 
 public Function derivate()
 {
	return null; 
 }    

 public Function simplify()
 {
	return null;
 }
}

/**
f(x) = g(x) + h(x), o&ugrave; g et h sont les sous-arbres gauche 
et droit.
*/

class Plus extends BinaryOperator
{
 Plus(Function leftSon, Function rightSon)
 {
	super(leftSon, rightSon);
 }
 
 public char toChar()
 {
	return '?';
 }

 public double evaluate(double x)
 {
	return 0;
 }
 
 public Function derivate()
 {
	return null; 
 }
 
 public Function simplify()
 {
	return null;
 }    
}

/**
f(x) = g(x) * h(x), o&ugrave; g et h sont les sous-arbres gauche 
et droit.
*/

class Times extends BinaryOperator
{
 Times(Function leftSon, Function rightSon)
 {
	super(leftSon, rightSon);
 }
 
 public char toChar()
 {
	return '?';
 }

 public double evaluate(double x)
 {
	return 0;
 }
 
 public Function derivate()
 {
	return null;
 }

 public Function simplify()
 {
	return null;
 }

}

/**
f(x) = g(x) / h(x), o&ugrave; g et h sont les sous-arbres gauche 
et droit.
*/

class Div extends BinaryOperator
{
 Div(Function leftSon, Function rightSon)
 {
	super(leftSon, rightSon);
 }
 
 public char toChar()
 {
	return '?';
 }

 public double evaluate(double x)
 {
	return 0;
 }
 
 public Function derivate()
 {
	return null;
 }
 
 public Function simplify()
 {
	return null;
 }
}
