package stringlength;

import java.util.Comparator;
import java.util.List;

public class Applier<T extends Comparable<T>, S> {
	public List<S> apply(List<S> list, Function<T, S> f) {

		// Comparator<S>
		list.sort(new Comparator<S>() {
			@Override
			public int compare(S s1, S s2) {
				return f.compute(s1).compareTo(f.compute(s2));
			}
		});

		return list;
	}
}