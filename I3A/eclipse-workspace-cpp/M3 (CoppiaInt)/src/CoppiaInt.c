#include <stdlib.h>

#include "CoppiaInt.h"

struct coppiaInt {
	//int n1, n2; // Prima soluzione consigliata
	int *data; // Soluzione di un buffer di due int
};

coppiaIntRef makeCoppiaInt(int a, int b) {
	// Costruisco la struct
	coppiaIntRef nc = malloc(sizeof(struct coppiaInt));
	// Costruisco i data
	nc->data = malloc(sizeof(int) * 2);
	// Setto i valori
	nc->data[0] = a;
	nc->data[1] = b;
	return nc;
}

coppiaIntRef sumCoppia(coppiaIntRef c1, coppiaIntRef c2) {
	return makeCoppiaInt(c1->data[0] + c2->data[0], c1->data[1] + c2->data[1]);
}

char* toString(coppiaIntRef c) {
	// Buffer
	char *buffer = malloc(20 * sizeof(char));
	sprintf(buffer, "<%d, %d>", c->data[0], c->data[1]);
	return buffer;
}

void delete(coppiaIntRef *c) {
	free((*c)->data);
	free(*c);
	*c = NULL;
}
