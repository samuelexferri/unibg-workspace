/*
 * VelocistaPassista.h
 */

using namespace std;

#include <vector>

#include "Passista.h"
#include "Velocista.h"
#include "Time.h"

#ifndef VELOCISTAPASSISTA_H_
#define VELOCISTAPASSISTA_H_

extern const char* VPCONST;

// Ereditarietà multipla (Diamante)
class VelocistaPassista: public Passista, public Velocista {
public:
	// Costruttore
	VelocistaPassista(string n, string c, string naz, float a,
			tipociclismo disc, int ms);

	// Metodi
	virtual ~VelocistaPassista(); // Distruttore
	string toString();
	string getIDString();
};

#endif /* VELOCISTAPASSISTA_H_ */
