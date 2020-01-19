package dizionario;

public class Main {

	public static void main(String[] args) {
		Dizionario<Integer, String> dizionario = new Dizionario<Integer, String>();

		dizionario.insert(5, "Lorenzo");
		dizionario.insert(2, "Martina");
		dizionario.insert(10, "Matteo");

		// System.out.println(dizionario.list.size());

		dizionario.stampa();

		System.out.println(DizionarioUtility.sumkey(dizionario));

		System.out.println(dizionario.cerca(10));

		if (dizionario.cercaVal("Lorenzo"))
			System.out.println("Trovato");
		if (dizionario.cercaVal("Psaila"))
			System.out.println("Trovato");
	}
}