package stringlength;

public class StringLength extends Function<Integer, String> {

	@Override
	public Integer compute(String s) {
		return s.length();
	}
}