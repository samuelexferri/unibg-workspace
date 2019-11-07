#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Versione iterativa
char* vocalizza_i(char *s) {
	// Risultato allocato nello heap
	char *result = malloc((strlen(s) + 1) * sizeof(char));
	int j = 0; // Posizione corrente in result

	while (*s) {
		if (*s == 'a' || *s == 'e' || *s == 'i' || *s == 'o' || *s == 'u') {
			result[j++] = *s;
			result[j] = '\0'; // Terminatore corretto
			printf("Parziale: %s \n", result);
		}
		s++;
	}
	return result;
}

// Versione ricorsiva, no tail recursion
char* vocalizza_r(char *s) {
	if (*s == '\0') {
		// Restituisce una string vuota
		char *res = malloc(sizeof(char));
		*res = '\0';
		return res;
	} else {
		char *res = vocalizza_r(s + 1);
		if (*s == 'a' || *s == 'e' || *s == 'i' || *s == 'o' || *s == 'u') {
			// Aggiungi come prefisso *s
			char *stringafinale = malloc((strlen(res) + 2) * sizeof(char));
			// Metti il primo char
			sprintf(stringafinale, "%c", s[0]);
			// Concatena il risultato
			strcat(stringafinale, res);
			// Free di res che non serve più
			free(res);
			return stringafinale;
		} else {
			return res;
		}
	}
}

int main(void) {
	char nome[] = "giova";

	char *res = vocalizza_i(nome);
	printf("%s\n", res);
	printf("%s\n", vocalizza_r(nome));

	return EXIT_SUCCESS;
}
