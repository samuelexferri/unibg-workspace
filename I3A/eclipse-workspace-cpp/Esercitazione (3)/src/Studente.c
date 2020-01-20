#include "Studente.h"

#include <stdio.h>
#include <stdlib.h>

static int numeroprogressivo = 100; // Numero progressivo statico per le matricole

struct Studente {
	char nome[30];
	char cognome[30];
	int matricola;
	int voti[20];
	int votiindexlibero;
};

studenteRef makeStudent(char *n, char *c) {
	studenteRef sref = malloc(sizeof(struct Studente)); // L'intera struct nell'heap

	// Usare strcpy
	strcpy(sref->nome, n);
	strcpy(sref->cognome, c);
	// NO: sref->nome = n;
	// NO: sref->cognome = c;

	sref->matricola = numeroprogressivo;
	numeroprogressivo++;

	for (int i = 0; i < 20; i++)
		sref->voti[i] = 0;

	sref->votiindexlibero = 0;

	return sref;
}

void printStudente(studenteRef s) {
	printf("%s %s %d \n", s->nome, s->cognome, s->matricola);
}

char* studentData(studenteRef s) {
	char *buffer = malloc(sizeof(char) * 100); // NB: Se avessi usato buffer[] significava che lo stavo allocando sullo stack!
	sprintf(buffer, "%s %s %d", s->nome, s->cognome, s->matricola);
	return buffer;
}

void deleteStudente(studenteRef *s) {
	// Questi usati solo se nella struct li avevamo definiti come malloc:
	// free((*s)->nome);
	// free((*s)->cognome);
	// free((*s)->matricola);

	free((*s)); // Free dell'intera struct (comprende i campi)
	*s = NULL; // Liberiamo il puntatore al puntatore alla struct (NULL in maiuscolo!)
}

void addVoto(studenteRef s, int x) {
	s->voti[s->votiindexlibero] = x;
	s->votiindexlibero++;
}

void stampaMedia(studenteRef s) {
	int somma = 0;

	for (int i = 0; i < s->votiindexlibero; i++) {
		somma += s->voti[i];
	}

	int media = somma / (s->votiindexlibero + 1);

	printf("Media: %d \n", media);
}
