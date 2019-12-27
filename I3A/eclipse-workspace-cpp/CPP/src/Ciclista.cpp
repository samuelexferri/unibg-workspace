#include <iostream>
#include <string>

#include "Ciclista.h" // Includo l'header file

// Ridefinizione del costruttore
Ciclista::Ciclista(string n, string c, string naz, float a, tipociclismo disc) {
	nome = n;
	cognome = c;
	nazionalita = naz;
	eta = a;
	disciplina = disc;
}

// Ridefinizione dei metodi
Ciclista::~Ciclista() {
	cout << "Delete Ciclista" << endl;
	free(this);
}

string Ciclista::getNome() {
	return nome;
}

string Ciclista::getCognome() {
	return cognome;
}

string Ciclista::getNazione() {
	return nazionalita;
}

float Ciclista::getEta() {
	return eta;
}

string Ciclista::getDisciplina() {
	if (disciplina == pista)
		return "pista";
	else if (disciplina == strada)
		return "strada";
	else
		return "cross";
}

string Ciclista::toString() {
	return nome + " " + cognome + " " + nazionalita + " " + this->getDisciplina();
}
