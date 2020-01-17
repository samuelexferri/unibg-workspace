// Record attivazione del foglio (C++)

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

int f(int *pi, int &ri) {
	if (*pi > ri)
		return ++ri;
	else {
		pi++;
		return f(pi, ri);
	}
}

int mainXXX() {
	int a[] = { 1, 2, 3, 4, 5, 6 };
	int b = 2;
	int *pa = a + 1;
	int &rb = b;
	cout << (&rb) << endl;
	cout << (&b) << endl;

	//int *rbb = &b;
	//cout << (&rbb) << endl;

	cout << f(pa, rb) << endl;
	cout << *pa << endl;
	cout << b << endl;
	return 0;
}
