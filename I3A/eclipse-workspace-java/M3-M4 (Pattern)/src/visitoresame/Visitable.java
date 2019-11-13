package visitoresame;

interface Visitable {
	Object accept(Visitor v);
}

abstract class EspressioneAritmetica implements Visitable {
}

class Numero extends EspressioneAritmetica {
	int n;

	public Numero(int i) {
		n = i;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}

class Somma extends EspressioneAritmetica {
	EspressioneAritmetica ea1, ea2;

	public Somma(EspressioneAritmetica e1, EspressioneAritmetica e2) {
		ea1 = e1;
		ea2 = e2;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}

class Prodotto extends EspressioneAritmetica {
	EspressioneAritmetica ea1, ea2;

	public Prodotto(EspressioneAritmetica e1, EspressioneAritmetica e2) {
		ea1 = e1;
		ea2 = e2;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}