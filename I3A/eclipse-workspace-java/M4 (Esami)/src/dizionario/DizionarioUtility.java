package dizionario;

public class DizionarioUtility {

	public static <K> int sumkey(Dizionario<? extends Integer, K> dizionario) {
		int sum[] = { 0 };

		dizionario.list.forEach(e -> {
			sum[0] += e.key;
		});

		return sum[0];
	}
}