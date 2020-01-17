#include "BitVector.h"

#include <stdio.h>
#include <stdlib.h>

struct bitvector {
	int dim;
	int *contenuto;
};

bvref makeBitVector(int n) {
	bvref bv = malloc(sizeof(struct bitvector));
	bv->dim = n;
	bv->contenuto = malloc(n * sizeof(int));

	for (int i = 0; i < n; i++)
		*(bv->contenuto + i) = 0;

	return bv;
}

bvref add(bvref bv1, bvref bv2) {
	// TODO
}
bvref or(bvref bv1, bvref bv2) {
	// TODO
}
bvref not(bvref bv1) {
	// TODO
}

char* toString(bvref bv) {
	char *buffer = malloc((bv->dim + 1) * sizeof(char));

	for (int i = 0; i < bv->dim; i++) {
		buffer[i] = bv->contenuto[i];
	}

	buffer[bv->dim + 1] = '\0';

	return buffer;
}

void delete(bvref bv) {
	free(bv->contenuto);
	free(bv);
	bv = NULL;
}
