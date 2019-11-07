package it.test;

/**
 * The Class TestClass Classe che si occupa di sommare due numeri.
 */
public class TestClass {

	/** The first number. */
	int a;

	/** The second number. */
	int b;

	/**
	 * Instantiates a new test class.
	 */
	public TestClass() {
		a = 0;
		b = 0;
	}

	/**
	 * Instantiates a new test class.
	 *
	 * @param a the first number
	 * @param b the second number
	 */
	public TestClass(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * Sum numbers.
	 *
	 * @return the sum
	 */
	public int sumNumbers() {
		return a + b;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		TestClass t = new TestClass(10, 20);
		System.out.println(t.sumNumbers());
	}
}
