package heritage;

interface Langue
{
	// spécification = force les classes
	// filles à posséder une méthode bonjour 
	public String bonjour();
	
	public static void main(String[] args)
	{
		// ON NE PEUT PAS INSTANCIER UNE INTERFACE !!!!
		// Langue langue = new Langue ();
		// Sinon on appellerait une méthode qui n'est
		// pas implémentée
		// langue.bonjour(); 
		
		// Polymorphisme, je peux mettre un 
		// Francais dans une Langue parce que Francais 
		// hérite de Langue. 
		Langue[] langues = 
			{new Francais(),
			new Anglais(),
			new Allemand(),
			new Kabyle(),
			new Espagnol(),
			new Lari(),
			new Wolof(),
			new Coreen(),
			new Arabe()
			};
		for(Langue langue : langues)
			// Généricité : le même code 
			// fonctionne avec des objets de 
			// types différents 
			System.out.println(langue.bonjour());	
	}
}

class Francais 
	//	implements quand le parent est une interface
	implements Langue
{
	// Implémentation : Pour compiler, la classe 
	// fille est obligée de fournir l'implémentation
	// de toutes les méthodes déclarées dans 
	// l'interface.

	@Override
	public String bonjour()
	{
		return "Bonjour";
	}
}

class Anglais implements Langue
{
	@Override
	public String bonjour()
	{
		return "Hello";
	}
}

class Allemand implements Langue
{
	@Override
	public String bonjour()
	{
		return "Guten Tag";
	}	
}

class Kabyle implements Langue
{
	@Override
	public String bonjour()
	{
		return "Azul";
	}
}

class Espagnol implements Langue
{
	@Override
	public String bonjour()
	{
		return "Buenos dias";
	}
}

class Lari implements Langue
{
	@Override
	public String bonjour()
	{
		return "Mbote";
	}
}

class Wolof implements Langue
{
	@Override
	public String bonjour()
	{
		return "Lubaes";
	}
}

class Coreen implements Langue
{
	@Override
	public String bonjour()
	{
		return "Annyeong Asseyo";
	}
}

class Arabe implements Langue
{
	@Override
	public String bonjour()
	{
		return "Salem alekoum";
	}
}