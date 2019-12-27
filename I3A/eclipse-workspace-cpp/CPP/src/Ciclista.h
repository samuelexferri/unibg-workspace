/*
 * Ciclista.h
 *
 */
#include <string>
using namespace std;

#ifndef CICLISTA_H_
#define CICLISTA_H_

enum tipociclismo {
	pista, strada, cross
};

class Ciclista {
private:
	float eta;

protected:
	string nome;
	string cognome;
	string nazionalita;
	tipociclismo disciplina;

public:
	// Costruttore
	Ciclista(string n, string c, string naz, float a, tipociclismo disc);

	// Metodi
	string getNome();
	string getCognome();
	string getNazione();
	string getDisciplina();
	float getEta();
	virtual ~Ciclista(); // Distruttore
	virtual string toString(); // Stampa
};

#endif /* CICLISTA_H_ */
