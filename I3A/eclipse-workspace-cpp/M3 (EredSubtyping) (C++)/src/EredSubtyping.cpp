#include <iostream>
using namespace std;

class Lista {
public:
	void insert_tail(void) {
	}
	void insert_head(void) {
	}
	void remove_tail(void) {
	}
};

class Pila: private Lista {
public:
	void insert_tail(void) {
	}
	void remove_tail(void) {
	}
};

class Coda {
};

int main() {
	Lista l;
	l.insert_head();
	l.remove_tail();
	l.insert_tail();

	Pila p;
	//p.insert_head(); // Nascosta
	p.insert_tail();
	p.remove_tail();

	// Una Pila è figlia di Lista (Ereditarietà) ma non è sottotipo di Lista (Sottotipo),
	// infatti non implementa l'inserimento in testa
	// l = p;

	return 0;
}
