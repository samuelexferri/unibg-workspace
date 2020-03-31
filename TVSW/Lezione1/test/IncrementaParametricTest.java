import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IncrementaParametricTest {

	int input;
	int outputAtteso;

	public IncrementaParametricTest(int i, int oa) {
		input = i;
		outputAtteso = oa;
	}

	@Parameters
	public static Collection<Object[]> creaParametri() {
		return Arrays.asList(new Object[][] { { 0, 1 }, { 2, 3 }, { 5, 6 } });
	}

	@Test
	public void testInc() {
		int outputAttuale = Incrementa.inc(input);
		assertEquals(outputAtteso, outputAttuale);
	}
}
