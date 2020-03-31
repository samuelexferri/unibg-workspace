package esercizio0;

import static org.junit.Assert.*;

import org.junit.Test;

public class RettangoloTest {

	@Test
	public void test() {

		int base = 3;
		int altezza = 4;

		Rettangolo rTest = new Rettangolo(base, altezza);

		// Senza assert
		rTest.getAltezza();
		rTest.getBase();

		// Assert
		assertEquals(3, rTest.getBase());
		assertEquals(4, rTest.getAltezza());

		assertTrue(rTest.getAltezza() > 0);

		assertSame(base, rTest.getBase());

		if (rTest.getAltezza() <= 0)
			fail("Error");
	}
}
