public class Main {
	static void leggiDatabase() {
		DataBase db = new DataBase();
		// ...
	}

	public static void main(String[] args) {
		leggiDatabase();
		Runtime.getRuntime().gc(); // Forza il distruttore Finalize
		// while (true);
	}
}