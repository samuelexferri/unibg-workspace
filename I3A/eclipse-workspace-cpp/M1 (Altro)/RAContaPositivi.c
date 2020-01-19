#include <stdio.h>

/*
 * Scrivi una funzione contaPositivi in C che dato in ingresso un array di interi restituisce il numero di
 * array positivi (>0) in esso.
 * Al solito, scrivi tre versioni: una non ricorsiva, una ricorsiva senza tail recursion e una ricorsiva con
 * tail recursion.
 * Specifica esattamente i parametri che passi alla procedura, il tipo di passaggio utilizzato e il loro
 * significato. Definisci funzioni ausiliarie di aiuto se necessario, per tenere la segnatura della funzione
 * contaPositivi più semplice.
 * Scrivi anche un main di esempio in cui chiami la funzione con l'array {1,-1} invocala in modo
 * assegni il risultato ad una variabile locale al main POS. Non usare alcuna variabile globale.
 * Disegna il record di attivazione per tutte e tre le versioni fino alla massima estensione del record di
 * attivazione. Nel caso di tail recursion, spiega nel codice quali ottimizzazioni hai adottato o potresti
 * adottare.
 */

int contaPositivi(int arr[], int length) {
	int pos = 0;
	for (int i = 0; i < length; i = i + 1) {
		if (arr[i] > 0)
			pos = pos + 1;
	}
	return pos;
}

int contaPositiviRic(int arr[], int end) {
	if (end < 0)
		return 0;
	int p = arr[end] > 0;
	return p + contaPositiviRic(arr, end - 1);
}

int contaPositiviTail(int arr[], int end, int sum) {
	if (end < 0)
		return sum;
	int p = arr[end] > 0;
	return contaPositiviTail(arr, end - 1, sum + p);
}

int contaPositiviTailInit(int arr[], int end) {
	return contaPositiviTail(arr, end, 0);
}

int mainXXX(int argc, char *argv[]) {
	int arr[10] = { 1, 2, -3 };
	printf("%d\n", contaPositivi(arr, 3));
	printf("%d\n", contaPositiviRic(arr, 2));
	printf("%d\n", contaPositiviTailInit(arr, 2));
	return 0;
}
