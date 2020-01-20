#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	char nome[20];
} Persona;

Persona* danglingStack() {
	Persona p;
	strcpy(p.nome, "Lorenzo");
	return &p;
}

Persona* danglingHeap() {
	Persona *p = malloc(sizeof(Persona));
	strcpy(p->nome, "Lorenzo");
	free(p);
	return p;
}

int main(void) {

	Persona *stack = danglingStack();
	Persona *heap = danglingHeap();

	printf("S%s\n", stack->nome);
	printf("H%s\n", heap->nome);

	if (stack == NULL)
		printf("NULL STACK POINTER\n");
	if (heap == NULL)
		printf("NULL HEAP  POINTER\n");

	printf("%p\n", stack);
	printf("%p\n", heap);

	return 0;
}
