#include <iostream>
using namespace std;

class A {
private:
	virtual void m() {
		cout << "Metodo m di A privato" << endl;
	}
public:
	void foo() {
		cout << "foo " << endl;
		m();
	}
};

class B: public A {
	int x;
private:
	virtual void m() {
		cout << "Metodo m di B privato" << endl;
	}
};

class C: private A {
};

int main4() {
	A *pa = new A;
	pa->foo();
	delete pa;
	// Con polimorfismo
	A *pab = new B;
	pab->foo();
	delete pab;
	// Not subtyping
	// Errore: A* pc = new C;
	// s
	B b;
	A a = b;
}
