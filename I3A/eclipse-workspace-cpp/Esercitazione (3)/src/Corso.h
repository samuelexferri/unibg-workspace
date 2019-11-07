#include "Studente.h"

#ifndef CORSO_H_
#define CORSO_H_

// Puntatore a una struct definita dopo in Corso.c
typedef struct Corso *corsoRef;

corsoRef makeCorso(char *n);

void addStudente(corsoRef c, studenteRef s); // Inserimento in testa alla lista

void printCorso(corsoRef c);

#endif /* CORSO_H_ */
