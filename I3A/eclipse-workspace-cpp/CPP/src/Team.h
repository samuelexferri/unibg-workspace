/*
 * Team.h
 *
 */

#include <iostream>
#include <string>
#include <vector>

#include "Ciclista.h"

#ifndef TEAM_H_
#define TEAM_H_

class Team {
protected:
	// Inizializzazione di vector con elementi della classe Ciclista
	std::vector<Ciclista*> l;
private:
	string nomesquadra;
	string origine;
public:
	// Costruttore
	Team(string ns, string o);
	virtual ~Team(); // Distruttore
	void aggiungi(Ciclista *p);
	void stampa();
	float etaMedia();
	void stampaNaz(string naz);
	void piuPresenze();
};

#endif /* TEAM_H_ */
