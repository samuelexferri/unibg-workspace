/*
 * Velocista.h
 *
 */

using namespace std;
#include "Ciclista.h"
#include <vector>

#ifndef VELOCISTA_H_
#define VELOCISTA_H_

class Velocista: virtual public Ciclista { // Eredita pubblicamente da Ciclista
protected:
	// Inizializzazione di vector con elementi di classe Calciatore
	vector<pair<int, int>> gare; // TODO Time, Ho fatto vector usando anche pair
public:
	// Costruttore
	Velocista(string n, string c, string naz, float a, tipociclismo disc);

	// Metodi
	virtual ~Velocista(); // Distruttore
	string toString();
	void addGara(int km, int minuti);
	void printGare();
	void printUltimaGara();
};

#endif /* VELOCISTA_H_ */
