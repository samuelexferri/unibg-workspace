
public class Quantificazione {

	// Metodo che restituisce il massimo di un array di interi positivi
	// Precondizioni: array non nullo e non vuoto; sono tutti positivi
	//@ requires a!=null && a.length > 2;
	//@ requires (\forall int i; 0<=i && i<a.length; a[i] > 0);
	// Postcondizioni 1: il numero restituito è il massimo, maggiore uguale a tutti
	// gli elementi dell'array
	//@ ensures (\forall int i; 0<=i && i<a.length; \result >= a[i]);
	// Postcondizioni 3: il massimo è un elemento dell'array
	//@ ensures (\exists int i; 0<=i && i<a.length; \result == a[i]);
	public static int max(int[] a) {
		int max = a[0];

		for (int i = 2; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}

		// return a[0]; // Viola la prima postcondizione
		// return Integer.MAX_VALUE; // Non viola la prima postcondizione
		return max;
	}

	public static void main(String[] args) {
		int[] p = { 5, 6, 10 };
		System.out.println(max(p));
	}
}
