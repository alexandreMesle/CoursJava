package testsUnitaires;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class PuissanceAvecLog extends ImplementationPuissance
{
	private final static Logger LOGGER = Logger.getLogger(PuissanceAvecLog.class
			.getName());
	static
	{
		try
		{
			FileHandler handler = new FileHandler("log/puissance.log");
			LOGGER.addHandler(handler);
			handler.setFormatter(new SimpleFormatter());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int puissance(int base, int exp)
	{
		String str = "Call to puissance : " + base + "^" + exp + " = ";
		if (exp == 0)
			str += 1;
		else if ((exp & 1) == 0)
			str += "" + base * base + "^" + (exp >> 1);
		else
			str += "" + base + "*(" + base + "^" + (exp - 1) + ")";
		LOGGER.info(str);
		return super.puissance(base, exp);
	}
}
