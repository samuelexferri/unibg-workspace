#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Esercizio (1)
void foo(int *a) {
	*(a + 1) = 20;
}

// Esercizio (2)
void strcpyfunction(char s[]) {
	strcpy(s, "lunghissima");
}

// Esercizio (3-4)
typedef struct Student {
	char nome[50];
	char cognome[50];
	int matricola;
} Student;

void print(Student *s) {
	printf("%s %s %d \n", s->nome, (*s).cognome, s->matricola);
}

// Variabile statica
static int NUMERO_STUDENTI = 1;

Student* makeStudent1(char *n, char *c) {
	Student alunno; // Non funziona (Dandling sullo stack)
	strcpy(alunno.nome, n);
	strcpy(alunno.cognome, c);
	alunno.matricola = NUMERO_STUDENTI++;
	return &alunno;
}

// Esercizio (4)
Student* makeStudent2(char *n, char *c) {
	Student *alunno = malloc(sizeof(struct Student));
	strcpy(alunno->nome, n);
	strcpy(alunno->cognome, c);
	alunno->matricola = NUMERO_STUDENTI++;
	return &alunno;
}

void main(void) {
	// Esercizio (1)
	printf("Esercizio (1) \n");
	int x = 0, y = 10;
	printf("%d %d \n", x, y); // 0 10
	foo(&y);
	printf("%d %d \n", x, y); // 20 10

	printf("X = %x, Y = %x \n", &x, &y); // Indirizzi (%x)

	// Esercizio (2)
	printf("Esercizio (2) \n");
	char s2[8] = "seconda";
	char s1[6] = "prima";
	strcpyfunction(s1);
	printf("%s %s \n", s1, s2);

	// Esercizio (3)
	printf("Esercizio (3) \n");
	char n[] = "Gino";
	char c[] = "Pino";
	Student *pstud1 = makeStudent2("Gino", "Pino");
	print(&pstud1);
	pstud1 = makeStudent1("Giorgio", "Marchetti");
	print(&pstud1);

	// Esercizio (4)
	printf("Esercizio (4) \n");
	Student *pstud2 = makeStudent2("Gino", "Pino");
	print(&pstud2);
	pstud2 = makeStudent2("Giorgio", "Marchetti");
	print(&pstud2);
}
