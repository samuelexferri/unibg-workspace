#include <iostream>
#include <string>

#include "Passista.h"

const char* PCONST = "P";

Passista::Passista(string n, string c, string naz, float a, tipociclismo disc,
		int podi) :
		Ciclista(n, c, naz, a, disc) { // Estende il costruttore di Ciclista
	numeropodi = podi;
}

Passista::~Passista() {
	cout << "Delete Passista" << endl;
	free(this);
}

string Passista::toString() {
	return "[" + this->getIDString() + "] Passista " + nome + " " + cognome + " " + nazionalita + " " + this->getDisciplina() + " " + this->getPodi() + " podi";
}

string Passista::getIDString() {
	std::string s = stringify(thisid); // Uso il TemplateStringify per la conversione da int a string
	return PCONST + s;
}

string Passista::getPodi() {
	std::string s = stringify(numeropodi); // Uso il TemplateStringify per la conversione da int a string
	return s;
}

void Passista::addPodi(int np = 1) { // Default argument
	numeropodi += np;
}
