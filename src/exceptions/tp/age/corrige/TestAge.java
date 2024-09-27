package exceptions.tp.age.corrige;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class TestAge
{
	int maintenant = LocalDate.now().getYear();
	
	@Test
	void testAge() throws AnneeInvalideException, FormatInvalideException
	{
		assertEquals(maintenant - 2010, Age.getAge("2010"), "Numérateur de 3/4");
		assertEquals(maintenant - 2001, Age.getAge("2001"), "Numérateur de 3/4");
		assertEquals(maintenant - 1920, Age.getAge("1920"), "Numérateur de 3/4");
		assertEquals(maintenant - 500, Age.getAge("500"), "Numérateur de 3/4");
	}

	@Test
	void testFutur()
	{
		AnneeInvalideException exception = assertThrows(AnneeInvalideException.class, () -> Age.getAge("2210"), "2210 devrait être dans le futur");
		assertEquals("L'année 2210 est dans le futur.", exception.getMessage());
		exception = assertThrows(AnneeInvalideException.class, () -> Age.getAge("456123"), "456123 devrait être dans le futur");
		assertEquals("L'année 456123 est dans le futur.", exception.getMessage());
	}

	@Test
	void testFormat()
	{
		FormatInvalideException exception = assertThrows(FormatInvalideException.class, () -> Age.getAge("azerty"), "La chaîne azerty devrait déclencher une exception");
		assertEquals("azerty n'est pas un entier.", exception.getMessage());
		exception = assertThrows(FormatInvalideException.class, () -> Age.getAge("12345.456"), "La chaîne 12345.456 devrait déclencher une exception");
		assertEquals("12345.456 n'est pas un entier.", exception.getMessage());
	}
}