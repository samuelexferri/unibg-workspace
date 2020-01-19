package Esercizio2;

public class Main {

	public static void main(String[] args) {
		char[] CF1 = "aaaaaaaaaaaaaaaa".toCharArray();
		char[] CF2 = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a' };

		Object p1 = new Persona("N1", "C1", CF1);
		Persona p2 = new Persona("N2", "C2", CF2);

		boolean x = p1.equals(p2);
		System.out.println(x);
	}
}