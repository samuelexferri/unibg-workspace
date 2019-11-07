import java.util.Iterator;
import java.util.List;

// Strategy pattern
public class verificaDupImpl implements verificaDupInterface<Studente> {

	@Override
	public boolean verificaDup(List<Studente> list) {
		Iterator<Studente> i1 = list.iterator();

		while (i1.hasNext()) {
			
			Studente s = i1.next();
			i1.remove();

			Iterator<Studente> i2 = list.iterator();

			while (i2.hasNext()) {
				if (s.equals(i2.next()))
					return true;
			}
		}
		return false;
	}
}