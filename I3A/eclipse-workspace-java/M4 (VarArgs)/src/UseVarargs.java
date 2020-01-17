import java.util.logging.Handler;

public class UseVarargs {

	static void print(String... s) {
		// s di tipo String[]
		for (String a : s)
			System.out.print(a + " ");
		System.out.println();
	}

	static void foo(int a, Handler... handlers) {
	}

	// Cose che non si possono fare: (Un solo varargs e come ultimo argomento)
	// static void foo(Handler... handlers1, Handler... handlers2) {}
	// static void foo(Handler... handlers, int a) {}

	public static void main(String[] args) {
		print("Ciao");
		print("Ciao", "io", "amo", "Java");
		String s = "oggi";
		print("Dove", "sei", s);
	}
}