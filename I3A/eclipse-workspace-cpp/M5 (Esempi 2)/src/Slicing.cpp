#include <iostream>
using namespace std;

class W {
public:
	virtual void m() {
		cout << "Metodo m di W" << endl;
	}
};

class Z: public W {
public:
	virtual void m() {
		cout << "Metodo m di Z" << endl;
	}
};

class AAA {
public:
	virtual void f() = 0;
};

int main5() {
	W *pw = new Z;
	pw->m(); // Binding dinamico solo con i puntatori
	Z z;
	W w = z;
	w.m(); // No binding dinamico
}
