package mylist;

import java.util.ArrayList;
import java.util.Comparator;

// Extends di un ArrayList<T> generico
public class MyList<T extends Comparable<? super T>> extends ArrayList<T> {

	private static final long serialVersionUID = 1L; // To avoid warning

	public void insert(T t) {
		this.add(t);
	}

	public T younger() {

		this.sort(new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		});
		;

		return this.get(0);
	}
}
