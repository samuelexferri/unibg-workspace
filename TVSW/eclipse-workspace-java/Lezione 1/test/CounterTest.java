import static org.junit.Assert.*;
import org.junit.*;

import randoop.Counter;

public class CounterTest {

	Counter c;

	@Before
	public void setup() {
		c = new Counter();
	}

	@Test
	public void testCounter() {
		assertEquals(1, c.inc());
		assertNotNull(c);
		assertTrue(2 == c.inc());
		assertSame(c, c);
	}

	@Test
	public void testInc() {
		assertEquals(1, c.inc());
		assertEquals(2, c.inc());
		assertEquals(3, c.inc());
	}

	@Test
	public void testDec() {
		c.inc();
		c.inc();
		c.inc();
		assertEquals(2, c.dec());
		assertEquals(1, c.dec());
		assertEquals(0, c.dec());
	}

	// Eccezione
	@Test(expected = RuntimeException.class)
	public void testDecExc() {
		Counter c = new Counter();
		int v = c.dec();
	}
}