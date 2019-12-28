/*
 * Velocista.h
 */
#include <vector>
using namespace std;

#include "Ciclista.h"
#include "Time.h"

#ifndef VELOCISTA_H_
#define VELOCISTA_H_

class Velocista: virtual public Ciclista { // Eredita pubblicamente da Ciclista (Inizialization List, Virtual)
protected:
	// Inizializzazione di vector con elementi di classe Calciatore
	vector<pair<int, Time>> gare; // STL: Vector usando un pair di <int, Time>
public:
	// Costruttore
	Velocista(string n, string c, string naz, float a, tipociclismo disc);

	// Metodi
	virtual ~Velocista(); // Distruttore
	string toString(); // Metodo virtual ridefinito (Overriding)
	string getIDString(); // Metodo non virtual ridefinito
	void addGara(int km, Time tempo);
	void printGare();
	void printUltimaGara();
};

#endif /* VELOCISTA_H_ */
