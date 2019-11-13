package pattern;

class A {
	private A() {
		System.out.println("Creo A");
	}

	// Creato solo quando serve la prima volta
	static public A instance = new A();
}

class B {
	private B() {
		System.out.println("Creo B");
	}

	// Creato solo quando chiamo questo metodo
	static public B getInstance() {
		if (instance == null)
			instance = new B();
		return instance;
	}

	private static B instance = null;
}

public class Singleton {
	public static void main(String[] args) {
		System.out.println("Start");
		A a = A.instance;
		B b = B.getInstance();
	}
}