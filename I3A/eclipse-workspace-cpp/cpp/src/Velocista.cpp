#include <iostream>
#include <string>
#include <vector>

#include "Velocista.h"

const char* VCONST = "V";

Velocista::Velocista(string n, string c, string naz, float a, tipociclismo disc) :
		Ciclista(n, c, naz, a, disc) { // Estende il costruttore di Ciclista
}

Velocista::~Velocista() {
	cout << "Delete Velocista" << endl;
	free(this);
}

string Velocista::toString() {
	return "[" + this->getIDString() + "] Velocista " + nome + " " + cognome
			+ " " + nazionalita + " " + this->getDisciplina();
}

string Velocista::getIDString() {
	std::string s = stringify(thisid); // Uso il TemplateStringify per la conversione da int a string
	return VCONST + s;
}

void Velocista::addGara(int km, Time tempo) {
	gare.push_back(make_pair(km, tempo));
}

void Velocista::printGare() {
	cout << "\nGare di " << this->getNome() + " " + this->getCognome() << ":" << endl;

	pair<int, Time> p;
	vector<pair<int, Time>>::iterator x;

	for (x = gare.begin(); x != gare.end(); x++) {
		p = *x; // Estraggo
		cout << p.first << " km in " << p.second.getMilitary() << endl; // Stampa diretta
	}
}

void Velocista::printUltimaGara() {
	cout << "\nUltima gara di " << this->getNome() + " " + this->getCognome() << ": " << gare.back().first << " km in "
			<< gare.back().second.getMilitary() << endl; // Stampa diretta
}
