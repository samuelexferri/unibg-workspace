package computer;

public class Algoritmi {

	static <T extends Computer> T getFirst(ListaComputer<T> lista) {
		return lista.get(0);
	}
}