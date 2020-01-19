/*
 * UsoStatic.cpp
 *
 */

#include <iostream>
using namespace std;

void foo5() {
	static int x = 0; // Variabile static viene messa prima dello stack e inizializzata solo la prima volta, non ogni volta
	cout << x << endl;
	x += 5;
}

int main() {
	foo5();
	foo5();
	foo5();
}
