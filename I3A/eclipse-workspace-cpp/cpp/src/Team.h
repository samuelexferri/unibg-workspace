/*
 * Team.h
 */

#ifndef TEAM_H_
#define TEAM_H_

#include <iostream>
#include <string>
#include <list>

#include "Ciclista.h"

class Team {
protected:
	std::list<Ciclista*> l; // STL: List

private:
	string nomesquadra;
	string origine;

public:
	// Costruttore
	Team(string ns, string o);

	// Metodi
	virtual ~Team(); // Distruttore
	string getNomeSquadra();
	void aggiungi(Ciclista *c);
	void stampa();
	float etaMedia();
	void stampaNaz(string naz);
};

#endif /* TEAM_H_ */
