
public class Invarianti {
	
	//@ requires x >= 0;
	//@ ensures \result == x;
	//@ diverges true;
	public int setTo(int x){
		int y = 0;
		
		//@ loop_invariant y <= x;
		while(y < x){
			y++;
		}
		
		// Qui all'uscita del while si ha y<=x and not (y<x) che implica y==x
		return y;
	}
	
	//@ requires timer >= 0;
	//@ ensures \result==0;
	//@ diverges true;
	public static int countdown(int timer) {
		
		//@ loop_invariant
		//@ timer >= 0;
		while(timer>0){
			timer --;
		}
		
		return timer;
	}
	
	//@ requires n >= 0;
	//@ ensures \result == n*n;
	//@ diverges true;
	public int quadrato(int n) {
		int result = 0;
		
		//@ loop_invariant result == i * n && i <= n;
		for(int i = 0; i < n; i++) {
			result += n;
		}
		
		return result;
	}
	
	//@ requires x >= 0;
	//@ ensures \result == 2 * x;
	//@ diverges true;
	public int doppio(int x) {
		int counter = x;
		int result = x;
		
		//@ loop_invariant counter + result == 2 * x && counter >=0;
		while (counter >0) {
			result ++; counter --;
		}
		
		return result;
	}
}