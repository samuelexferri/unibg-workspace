#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "ListaInt.h"

struct ListInt {
	int *data;
	int freePos; // Indica la prima posizione libera in data
};

ListIntRef mkList(int N) {
	ListIntRef li = malloc(sizeof(struct ListInt));
	li->data = malloc(sizeof(int) * N); // Sar� da deallocare anch'essa
	li->freePos = 0;
	return li;
}

void aggiungi(ListIntRef li, int i) {
	*(li->data + (li->freePos)) = i;
	(li->freePos)++;
}

char* toString(ListIntRef li) {
	if (li->freePos == 0) {
		return "Vuoto";
	}

	char *buffer = malloc(sizeof(char) * 10000);

	strcpy(buffer, ""); // Inizializzo il buffer come vuoto in modo da concatenare successivamente

	for (int i = 0; i < li->freePos; i++) {
		char buffertemp[1000];
		sprintf(buffertemp, "%d ", *(li->data + i));
		strcat(buffer, buffertemp);
	}

	printf("Buffer (Function): [%s] \n", buffer);

	return buffer;
}

void freeList(ListIntRef *l) {
	free((*l)->data); // Libero anche il puntatore a data dato che nel costruttore avevo usato malloc
	free(*l);
	*l = NULL;
}
