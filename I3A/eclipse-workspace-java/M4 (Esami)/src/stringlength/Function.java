package stringlength;

abstract class Function<T extends Comparable<? super T>, S> {
	abstract T compute(S s);
}