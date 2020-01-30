/*
 * Ciclista.h
 */

#ifndef CICLISTA_H_
#define CICLISTA_H_

using namespace std;

#include <string>
#include "TemplateStringify.h" // Template per la conversione di interi in stringhe

// Tipo numerativo
enum tipociclismo {
	pista, strada, cross
};

class Ciclista {
private:
	static int id; // Variabile statica

protected:
	int thisid;
	string nome;
	string cognome;
	string nazionalita;
	float eta;
	tipociclismo disciplina;

public:
	// Costruttore
	Ciclista(string n, string c, string naz, float a, tipociclismo disc);

	// Metodi
	virtual ~Ciclista(); // Distruttore (Virtual)
	virtual string toString(); // Stampa (Virtual)
	string getIDString();
	string getNome();
	string getCognome();
	string getNazione();
	string getDisciplina();
	float getEta();
};

#endif /* CICLISTA_H_ */
