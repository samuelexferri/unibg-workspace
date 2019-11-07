#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

	int res = sommaPari_R(a + 1, n - 1);
	return res + (*a % 2 == 0) ? 1 : 0;
}

// Esercizio (3)
int palindroma(char dritta[], int n) {
	char inversa[n];

	for (int i = 0; i < n; i++) {
		inversa[i] = dritta[n - 1 - i];
	}

	inversa[n] = '\0';

	printf("%s - %s \n", dritta, inversa);

	if (strcmp(dritta, inversa))
		return 0;
	else
		return 1;
}

// Esercizio (4)
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

int main(void) {
	// Esercizio (1)
	printf("Esercizio (1) \n");
	char a[] = "anna";
	printf("Hash: %d \n", hash_I(a));
	printf("Hash: %d \n", hash_R_CALL(a));
	printf("Hash: %d \n", hash_TailRecursion_CALL(a));

	// Esercizio (2)
	printf("Esercizio (2) \n");
	int p[] = { 10, 5, 7 };
	printf("%d \n", sommaPari_I(p, sizeof(p) / sizeof(int)));
	printf("%d \n", sommaPari_R(p, sizeof(p) / sizeof(int)));

	// Esercizio (3)
	printf("Esercizio (3) \n");
	char stringa_1[] = "anna";
	char stringa_2[] = "nada";
	printf("%d \n", palindroma(stringa_1, strlen(stringa_1)));
	printf("%d \n", palindroma(stringa_2, strlen(stringa_2)));

	// Esercizio (4)
	printf("Esercizio (4) \n");
	int n_1 = 8008;
	int n_2 = 777;
	printf("Variabile n_1: %d \n", divisibile_8(n_1));
	printf("Variabile n_2: %d \n", divisibile_8(n_2));

	return EXIT_SUCCESS;
}
