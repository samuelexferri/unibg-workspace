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
};

void print(struct Student *s) {
	printf("%s %s %d \n", s->nome, (*s).cognome, s->matricola);
}

// Variabile statica
static int NUMERO_STUDENTI = 1;

struct Student* makeStudent1(char *n, char *c) {
	struct Student alunno; // Non funziona (Dandling sullo stack)
	strcpy(alunno.nome, n);
	strcpy(alunno.cognome, c);
	alunno.matricola = NUMERO_STUDENTI++;
	printf("MK1 - Mi chiamo %s \n", alunno.nome);
	return &alunno;
}

// Esercizio (4)
struct Student* makeStudent2(char *n, char *c) {
	struct Student *alunno = malloc(sizeof(struct Student));
	strcpy(alunno->nome, n);
	strcpy(alunno->cognome, c);
	alunno->matricola = NUMERO_STUDENTI++;
	printf("MK2 - Mi chiamo %s \n", alunno->nome);
	return alunno;
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
	printf("\nEsercizio (2) \n");
	char s2[8] = "seconda";
	char s1[6] = "prima";
	strcpyfunction(s1);
	printf("%s %s \n", s1, s2);

	// Esercizio (3)
	printf("\nEsercizio (3) \n");
	char *n = "Gino";
	char *c = "Pino";
	struct Student *pstud1 = makeStudent1(n, c);
	print(&pstud1);
	printf("MAIN - Mi chiamo %s \n", pstud1->nome);

	// Esercizio (4)
	printf("\nEsercizio (4) \n");
	struct Student *pstud2 = makeStudent2(n, c);
	print(&pstud2);
	printf("MAIN - Mi chiamo %s \n", pstud2->nome);
	free(pstud2); // Free
	printf("MAIN - Mi chiamo %s \n", pstud2->nome);
}
