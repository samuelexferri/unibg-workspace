#include <iostream>
#include <string>
#include <vector>

using namespace std;

#include "Team.h"

Team::Team(string ns, string o) {
	nomesquadra = ns;
	origine = o;
}

void Team::aggiungi(Ciclista *c) {
	l.push_back(c); // Inserimento in coda
}

Team::~Team() {
	cout << "Delete Team" << endl;
	free(this);
}

float Team::etaMedia() {
	float eta = 0;
	Ciclista *c;
	vector<Ciclista*>::iterator x; // Iteratore per scorrere il vettore

	for (x = l.begin(); x != l.end(); x++) {
		c = *x;
		eta = eta + c->getEta(); // Estraggo l'età di ogni ciclista del team
	}

	float etamedia = eta / l.size(); // Calcolo l'età media del team
	return etamedia;
}

void Team::stampa() {
	Ciclista *c;
	vector<Ciclista*>::iterator x;

	for (x = l.begin(); x != l.end(); x++) {
		c = *x; // Estraggo il ciclista
		cout << c->toString() << endl; // Stampo ogni ciclista del team
	}
}

/*
 void Team::piuPresenze() {
 int npresenze = 0;
 string nome, cognome;
 Ciclista *c;
 vector<Ciclista*>::iterator x;
 for (x = l.begin(); x != l.end(); x++) {
 c = *x;
 //if (c->getPartitegiocate() > npresenze) {
 //npresenze = c->getPartitegiocate();
 nome = c->getNome();
 cognome = c->getCognome();
 //}
 }
 cout << "Ciclista con più presenze: " + nome + " " + cognome << endl;
 }
 */

void Team::stampaNaz(string naz) {
	Ciclista *c;
	vector<Ciclista*>::iterator x;
	cout << "\nCiclisti del team di origine " + naz + ": " << endl;

	for (x = l.begin(); x != l.end(); x++) {
		c = *x;
		if (c->getNazione() == naz) {
			cout << c->getNome() + " " + c->getCognome() << endl;
		} // Controllo della nazione e stampa
	}
}
