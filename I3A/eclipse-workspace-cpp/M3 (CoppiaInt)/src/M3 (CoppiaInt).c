/*
 Tre tipi opachi in C
 Scrivi la definizione di un tipo di dato astratto CoppiaInt che rappresenta una coppia di interi Scrivi le seguenti funzioni:
 - makeCoppiaInt che prende in ingresso due interi e costruisce la coppia
 - sumCoppia che prende in ingresso due coppie e restituisce la coppia con la somma dei due numeri nelle due coppie passate in ordine
 - toString che restituisce una stringa classica char* contenente la coppia nel formato <n1,n2>
 - delete che distrugge la copia
 */

#include <stdio.h>
#include <stdlib.h>

#include "CoppiaInt.h"

int main(void) {
	coppiaIntRef c1 = makeCoppiaInt(3, 5);
	printf("%s\n", toString(c1));

	coppiaIntRef c2 = makeCoppiaInt(6, 2);
	coppiaIntRef somma = sumCoppia(c1, c2);
	printf("Somma: %s + %s = %s\n", toString(c1), toString(c2),
			toString(somma));

	delete(&c1);
	printf("%p", c1);

	return EXIT_SUCCESS;
}
