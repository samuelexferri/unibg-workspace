import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		List<Studente> list = new ArrayList<Studente>();
		Studente s1 = new Studente("Gino", "Pino", 101);
		Studente s2 = new Studente("Lino", "Tino", 102);
		Studente s3 = new Studente("Gino", "Pino", 101);

		list.add(s1);
		list.add(s2);
		// list.add(s3);

		verificaDupInterface alg = new verificaDupImpl();
		boolean result = alg.verificaDup(list);

		System.out.printf("Result: " + result);
	}
}
