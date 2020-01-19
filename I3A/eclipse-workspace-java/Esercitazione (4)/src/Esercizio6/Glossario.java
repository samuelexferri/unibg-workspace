package Esercizio6;

import java.util.ArrayList;

public class Glossario<A extends Comparable<A>, B> {
	ArrayList<Coppia<A, B>> array = new ArrayList<Coppia<A, B>>();

	Glossario() {
	}

	public void insertInOrdine(A a, B b) {

		// Primo posto
		if (array.isEmpty()) {
			array.add(0, new Coppia<A, B>(a, b));
			return;
		}

		for (Coppia<A, B> i : array) {
			if (i.a.compareTo(a) >= 0) {
				array.add(array.indexOf(i), new Coppia<A, B>(a, b));
				return;
			}
		}

		// Ultimo posto
		array.add(array.size(), new Coppia<A, B>(a, b));
	}

	public B find(A a) {

		for (Coppia<A, B> c : array) {
			if (c.a.equals(a))
				return c.b;
		}

		return null;
	}

	public String toString() {
		String buffer = "[ ";

		for (Coppia<A, B> c : array) {
			buffer += "(Key: " + c.a.toString() + ", Value: " + c.b.toString() + ") ";
		}
		return buffer + " ]";
	}
}

class Coppia<A extends Comparable<A>, B> {
	A a;
	B b;

	Coppia(A a, B b) {
		this.a = a;
		this.b = b;
	}
}