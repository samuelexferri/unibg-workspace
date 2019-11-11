import java.util.LinkedList;
import java.util.Stack; // Stack is already a class

public class InvertiPila {
	public static <E> void invertipila(Stack<E> pila) {
		LinkedList<E> coda = new LinkedList<>(); // LinkedList is a class that implements Queue interface

		while (!pila.empty()) {
			coda.add(pila.pop());
		}

		while (!coda.isEmpty()) {
			pila.add(coda.poll());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> pila = new Stack<>();
		pila.add(2);
		pila.add(4);
		pila.add(6);
		pila.add(8);

		System.out.println("InvertiPila: ");
		System.out.println(pila.toString());

		invertipila(pila);

		System.out.println(pila.toString());
	}
}
