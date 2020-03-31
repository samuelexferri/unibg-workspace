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

	/*+INFERRED@
	  @ private normal_behavior
	  @     ensures \result == true; 
	  @     ensures `terminationPosition == 314; 
	  @     ensures `exception == null; 
	  @*/
	/*+INFERRED@
	  @ private normal_behavior
	  @     ensures \result == true; 
	  @     ensures `terminationPosition == 490; 
	  @     ensures `exception == null; 
	  @*/
	private static boolean check() {
		return true;
	}
}