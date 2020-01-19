package dizionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dizionario<K extends Comparable<K>, V> {

	List<Entry<K, V>> list = new ArrayList<Entry<K, V>>();

	public V cerca(K key) {
		for (Entry<K, V> e : this.list) {
			if (e.key.equals(key))
				return e.value;
		}

		return null;
	}

	public boolean cercaVal(V value) {
		for (Entry<K, V> e : this.list) {
			if (e.value.equals(value))
				return true;
		}
		return false;
	}

	public void insert(K key, V value) {
		V found = cerca(key);

		if (found == null) {
			this.list.add(new Entry<K, V>(key, value));
			return;
		}

		if (!found.equals(value)) {
			this.list.add(new Entry<K, V>(key, value));
			return;
		}

		System.out.println("Coppia già presente");
	}

	private void sort() {
		this.list.sort(new Comparator<Entry<K, V>>() {

			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return o1.key.compareTo(o2.key);
			}
		});
	}

	public void stampa() {
		sort();
		this.list.forEach(entry -> {
			System.out.println("Key: " + entry.key.toString() + ", Value: " + entry.value.toString());
		});
	}
}

class Entry<K, V> {
	K key;
	V value;

	Entry(K k, V v) {
		this.key = k;
		this.value = v;
	}
}