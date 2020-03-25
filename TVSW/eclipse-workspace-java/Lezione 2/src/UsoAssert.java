public class UsoAssert {

	// Assert di Java (Run Configurations, VM Arguments: -ea)
	static void foo(int x) {
		assert x > 0;
		assert check();
		assert x++ > 0;
		System.out.println(x);
	}

	public static void main(String[] args) {
		foo(3);
		// foo(-3);
	}

	private static boolean check() {
		return true;
	}
}