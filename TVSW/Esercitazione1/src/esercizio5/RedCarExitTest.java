package esercizio5;

import static org.junit.Assert.*;
import org.junit.Test;

public class RedCarExitTest {

	@Test
	public void test() {
		RushHour puzzle = new RushHour();

		// Sposto la macchina 4 verso sinistra
		assertTrue(puzzle.moveCar(3, 5, 4));

		// Sposto la macchina 3 verso il basso
		assertTrue(puzzle.moveCar(2, 5, 3));

		// Sposto la macchina rossa (1) verso destra per tre volte
		assertTrue(puzzle.moveCar(2, 2, 2));
		assertTrue(puzzle.moveCar(2, 3, 2));
		assertTrue(puzzle.moveCar(2, 4, 2));

		// Controllo se la macchina rossa � all'uscita
		assertTrue(puzzle.redCarAtExit());
	}
}
