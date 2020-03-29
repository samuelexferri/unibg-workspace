package esercizio4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagazzinoBranchCoverage {

	@Test
	public void testInsertBranch() {
		Magazzino m = new Magazzino();
		m.insert(7, 20);
		m.insert(3, 5);
	}

	@Test
	public void testIsFullBranch() {
		Magazzino m = new Magazzino();

		m.isFull(10);
		m.isFull();
		m.isFull(0);

		assertFalse(m.isFull()); // Il magazzino è vuoto

		assertTrue(m.insert(0, 10)); // Prodotto 0
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertTrue(m.insert(0, 10));
		assertFalse(m.insert(0, 10));
		m.isFull(0);

		assertTrue(m.insert(1, 10)); // Prodotto 1
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));
		assertTrue(m.insert(1, 10));

		assertTrue(m.insert(2, 10)); // Prodotto 2
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));
		assertTrue(m.insert(2, 10));

		assertTrue(m.insert(3, 10)); // Prodotto 3
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));
		assertTrue(m.insert(3, 10));

		assertTrue(m.insert(4, 10)); // Prodotto 4
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));
		assertTrue(m.insert(4, 10));

		assertTrue(m.isFull());
	}

}
