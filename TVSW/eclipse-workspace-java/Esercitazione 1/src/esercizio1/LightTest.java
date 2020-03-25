package esercizio1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightTest {

	@Test
	public void testLight() {
		Light l1 = new Light();
		assertNotNull("Oggetto Light non nullo", l1);
	}

	/*
	 * Copertura delle istruzioni
	 */
	@Test
	public void testStatementCoverageLight() {
		Light l1 = new Light();
		assertTrue(l1.onOff(false, false, true));
		Light l2 = new Light();
		assertFalse(l2.onOff(false, false, false));
	}

	/*
	 * Copertura di tutti i rami (Branch)
	 */
	@Test
	public void testBranchCoverageLight() {
		Light l1 = new Light();
		l1.onOff(false, false, true);
		l1.onOff(false, false, false);
	}

	/*
	 * Copertura di tutte le singole condizioni all'interno della decisione
	 */
	@Test
	public void testConditionCoverageLight() {
		// Condizioni:
		// (bottomIn || bottomOut) && !light
		// onOff(boolean light, boolean in, boolean out)

		Light l1 = new Light();

		// Cambio solo light (OR deve essere vero)
		assertTrue(l1.onOff(false, false, true)); // 1. F,F,T
		assertFalse(l1.onOff(true, false, true)); // 2. T,F,T

		// Vario in (!light deve essere vero e out false)
		l1.onOff(false, true, false); // 3.F,T,F
		l1.onOff(false, false, false); // 4.F,F,F

	}

	/*
	 * Costruisci oggetti Light in grado di garantire copertura MCDC
	 */
	@Test
	public void testMCDCLightComplete() {
		Light l1 = new Light();

		// Cambio solo light (OR deve essere vero)
		assertTrue(l1.onOff(false, true, true)); // F,T,T->{true}
		assertFalse(l1.onOff(true, true, true)); // T,T,T->{false}

		// Cambio in
		assertTrue(l1.onOff(false, true, false)); // F,T,F->{true}
		assertFalse(l1.onOff(false, false, false)); // F,F,F->{false}

		// Cambio out
		assertTrue(l1.onOff(false, false, true)); // F,F,T->{true}
		assertFalse(l1.onOff(false, false, false)); // F,F,F->{false}
	}
}
