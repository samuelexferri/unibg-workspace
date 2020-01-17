package visitoresame;

interface Visitor {
	abstract Object visit(Numero r);

	abstract Object visit(Somma s);

	abstract Object visit(Prodotto c);
}

class Operation implements Visitor {
	// Singleton
	public static Operation instance = new Operation();

	// Use Integer, not int because Object
	@Override
	public Integer visit(Numero num) {
		return num.n;
	}

	@Override
	public Integer visit(Somma som) {
		return ((int) som.ea1.accept(this) + (int) som.ea2.accept(this));
	}

	@Override
	public Integer visit(Prodotto prod) {
		return ((int) prod.ea1.accept(this) * (int) prod.ea2.accept(this));
	}
}

class ToString implements Visitor {
	@Override
	public String visit(Numero num) {
		return String.valueOf(num.n);
	}

	@Override
	public String visit(Somma som) {
		return "(" + som.ea1.accept(this) + "+" + som.ea2.accept(this) + ")";
	}

	@Override
	public String visit(Prodotto prod) {
		return prod.ea1.accept(this) + "*" + prod.ea2.accept(this);
	}
}