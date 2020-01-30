#include "Lega.h"
#include <iostream>
#include <strings.h>

using namespace std;
using namespace std::tr1;

Lega *Lega::instance = NULL;

Lega::Lega() :
		nome("") {
}

Lega::~Lega() {
	cout << nome << " è stata distrutta" << endl;
	teams.clear();
}

Lega* Lega::getInstance() {
	return instance ? instance : (instance = new Lega()); // Singleton
}

string const& Lega::getNome() const {
	return nome;
}

void Lega::setNome(string const &nome) {
	this->nome = nome;
}

void Lega::nuovoTeamIscritto(Team *t) {
	teams.push_back(t);
}

void Lega::stampa() {
	Team *t;
	list<Team*>::iterator x;

	cout << this->getNome() << " formata dai seguenti team: " << endl;

	for (x = teams.begin(); x != teams.end(); x++) {
		t = *x; // Estraggo il team
		cout << t->getNomeSquadra() << endl; // Stampo ogni team
	}
}
