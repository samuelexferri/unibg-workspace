package Es9;

import java.util.ArrayList;
import java.util.List;

public class ProvaVararags {

	static void print(String... s) {
		// s � un array di String cio� String[]
		for (String l : s) {
			System.out.print(l + " - ");
		}
		System.out.println("\n --------- ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		print("pippo");
		print("pippo", " pluto");
		print("pippo", " pluto", " paperino");
		print("pippo", " pluto", " paperino", "qui");
		//
		String[] qqq = { "qui", "quo", "qua" };
		print(qqq);

		List<String> s = new ArrayList<String>();

		print(s.toArray(new String[s.size()]));
	}

}
