package esercizio3;

public class Somma {
	
	Somma() {
	}

	//@ requires a!=null;
	//@ ensures \result==(\sum int k;k>=0 && k< a.length;a[k]);

	public /*@pure@*/ static int sum(int a[]) {
		int sum = 0;
		int i = 0;
		
		//@loop_invariant sum==(\sum int j;j>=0 && j< i;a[j]);
		while (i < a.length) {
			sum += a[i];
			i++;
		}
		
		//@ assert i==a.length;
		return sum;
	}
}