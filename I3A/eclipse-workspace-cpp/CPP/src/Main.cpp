/*
 * Demo.cpp
 *
 *  Created on: 15 gen 2018
 *      Author: jacopoghisalberti
 */

#include <iostream>

#include "Ciclista.h"
#include "Passista.h"
#include "Velocista.h"
#include "Team.h"

int main() {

	// Velocista
	cout << "VELOCISTI" << endl;
	Velocista *v1 = new Velocista("Marco", "Marchetti", "Italia", 24, pista);
	Velocista *v2 = new Velocista("Juan", "Fran", "Francia", 22, pista);
	Velocista *v3 = new Velocista("Lino", "Linetti", "Italia", 35, cross);
	cout << v1->toString() << endl;
	v1->addGara(32,45);
	v1->addGara(85,156);
	v1->printGare();
	v1->printUltimaGara();

	// Passista
	cout << "\nPASSISTI" << endl;
	Passista *p1 = new Passista("Gino", "Ginetti", "Italia", 32, strada, 8);
	Passista *p2 = new Passista("Pino", "Pinetti", "Italia", 19, pista, 0);
	Passista *p3 = new Passista("Luke", "Luket", "USA", 21, strada, 3);
	p1->addPodio();
	cout << p1->toString() << endl;

	// Team
	cout << "\nTEAM" << endl;
	Team *t1 = new Team("Piotta", "Italia");
	t1->aggiungi(v1);
	t1->aggiungi(v3);
	t1->aggiungi(p3);

	cout << "Età media: " << t1->etaMedia() << endl;
	// t1->piuPresenze();
	t1->stampa();
	t1->stampaNaz("Italia");
}
