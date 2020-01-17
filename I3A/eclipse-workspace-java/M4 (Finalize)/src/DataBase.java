public class DataBase {
	DataBase() {
		// Creo connessione
		System.out.println("DB Connesso");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("DB Disconnesso");
	}
}