package Esercizio5;

import java.util.ArrayList;

// Usando Comparable <? super T> mi permette di usare anche per le sottoclassi di T
public class SequenzaOrdinabile<T extends Comparable<? super T>> {
	ArrayList<T> a = new ArrayList<T>(); // Object

	public void insert(T t) {
		a.add(t);
	}

	public void sort() {
		boolean needNextPass = true;

		for (int k = 1; k < a.size() && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < a.size() - k; i++) {
				if (a.get(i).compareTo(a.get(i + 1)) > 0) {
					// Swap list[i] with list[i + 1]
					T temp = a.get(i);
					a.set(i, a.get(i + 1));
					a.set(i + 1, temp);

					needNextPass = true; // Next pass still needed
				}
			}
		}
	}

	@Override
	public String toString() {
		String buffer = "[ ";
		for (T i : a) {
			buffer += i.toString() + " ";
		}
		return buffer + "]";
	}
}