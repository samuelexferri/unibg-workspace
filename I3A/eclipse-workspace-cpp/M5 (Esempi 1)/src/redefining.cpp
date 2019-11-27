#include <iostream>
using namespace std;

class Base {
public:
	void m(int v) {
		cout << "Base " << v << endl;
	}
	virtual void mv(int v) {
		cout << "Base " << v << endl;
	}
	void f(int x) {
	}
};

class Derivata: public Base {
public:
	void m(int v) {
		cout << "Derivata " << v << endl;
	}
	virtual void mv(int v) {
		cout << "Derivata " << v << endl;
	}
	// Redefining con cambio segnatura
	void f() { // Non posso f(8);
		Base::f(8);
	}
};

int main() {
	Base b;
	Derivata d;
	b.m(4);
	d.m(5);
	Base *p = new Derivata;
	p->m(8);
	p->mv(10);
	Base bnp = d;
	bnp.mv(12);
}
