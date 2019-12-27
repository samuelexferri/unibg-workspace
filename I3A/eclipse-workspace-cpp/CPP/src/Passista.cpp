#include <iostream>
#include <string>

#include "Ciclista.h"
#include "Passista.h"
#include "TemplateSSTR.cpp"

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
	return nome + " " + cognome + " " + nazionalita + " " + this->getDisciplina() + " " + this->getPodi() + " podi";
}

string Passista::getPodi() {
	std::string s = sstr(numeropodi); // Uso il template SSTR per la conversione da int a string
	return s;
}

void Passista::addPodio() {
	numeropodi++;
}
