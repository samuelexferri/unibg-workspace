import java.util.Iterator;
import java.util.List;

// Strategy pattern
public class verificaDupImpl implements verificaDupInterface {

	@Override
	public <T> boolean verificaDup(List<T> list) {
		Iterator<T> i1 = list.iterator();

		while (i1.hasNext()) {
			
			T s = i1.next();
			i1.remove();

			Iterator<T> i2 = list.iterator();

			while (i2.hasNext()) {
				if (s.equals(i2.next()))
					return true;
			}
		}
		return false;
	}
}