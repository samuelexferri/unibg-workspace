package esercizio4;

public class MagazzinoMain {
	public static void main(String[] args) {
		Magazzino mag = new Magazzino();

		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(1, 10);
		mag.insert(0, 5);
		System.out.println(mag.isFull());
		System.out.println(mag.isFull(1));
	}
}