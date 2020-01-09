#include <iostream>
#include <string>

#include "VelocistaPassista.h"

const char* VPCONST = "VP";

VelocistaPassista::VelocistaPassista(string n, string c, string naz, float a,
		tipociclismo disc, int podi) :
		Ciclista(n, c, naz, a, disc), Passista(n, c, naz, a, disc, podi), Velocista(
				n, c, naz, a, disc) {
}

VelocistaPassista::~VelocistaPassista() {
	cout << "Delete VelocitaPassista" << endl;
	free(this);
}

// Ho indicato il metodo getIDString di Ciclista per stampare l'identificativo
string VelocistaPassista::toString() {
	return "[" + this->Ciclista::getIDString() + "] VelocistaPassista " + nome
			+ " " + cognome + " " + nazionalita + " " + this->getDisciplina()
			+ " " + this->getPodi() + " podi";
}

string VelocistaPassista::getIDString() {
	std::string s = stringify(thisid); // Uso il TemplateStringify per la conversione da int a string
	return VPCONST + s;
}
