package visitoresame;

public class UseVisitor {
	public static void main(String[] args) {
		EspressioneAritmetica n1 = new Numero(5);
		Numero n2 = new Numero(8);

		Somma s = new Somma(n1, n2);

		Prodotto p = new Prodotto(s, n2);

		Visitor v = null;
		if (Math.random() > 0.5) {
			v = Operation.instance;
		} else {
			v = new ToString();
		}

		System.out.println(p.accept(v));
	}
}