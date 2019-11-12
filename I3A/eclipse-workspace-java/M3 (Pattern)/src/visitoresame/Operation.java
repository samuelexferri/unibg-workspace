package visitoresame;

interface Visitor {
	abstract int visit(Numero r);
	abstract int visit(Somma s);
	abstract int visit(Prodotto c);
}

class Operation implements Visitor {
	@Override
	public int visit(Numero num) {
		return num.n;
	}

	@Override
	public int visit(Somma som) {
		return (som.ea1.accept(this) + som.ea2.accept(this));
	}

	@Override
	public int visit(Prodotto prod) {
		return (prod.ea1.accept(this) * prod.ea2.accept(this));
	}
}