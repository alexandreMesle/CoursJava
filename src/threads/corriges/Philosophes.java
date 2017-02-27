package threads.corriges;

import java.util.Random;

public class Philosophes extends Thread
{
	private final int nbPlaces = 5;
	private Couvert[] couverts;
	private Place[] places;

	public Philosophes()
	{
		couverts = new Couvert[nbPlaces];
		for (int i = 0; i < nbPlaces; i++)
			couverts[i] = new Couvert(i);
		places = new Place[nbPlaces];
		for (int i = 0; i < nbPlaces; i++)
			places[i] = new Place(i, couverts[i], couverts[(i + 1) % nbPlaces]);
	}

	@Override
	public void run()
	{
		Random r = new Random();
		int i = 0;
		while (true)
		{
			Philosophe p = new Philosophe(i++, places[r.nextInt(nbPlaces)]);
			p.start();
			try
			{
				sleep(200);
			}
			catch (InterruptedException e)
			{
			}
		}
	}

	public static void main(String[] args)
	{
		Philosophes p = new Philosophes();
		p.start();
	}
}

class Place
{
	private Couvert couvertGauche;
	private Couvert couvertDroit;
	private Philosophe philosophe;
	private int indice;

	Place(int indice, Couvert couvertGauche, Couvert couvertDroit)
	{
		this.indice = indice;
		this.couvertGauche = couvertGauche;
		this.couvertDroit = couvertDroit;
	}

	void occuper(Philosophe philosophe)
	{
		this.philosophe = philosophe;
		System.out.println(philosophe + "a pris la " + this);
	}

	void liberer()
	{
		System.out.println(philosophe + "a libere la " + this);
		philosophe = null;
	}

	void manger()
	{
		synchronized (couvertGauche)
		{
			couvertGauche.prend(this);
			synchronized (couvertDroit)
			{
				couvertDroit.prend(this);
				System.out.println(philosophe + " commence a manger a " + this);
				try
				{
					Thread.sleep(500);
				}
				catch (Exception e)
				{
				}
				System.out.println(philosophe + " a fini de manger a " + this);
				couvertDroit.repose(this);
			}
			couvertGauche.repose(this);
		}
	}

	public String toString()
	{
		return "place " + indice + " ";
	}
}

class Couvert
{
	private int indice;

	public Couvert(int indice)
	{
		this.indice = indice;
	}

	void prend(Place place)
	{
		System.out.println(this + "pris par " + place);
	}

	void repose(Place place)
	{
		System.out.println(this + "repose par " + place);
	}

	public String toString()
	{
		return "couvert " + indice + " ";
	}
}

class Philosophe extends Thread
{
	private Place place;
	private int indice;

	Philosophe(int indice, Place place)
	{
		this.indice = indice;
		this.place = place;
	}

	@Override
	public void run()
	{
		System.out.println(this + "en attente de " + place);
		synchronized (place)
		{
			place.occuper(this);
			place.manger();
			place.liberer();
		}
	}

	public String toString()
	{
		return "philosophe " + indice + " ";
	}

}
