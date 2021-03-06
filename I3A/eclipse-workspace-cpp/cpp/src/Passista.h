/*
 * Passista.h
 */

#ifndef PASSISTA_H_
#define PASSISTA_H_

using namespace std;

#include "Ciclista.h"

extern const char* PCONST;

class Passista: virtual public Ciclista { // Eredita pubblicamente da Ciclista (Inizialization List, Virtual)
protected:
	int numeropodi;

public:
	// Costruttore
	Passista(string n, string c, string naz, float a, tipociclismo disc, int podi);

	// Metodi
	virtual ~Passista(); // Distruttore
	string toString(); // Metodo virtual ridefinito (Overriding)
	string getIDString(); // Metodo non virtual ridefinito
	string getPodi();
	void addPodi(int np);
};

#endif /* PASSISTA_H_ */
