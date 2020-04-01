package esercizio2;

public class BagOfInt {
	private /*@ spec_public */ int[] a;
	private /*@ spec_public */ int n;

	//@requires input!=null;
	public BagOfInt(int[] input) {
		a = input;
		n = input.length;
	}

	//@ ensures \result == (\num_of int y; y>= 0 && y <n; a[y] == i);
	public int occurences(int i) {
		int cont = 0;
		for (int j = 0; j < a.length; j++)
			if (a[j] == i)
				cont++;
		return cont;
	}

	//@ensures \result==(\min int i;i>=0 && i<n;a[i]);
	public int extractMin() {
		int min = a[0];

		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}

		return min;
	}
}
