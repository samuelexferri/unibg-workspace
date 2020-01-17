package novistor;

abstract class Operation {
	abstract void process(Rectangle r);

	abstract void process(Square s);

	abstract void process(Circle c);
}

class Translate extends Operation {

	@Override
	void process(Rectangle r) {
		System.out.println("Translating rectangle");
	}

	@Override
	void process(Circle c) {
		System.out.println("Translating circle");
	}

	@Override
	void process(Square c) {
		System.out.println("Translating square");
	}

}