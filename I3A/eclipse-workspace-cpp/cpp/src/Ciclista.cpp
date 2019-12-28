#include <iostream>
#include <string>

#include "Ciclista.h" // Includo l'header file

int Ciclista::id = 100; // Inizializzo l'identificativo (Variabile statica)

// Ridefinizione del costruttore
Ciclista::Ciclista(string n, string c, string naz, float a, tipociclismo disc) {
	nome = n;
	cognome = c;
	nazionalita = naz;
	eta = a;
	disciplina = disc;
	thisid = ++id; // Incremento l'identificatore univoco progressivo
}

// Ridefinizione dei metodi
// Distruttore (Virtual)
Ciclista::~Ciclista() {
	cout << "Delete Ciclista" << endl;
	free(this);
}

// Metodo toString (Virtual)
string Ciclista::toString() {
	return "[" + this->getIDString() + "] " + nome + " " + cognome + " "
			+ nazionalita + " " + this->getDisciplina();
}

string Ciclista::getIDString() {
	std::string s = stringify(thisid); // Uso il TemplateStringify per la conversione da int a string
	return s;
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
