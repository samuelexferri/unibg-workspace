package visitorfiguregeometriche;

public class VisitorFigureGeometriche {
	public static void main(String[] args) {
		Rettangolo r = new Rettangolo(1, 2);
		Quadrato q = new Quadrato(3);
		Cerchio c = new Cerchio(4);

		System.out.println(r.getArea());
		System.out.println(q.getArea());
		System.out.println(c.getArea());
		System.out.println(r.getPerimetro());
		System.out.println(q.getPerimetro());
		System.out.println(c.getPerimetro());

		CalcolatoreArea ca = new CalcolatoreArea();
		CalcolatorePerimetro cp = new CalcolatorePerimetro();

		System.out.println(ca.getArea(r));
		System.out.println(ca.getArea(q));
		System.out.println(ca.getArea(c));
		System.out.println(cp.getPerimetro(r));
		System.out.println(cp.getPerimetro(q));
		System.out.println(cp.getPerimetro(c));

		RettangoloV rv = new RettangoloV(1, 2);
		QuadratoV qv = new QuadratoV(3);
		CerchioV cv = new CerchioV(4);

		AreaVisitor areaV = new AreaVisitor();
		PerimetroVisitor perV = new PerimetroVisitor();

		System.out.println(rv.accept(areaV));
		System.out.println(qv.accept(areaV));
		System.out.println(cv.accept(areaV));
		System.out.println(rv.accept(perV));
		System.out.println(qv.accept(perV));
		System.out.println(cv.accept(perV));
	}
}

// Metodi singoli
class Rettangolo {
	double base;
	double altezza;

	public Rettangolo(double b, double a) {
		base = b;
		altezza = a;
	}

	public double getArea() {
		return base * altezza;
	}

	public double getPerimetro() {
		return 2 * (base + altezza);
	}
}

class Quadrato {
	double base;

	public Quadrato(double b) {
		base = b;
	}

	public double getArea() {
		return base * base;
	}

	public double getPerimetro() {
		return 4 * base;
	}
}

class Cerchio {
	double raggio;

	public Cerchio(double r) {
		raggio = r;
	}

	public double getPerimetro() {
		return 2 * Math.PI * raggio;
	}

	public double getArea() {
		return Math.PI * raggio * raggio;
	}
}

//Due classi
class CalcolatoreArea {
	public double getArea(Rettangolo r) {
		return r.base * r.altezza;
	}

	public double getArea(Quadrato q) {
		return q.base * q.base;
	}

	public double getArea(Cerchio c) {
		return Math.PI * c.raggio * c.raggio;
	}
}

class CalcolatorePerimetro {
	public double getPerimetro(Rettangolo r) {
		return 2 * (r.base + r.altezza);
	}

	public double getPerimetro(Quadrato q) {
		return 4 * q.base;
	}

	public double getPerimetro(Cerchio c) {
		return 2 * Math.PI * c.raggio;
	}
}

//Visitor
class RettangoloV implements Visitable {
	double base;
	double altezza;

	public RettangoloV(double b, double a) {
		base = b;
		altezza = a;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}

class QuadratoV implements Visitable {
	double base;

	public QuadratoV(double b) {
		base = b;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}

class CerchioV implements Visitable {
	double raggio;

	public CerchioV(double r) {
		raggio = r;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
}

interface Visitable {
	public double accept(Visitor visitor);
}

interface Visitor {
	double visit(RettangoloV rettangoloV);

	double visit(CerchioV cerchioV);

	double visit(QuadratoV quadratoV);
}

class AreaVisitor implements Visitor {
	@Override
	public double visit(RettangoloV rettangoloV) {
		return rettangoloV.base * rettangoloV.altezza;
	}

	@Override
	public double visit(CerchioV cerchioV) {
		return Math.PI * cerchioV.raggio * cerchioV.raggio;
	}

	@Override
	public double visit(QuadratoV quadratoV) {
		return quadratoV.base * quadratoV.base;
	}
}

class PerimetroVisitor implements Visitor {
	@Override
	public double visit(RettangoloV rettangoloV) {
		return 2 * (rettangoloV.base + rettangoloV.altezza);
	}

	@Override
	public double visit(CerchioV cerchioV) {
		return 2 * Math.PI * cerchioV.raggio;
	}

	@Override
	public double visit(QuadratoV quadratoV) {
		return 4 * quadratoV.base;
	}
}
