package Esercizio4;

class A {
	Object stampa() {
		return new Object();
	}
}

class B extends A {

	Integer stampa() {
		return 3;
	}
}

public class CovarianzaArray {

	public static void main(String[] args) {
		Object[] o = new Object[5];
		Integer[] i = new Integer[5];

		o = i;
		// o[0] = new Object(); // Il compilatore lo accetta ma in runtime lancia
		// ArrayStoreException
	}
}
