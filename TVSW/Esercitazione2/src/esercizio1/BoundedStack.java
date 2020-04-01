package esercizio1;

public class BoundedStack {
	private /*@spec_public */Object[] elems;
	/*@spec_public */ private int size = 0; // Grandezza stack (dinamica), compresa tra 0 e elems.length

	// Invarianti:
	// size >= 0 e limitato dalla size di elems
	// elems non è nullo ma tutti gli elementi da 0 a size sono nulli

	//@ public invariant size >=0;
	//@ public invariant elems != null;
	//@ public invariant (\forall int i; i>= 0 && i < size; elems[i] != null);
	//@ public invariant (\forall int i; i>= size && i < elems.length; elems[i] == null);

	// Pre: n > 0
	// Post: elems ha n elementi
	//@ requires n > 0;
	//@ ensures elems.length == n;
	public BoundedStack(int n) {
		elems = new Object[n]; // stack di n elementi massimo
		// violazione invariante
		// elems[0] = new Object();
	}

	// Pre: non è pieno
	// Post: size viene incrementato e l'oggetto viene inserito correttamente
	//@ requires size < elems.length;
	//@ ensures size == \old(size) +1;
	public void push(Object x) {
		elems[size] = x;
		// se commento questa ho diversi contratti falsi
		size++;
	}

	// Pre: non è vuoto
	// Post size decrementato, oggetto tolto (ma gli altri rimangono uguali)
	//@ requires size > 0;
	//@ ensures size == \old(size) -1;
	//@ ensures (\forall int i; i>= 0 && i < elems.length && i != size; elems[i] == \old(elems[i]));
	//@ ensures elems[size] == null;
	public void pop() {
		size--;
		// se commento questa JML postcondition is false
		elems[size] = null;
	}

	// Pre: non è vuoto
	// Restituisce l'ultimo oggetto
	//@requires elems.length>=0;
	//@ensures \result==elems[size-1];
	public Object top() {
		return elems[size - 1];
	}
}
