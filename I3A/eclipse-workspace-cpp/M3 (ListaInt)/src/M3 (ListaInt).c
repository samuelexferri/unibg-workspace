#include <stdio.h>
#include <stdlib.h>

#include "ListaInt.h"

int main(void) {
	ListIntRef l1 = mkList(100);

	aggiungi(l1, 11);
	aggiungi(l1, 22);
	aggiungi(l1, 33);
	aggiungi(l1, 44);

	char *s = toString(l1);

	printf("Buffer (Main): [%s] \n", s);

	printf("%p \n", l1);
	freeList(&l1);
	printf("%p \n", l1);

	return EXIT_SUCCESS;
}
