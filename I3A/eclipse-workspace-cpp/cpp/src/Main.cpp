/*
 * Main.cpp
 */

#include <iostream>

#include "Ciclista.h"
#include "Passista.h"
#include "Velocista.h"
#include "VelocistaPassista.h"
#include "Team.h"
#include "Time.h"

int main() {
	// Velocista
	cout << "VELOCISTI" << endl;
	Velocista *v1 = new Velocista("Marco", "Marchetti", "Italia", 24, pista);
	Velocista *v2 = new Velocista("Juan", "Fran", "Francia", 22, pista);
	Velocista *v3 = new Velocista("Lino", "Linetti", "Italia", 35, cross);

	cout << v1->toString() << endl;
	cout << v2->toString() << endl;
	cout << v3->toString() << endl;

	v1->addGara(32, Time(1, 15, 12));
	v1->addGara(85, Time(2, 46, 52));

	v1->printGare();
	v1->printUltimaGara();

	//delete(v2);

	// Passista
	cout << "\nPASSISTI" << endl;
	Passista *p1 = new Passista("Gino", "Ginetti", "Italia", 32, strada, 8);
	Passista *p2 = new Passista("Pino", "Pinetti", "Italia", 19, pista, 0);
	Passista *p3 = new Passista("Luke", "Luket", "USA", 21, strada, 3);

	cout << p1->toString() << endl;
	cout << p2->toString() << endl;
	cout << p3->toString() << endl;

	int np1 = 1;
	p3->addPodi(np1);
	cout << p3->toString() << endl;

	// Team
	cout << "\nTEAM PIOTTA" << endl;
	Team *t1 = new Team("Piotta", "Italia");
	t1->aggiungi(v1);
	t1->aggiungi(v3);
	t1->aggiungi(p3);

	cout << "Età media: " << t1->etaMedia() << endl;
	// t1->piuPresenze();
	t1->stampa();
	t1->stampaNaz("Italia");

	cout << "\nTEAM SPEEDY" << endl;
	Team *t2 = new Team("Speedy", "USA");
	t2->aggiungi(v2);
	t2->aggiungi(p1);
	t2->aggiungi(p2);

	cout << "Età media: " << t2->etaMedia() << endl;
	// t2->piuPresenze();
	t2->stampa();
	t2->stampaNaz("Francia");

	// VelocistaPassista
	cout << "\nVELOCISTI-PASSISTI" << endl;
	VelocistaPassista *vp1 = new VelocistaPassista("Pluto", "Tutto", "Italia",
			82, cross, 9);

	cout << vp1->toString() << endl;

	// Metodo lato Passista
	int np2 = 1;
	vp1->addPodi(np2);
	cout << vp1->toString() << endl;

	// Metodi lato Velocista
	vp1->addGara(44, Time(1, 45, 37));
	vp1->addGara(12, Time(0, 12, 58));

	vp1->printGare();

	cout << "\nDELETE" << endl;
	delete v1;
	delete t1;
}
