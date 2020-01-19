#include "Cane.h"

#include <stdio.h>
#include <stdlib.h>

typedef struct Cane {
	char *nome;
} Cane;

caneref make(char *nome) {
	Cane *p = malloc(sizeof(Cane));
	p->nome = nome;
	return (caneref) p;
}

void abbaia(caneref c) {
	printf("%s, BAU\n", ((Cane*) c)->nome);
}

void delete(caneref c) {
	free((Cane*) c);
}

void creaeabbaia() {
	caneref fido = make("Fido");
	abbaia(fido);
	delete(fido);
}

int main(void) {
	creaeabbaia();
	creaeabbaia();
	return 0;
}
