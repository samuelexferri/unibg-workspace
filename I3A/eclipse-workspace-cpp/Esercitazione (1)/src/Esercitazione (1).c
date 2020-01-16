#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Esercizio (1)
int hash_I(char *s) {
	int hash = 0;

	for (int i = 0; s[i] != '\0'; i++)
		hash += s[i] * (i + 1);

	return hash;
}

int hash_R(char *s, int w) {
	if (*s == '\0')
		return 0;
	else
		return (*s) * w + hash_R(s + 1, w + 1);
}

int hash_R_CALL(char *s) {
	return hash_R(s, 1);
}

int hash_TailRecursion(char *s, int w, int h) {
	if (*s == '\0')
		return h;
	else
		return hash_TailRecursion(s + 1, w + 1, h + (*s) * w);
}

int hash_TailRecursion_CALL(char *s) {
	return hash_TailRecursion(s, 1, 0);
}

// Esercizio (2)
int sommaPari_I(int a[], int n) {
	int res = 0;

	for (int i = 0; i < n; i++) {
		if (a[i] % 2 == 0)
			res += a[i];
	}

	return res;
}

int sommaPari_R(int a[], int n) {
	if (n == 0)
		return 0;
	else
		return ((*a % 2 == 0) ? (*a) : 0) + sommaPari_R(++a, n - 1);
}

int sommaPari_TailRecursion(int a[], int n, int somma) {
	if (n == 0)
		return somma;

	if (*a % 2 == 0)
		return sommaPari_TailRecursion(a + 1, n - 1, somma + *a);
	else
		return sommaPari_TailRecursion(a + 1, n - 1, somma);
}

int sommaPari_TailRecursion_CALL(int a[], int n) {
	return sommaPari_TailRecursion(a, n, 0);
}

// Esercizio (3)
// SEE: M1 (PalindromaInt)

bool palindroma_I(char dritta[], int n) {
	char inversa[n];

	for (int i = 0; i < n; i++) {
		inversa[i] = dritta[n - 1 - i];
	}

	inversa[n] = '\0';

	printf("%s - %s \n", dritta, inversa);

	if (strcmp(dritta, inversa))
		return false;
	else
		return true;
}

// Esercizio (4)
// TODO
int divisibile_8(int n) {
	char nstr[12];

	sprintf(nstr, "%d", n);

	int cifre = strlen(nstr);

	if (cifre > 3) {
		char nstr_3[3];

		nstr_3[3] = '\0';
		nstr_3[2] = nstr[cifre - 1];
		nstr_3[1] = nstr[cifre - 2];
		nstr_3[0] = nstr[cifre - 3];

		return divisibile_8(atoi(nstr_3));
	} else {
		if ((atoi(nstr) % 8) == 0)
			return 1;
		else
			return 0;
	}
}

// Passaggio di parametri
void passPPInt(int **p) {
	**p = (**p) + 1;
}

void passPPString(char **p) {
	// TODO
}

void somma(int x, int y, int *z) {
	// In C non si può usare il passaggio per reference
	*z = x + y;
}

int main(void) {
	// Esercizio (1)
	printf("Esercizio (1) \n");
	char a[] = "anna";
	printf("Hash: %d \n", hash_I(a));
	printf("Hash: %d \n", hash_R_CALL(a));
	printf("Hash: %d \n", hash_TailRecursion_CALL(a));

	// Esercizio (2)
	printf("\nEsercizio (2) \n");
	int p[] = { 10, 5, 7, 4, 4 };
	printf("Size: %d \n", sizeof(p) / sizeof(int));
	printf("%d \n", sommaPari_I(p, sizeof(p) / sizeof(int)));
	printf("%d \n", sommaPari_R(p, sizeof(p) / sizeof(int)));
	printf("%d \n", sommaPari_TailRecursion_CALL(p, sizeof(p) / sizeof(int)));

	// Esercizio (3)
	// SEE: M1 (PalindromaInt)
	printf("\nEsercizio (3) \n");
	char stringa_1[] = "anna";
	char stringa_2[] = "nada";
	printf("%d \n", palindroma_I(stringa_1, strlen(stringa_1)));
	printf("%d \n", palindroma_I(stringa_2, strlen(stringa_2)));

	// Esercizio (4)
	// TODO
	printf("\nEsercizio (4) \n");
	int n_1 = 8008;
	int n_2 = 777;
	printf("Variabile n_1: %d \n", divisibile_8(n_1));
	printf("Variabile n_2: %d \n", divisibile_8(n_2));

	// Esercizio (5)
	// TODO

	// Passaggio di parametri
	printf("\nPassaggio di parametri \n");
	int val = 46;
	int *p1 = &val;
	printf("%d \n", *p1);
	passPPInt(&p1);
	printf("%d \n", *p1);

	char *s1 = "Viva";
	printf("%s \n", s1);
	passPPString(&s1);
	printf("%s \n", s1);

	int zeta;
	somma(3, 4, &zeta);
	printf("%d \n", zeta);

	return EXIT_SUCCESS;
}
