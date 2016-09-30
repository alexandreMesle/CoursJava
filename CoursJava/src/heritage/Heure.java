package heritage;

import java.util.Random;

public class Heure
{
	private int heures, minutes;

	public Heure(int heures, int minutes)
	{
		this.heures = intAbs(heures) % 24;
		this.minutes = intAbs(minutes) % 60;
	}

	public Heure(Random r)
	{
		this(r.nextInt(), r.nextInt());
	}

	private int intAbs(int x)
	{
		if (x > 0)
			return x;
		else
			return -x;
	}

	public int getHeures()
	{
		return heures;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public void setHeures(int heures)
	{
		this.heures = heures;
	}

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	@Override
	public String toString() 
	{
		return heures + ":" + minutes;
	}
	
	public int enMinutes()
	{
		return 60 * heures + minutes;
	}
}
