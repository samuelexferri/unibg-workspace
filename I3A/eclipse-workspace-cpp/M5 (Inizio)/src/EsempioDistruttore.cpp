#include <iostream>

class A {
	int *ptr;

public:
	A() {
		std::cout << "A creato" << std::endl;
		ptr = new int[50];
	}
	~A() { // Distruttore con tilde
		std::cout << "A distrutto" << std::endl;
		delete[] ptr;
	}
};

void foo() {
	A a;
	std::cout << " fine foo" << std::endl;
}

int main2() {
	foo();
	int i = 9;
	int *pi = &i;
	// Sbagliato: non fare il delete di puntatore sullo stack
	delete pi;
	pi = NULL; // Da dangling a NULL
	*pi = 90;
	std::cout << " fine main" << std::endl;
}
