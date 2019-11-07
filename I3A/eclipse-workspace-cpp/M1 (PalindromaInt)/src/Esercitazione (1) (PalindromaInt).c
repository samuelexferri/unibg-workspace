/*
 Scrivi una funzione palindromaInt che dato in ingresso
 un array di numeri interi restituisce (usa stdbool.h)
 se è palindromo (cioè se si legge dalla
 prima all'ultima posizione o viceversa, si ha sempre la stessa sequenza di numeri).
 Scrivi tre versioni:
 una ITERATIVA,
 una ricorsiva SENZA TAIL
 una ricorsiva con TAIL recursion.

 Scrivi anche un main di esempio in cui chiami la
 funzione con un paio di array a tua scelta.
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Versione iterativa
bool palindromaInt_i(int a[], int n) {
	for (int i = 0; i < n / 2; i++) {
		if (a[i] != a[n - i - 1])
			return false;
	}
	return true;
}

// Versione ricorsiva, no tail recursion
bool palindromaInt_r(int a[], int n) {
	if (n <= 1)
		return true;
	// Palindromo se testa = coda e l'array tolta la testa e la coda è ancora palindromo
	return a[0] == a[n - 1] && palindromaInt_r(a + 1, n - 2);
}

// Versione ricorsiva con tail recursion
// i: Elemento da considerare
bool palindromaInt_trh(int a[], int n, int i) {
	if (i > n / 2)
		return true;

	if (a[i] != a[n - i - 1])
		return false;
	else
		return palindromaInt_trh(a, n, i + 1);
}

bool palindromaInt_tr(int a[], int n) {
	return palindromaInt_trh(a, n, 0);

}

int main(void) {
	int p1[] = { 1, 2, 3, 2, 1 };

	printf("%d ", palindromaInt_i(p1, 5));
	printf("%d ", palindromaInt_r(p1, 5));
	printf("%d\n", palindromaInt_tr(p1, 5))
	;

	int p2[] = { 1, 2, 3, 4, 1 };

	printf("%d ", palindromaInt_i(p2, 5));
	printf("%d ", palindromaInt_r(p2, 5));
	printf("%d\n", palindromaInt_tr(p2, 5));

	return EXIT_SUCCESS;
}
