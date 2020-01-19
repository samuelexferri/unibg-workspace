#include <iostream>
using namespace std;

template<int nome_size> class Studente {
private:
	char nome[nome_size];
};

template<typename T> T massimo(T a, T b) {
	return a > b ? a : b;
}
;

int main3() {
	int y = massimo(3, 4);
	cout << y << endl;
	string s1 = "pippo";
	string s2 = "pluto";
	cout << massimo(s1, s2) << endl;

	return 0;
}
