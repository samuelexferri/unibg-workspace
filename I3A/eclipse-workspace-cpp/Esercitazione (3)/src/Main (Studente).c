#include "Corso.h"
#include "Studente.h"

#include <stdio.h>
#include <stdlib.h>

int main2(void) {
	// Studente 1
	char nome[30] = "Gino";
	char cognome[30] = "Pino";

	studenteRef s1 = makeStudent(nome, cognome);

	printStudente(s1);

	char stampa[100];
	strcpy(stampa, studentData(s1));
	printf("%s \n", stampa);

	addVoto(s1, 10);
	addVoto(s1, 8);
	addVoto(s1, 6);

	stampaMedia(s1);

	// Studente 2
	char nome2[30] = "Marco";
	char cognome2[30] = "Marchetti";

	studenteRef s2 = makeStudent(nome2, cognome2);

	printStudente(s2);

	char nomecorso[30] = "Analisi";

	// Corso
	corsoRef c = makeCorso(nomecorso);

	addStudente(c, s1);
	addStudente(c, s2);

	printCorso(c);

	// Distruttore
	printf("%p \n", s1);
	deleteStudente(&s1);
	printf("%p \n", s1);

	return EXIT_SUCCESS;
}
