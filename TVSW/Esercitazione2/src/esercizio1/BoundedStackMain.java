package esercizio1;

public class BoundedStackMain {
	public static void main(String[] args) {
		// Errore precondizione
		// BoundedStack bsneg = new BoundedStack(0);
		
		BoundedStack bsneg = new BoundedStack(5);
		bsneg.push(new Object());
		bsneg.push(new Object());
		bsneg.push(new Object());
		bsneg.push(new Object());
		bsneg.push(new Object());
		
		// Errore: JML precondition is false
		// bsneg.push(new Object());
		
		// Provo a fare il pop
		bsneg.pop();
		bsneg.pop();
		bsneg.pop();
		bsneg.pop();
		bsneg.pop();
		
		// JML precondition is false
		// bsneg.pop();
	}
}