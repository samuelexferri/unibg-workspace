package esercizio2;

public class BagOfIntMain {

	public static void main(String[] args) {

		int[] mine = new int[] { 0, 10, 20, 30, 40, 10 };

		BagOfInt b = new BagOfInt(mine);

		System.out.println(b.occurences(10));
		System.out.println(b.extractMin());
	}
}