
public class Main {

	//@ requires x > 0;
	//@ ensures \result == 2 *(x +10);
	int assegna(int x) {
		x = x + 10;
		x = x * 2;
		return x;
	}

	//@ ensures \result >= x && \result >=y;
	//@ ensures \result == x || \result ==y;
	int max(int x, int y) {
		return x > y ? x : 100;
	}
}