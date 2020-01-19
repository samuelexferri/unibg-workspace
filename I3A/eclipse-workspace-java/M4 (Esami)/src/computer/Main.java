package computer;

public class Main {

	public static void main(String[] args) {
		ListaComputer<Computer> lc = new ListaComputer<Computer>();
		ListaComputer<Notebook> ln = new ListaComputer<Notebook>();

		lc.add(new Computer(1));
		lc.add(new Computer(2));
		lc.add(new Computer(3));

		ln.add(new Notebook(4));
		ln.add(new Notebook(5));
		ln.add(new Notebook(6));

		System.out.println(Algoritmi.getFirst(lc).ID);
		System.out.println(Algoritmi.getFirst(ln).ID);
	}
}