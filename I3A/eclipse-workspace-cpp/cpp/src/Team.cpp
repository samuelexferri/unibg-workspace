#include <iostream>
#include <string>
#include <vector>
#include <list>
using namespace std;

#include "Team.h"

Team::Team(string ns, string o) {
	nomesquadra = ns;
	origine = o;
}

string Team::getNomeSquadra() {
	return nomesquadra;
}

void Team::aggiungi(Ciclista *c) {
	l.push_back(c); // Inserimento in coda
}

Team::~Team() {
	cout << "Delete Team" << endl;
	l.clear(); // Elimina tutti i giocatori dalla lista
	free(this);
}

float Team::etaMedia() {
	float eta = 0;
	Ciclista *c;
	list<Ciclista*>::iterator x; // Iteratore per scorrere il vettore

	for (x = l.begin(); x != l.end(); x++) {
		c = *x; // Estraggo il ciclista
		eta = eta + c->getEta(); // Estraggo l'età di ogni ciclista del team
	}

	float etamedia = eta / l.size(); // Calcolo l'età media del team
	return etamedia;
}

void Team::stampa() {
	Ciclista *c;
	list<Ciclista*>::iterator x;

	for (x = l.begin(); x != l.end(); x++) {
		c = *x; // Estraggo il ciclista
		cout << c->toString() << endl; // Stampo ogni ciclista del team
	}
}

void Team::stampaNaz(string naz) {
	Ciclista *c;
	list<Ciclista*>::iterator x;
	cout << "\nCiclisti del team " << this->getNomeSquadra() << " di origine " + naz + ": " << endl;

	for (x = l.begin(); x != l.end(); x++) {
		c = *x;
		if (c->getNazione() == naz) {
			cout << c->getNome() + " " + c->getCognome() << endl;
		} // Controllo della nazione e stampa del ciclista
	}
}
