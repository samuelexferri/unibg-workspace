package randoop;


public class Counter {

	int val;

	public Counter() {
		val = 0;
	}

	public int inc() {
		return ++val;
	}

	public int dec() {
		if (val > 0)
			return --val;
		else
			throw new RuntimeException("counter <= 0");
	}
}