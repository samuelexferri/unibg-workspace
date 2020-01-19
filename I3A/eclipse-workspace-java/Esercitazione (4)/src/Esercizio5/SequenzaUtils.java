package Esercizio5;

import java.util.ArrayList;

public class SequenzaUtils {

	ArrayList<Object> a = new ArrayList<>();

	public SequenzaUtils() {
	}

	public void insert(Object o) {
		a.add(o);
	}

	public void stampa() {
		for (Object c : a)
			System.out.println(c.toString());
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Object mezzo() {
		int size = a.size();
		return a.get(size / 2);
	}
}