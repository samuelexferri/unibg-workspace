package visitoresame;

public class UseVisitor {
	public static void main(String[] args) {
		Operation o = new Operation();

		EspressioneAritmetica n1 = new Numero(5);
		Numero n2 = new Numero(8);
		System.out.println(n1.accept(o));

		Somma s = new Somma(n1, n2);
		System.out.println(s.accept(o));

		Prodotto p = new Prodotto(s, n2);
		System.out.println(p.accept(o));
	}
}