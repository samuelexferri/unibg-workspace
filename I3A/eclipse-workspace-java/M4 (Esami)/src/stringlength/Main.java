package stringlength;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void mainXXX(String[] args) {

		List<String> list = new ArrayList<String>();

		// Lunghezza delle stringhe
		list.add("Zaira");
		list.add("Lorenzo");
		list.add("Martina");
		list.add("Aurora");

		StringLength f1 = new StringLength();

		Applier app = new Applier();

		app.apply(list, f1);

		list.forEach(e -> System.out.println(e.toString()));

		System.out.println();

		List<Studente> studenti = new ArrayList<Studente>();

		studenti.add(new Studente("Lorenzo"));
		studenti.add(new Studente("Martinata"));
		studenti.add(new Studente("Matteo"));

		StringLength f = new StringLength();

		app.apply(studenti, new Function<Integer, Studente>() {

			@Override
			public Integer compute(Studente s) {
				return s.nome.length();
			}
		});

		studenti.forEach(e -> System.out.println(e.nome));
	}
}
