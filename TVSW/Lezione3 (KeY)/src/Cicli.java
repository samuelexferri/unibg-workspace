
public class Cicli {

	//@ requires n >=0;
	//@ ensures \result == 0;
	//@ diverges true;
	public int countToZero(int n) {
		//@ loop_invariant n >= 0;
		while (n > 0) {
			// Do something
			n--;
		}
		return n;
	}

	//@ requires n == 2;
	//@ ensures \result == 0;
	public int countToZero2(int n) {
		// Do something
		n = n - 1;
		n = n - 1;
		return n;
	}

	// Un metodo che dato un ingresso un array lo azzera tutto
	//@ requires a != null;
	//@ ensures (\forall int i; i >= 0 && i< a.length; a[i] == 0);
	//@ diverges true;
	public void reset(int a[]) {
		
		//@ loop_invariant (\forall int j; j >= 0 && j< i; a[j] == 0);
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
		}
	}

	//@ requires n >= 0;
	//@ ensures \result == n*n;
	//@ diverges true;
	public int quadrato(int n) {
		int result = 0;
		
		//@ loop_invariant result == i * n && i <= n;
		for (int i = 0; i < n; i++) {
			result += n;
		}
		return result;
	}

	//@ requires x >= 0;
	//@ ensures \result == 2 * x;
	//@ diverges true;
	public int doppio(int x) {
		int counter = x;
		int result = x;
		
		//@ loop_invariant counter + result == 2 * x && counter >=0;
		while (counter > 0) {
			result++;
			counter--;
		}
		return result;
	}
}