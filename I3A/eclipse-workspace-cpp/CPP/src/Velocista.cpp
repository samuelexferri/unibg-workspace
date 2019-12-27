#include <iostream>
#include <string>
#include <vector>

#include "Ciclista.h"
#include "Velocista.h"

Velocista::Velocista(string n, string c, string naz, float a, tipociclismo disc) :
		Ciclista(n, c, naz, a, disc) { // Estende il costruttore di Ciclista
}

Velocista::~Velocista() {
	cout << "Delete Velocista" << endl;
	free(this);
}

string Velocista::toString() {
	return nome + " " + cognome + " " + nazionalita + " " + this->getDisciplina();
}

void Velocista::addGara(int km, int minuti) {
	gare.push_back(make_pair(km, minuti));
}

void Velocista::printGare() {
	pair<int, int> p;
	vector<pair<int,int>>::iterator x;
	for (x = gare.begin(); x != gare.end(); x++) {
		p = *x; //estraggo calciatore
		cout << p.first << " km in " << p.second << " minuti" << endl; // Stampa diretta
	}
}

void Velocista::printUltimaGara() {
	cout << gare.back().first << " km in " << gare.back().second << " minuti" << endl; // Stampa diretta
}
