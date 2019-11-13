package visitor;

interface Visitor {
	abstract void visit(Rectangle r);
	abstract void visit(Square s);
	abstract void visit(Circle c);
}

class Translate implements Visitor {
	@Override
	public void visit(Rectangle r) {
		System.out.println("Translating rectangle");
	}

	@Override
	public void visit(Circle c) {
		System.out.println("Translating circle");
	}

	@Override
	public void visit(Square c) {
		System.out.println("Translating square");
	}
}