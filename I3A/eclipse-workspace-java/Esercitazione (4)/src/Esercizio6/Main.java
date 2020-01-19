package Esercizio6;

public class Main {

	public static void main(String[] args) {

		Glossario<Integer, String> glossario = new Glossario<Integer, String>();

		glossario.insertInOrdine(5, "Lorenzo");
		glossario.insertInOrdine(1, "Matteo");

		System.out.println(glossario.toString());

		System.out.println(glossario.find(5));

		glossario.insertInOrdine(2, "Martina");
		glossario.insertInOrdine(100, "Gino");

		System.out.println(glossario.toString());
	}
}