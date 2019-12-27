/*
 * Passista.h
 *
 */

using namespace std;
#include "Ciclista.h"
#include <vector>

#ifndef PASSISTA_H_
#define PASSISTA_H_

class Passista: virtual public Ciclista { // Eredita pubblicamente da Ciclista
protected:
	int numeropodi;
public:
	// Costruttore
	Passista(string n, string c, string naz, float a, tipociclismo disc, int ms);

	// Metodi
	virtual ~Passista(); // Distruttore
	string toString();
	string getPodi();
	void addPodio();
};

#endif /* PASSISTA_H_ */
