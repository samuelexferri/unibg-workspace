#include <iostream>
using namespace std;

class Base {
public:
	Base(int x) {
		cout << "Costruisco Base " << x << endl;
	}
	virtual ~Base() {
		cout << "Distruggo Base " << endl;
	}
	void m() {
		cout << "Metodo m" << endl;
	}
};

class DerivataPub: public Base {
public:
	DerivataPub() :
			Base(4) {
		cout << "Costruisco DerivataPub" << endl;
	}
	~DerivataPub() {
		cout << "Distruggo DerivataPub " << endl;
	}
};

class DerivataPri: private Base {
public:
	DerivataPri() :
			Base(4) {
		cout << "Costruisco DerivataPri" << endl;
	}
	Base::m;
};

int mainnn() {
	Base *pdpu = new DerivataPub;
	pdpu->m();

	// Non DerivataPri non è sottotipo di Base
	// Base *pdpr = new DerivataPri;
	// pdpr.m();

	return 0;
}
