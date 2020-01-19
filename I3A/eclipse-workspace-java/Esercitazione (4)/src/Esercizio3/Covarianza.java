package Esercizio3;

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

public class Covarianza {

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.stampa());
	}
}
