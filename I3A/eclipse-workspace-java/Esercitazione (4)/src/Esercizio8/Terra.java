package Esercizio8;

// Singleton e Facade
public class Terra {
	private static Terra instance = null; // Privato

	private Atmosfera a;
	private Crosta c;
	private Nucleo n;

	private Terra() { // Privato
		System.out.println("Creo la Terra");
		a = new Atmosfera("Ossigeno");
		c = new Crosta(200);
		n = new Nucleo(10);
	}

	public static Terra initTerra() {
		if (instance == null)
			instance = new Terra();

		return instance;
	}

	public String getAtmosferaAria() {
		return a.aria;
	}

	public int getCrostaDim() {
		return c.dim;
	}

	public int getNucleoDim() {
		return n.dim;
	}

	public static void main(String[] args) {
		Terra t1, t2;

		t1 = initTerra();
		System.out.println(t1.getAtmosferaAria());
		System.out.println(t1.getCrostaDim());
		System.out.println(t1.getNucleoDim());

		t2 = initTerra();
		System.out.println(t2.getAtmosferaAria());
	}
}

class Atmosfera {
	String aria;

	Atmosfera(String a) {
		aria = a;
	}

	String getDim() {
		return aria;
	}
}

class Crosta {
	int dim;

	Crosta(int n) {
		dim = n;
	}

	int getDim() {
		return dim;
	}
}

class Nucleo {
	int dim;

	Nucleo(int n) {
		dim = n;
	}

	int getDim() {
		return dim;
	}
}