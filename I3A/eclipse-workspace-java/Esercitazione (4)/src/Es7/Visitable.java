package Es7;

public interface Visitable{
	<T> T accept(Visitor<T> v);
}
