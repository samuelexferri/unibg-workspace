/*
 * VelocistaPassista.h
 */
#include <vector>
using namespace std;

#include "Passista.h"
#include "Velocista.h"
#include "Time.h"

#ifndef VELOCISTAPASSISTA_H_
#define VELOCISTAPASSISTA_H_

// Ereditarietà multipla (Diamante)
class VelocistaPassista: public Passista, public Velocista {
public:
	// Costruttore
	VelocistaPassista(string n, string c, string naz, float a,
			tipociclismo disc, int ms);

	// Metodi
	virtual ~VelocistaPassista(); // Distruttore
	string toString();
};

#endif /* VELOCISTAPASSISTA_H_ */
