#ifndef LISTAINT_H_
#define LISTAINT_H_

typedef struct ListInt *ListIntRef;

ListIntRef mkList(int N);

void aggiungi(ListIntRef, int i);

char* toString(ListIntRef);

void freeList(ListIntRef *); // Puntatore a puntatore opaco

#endif /* LISTAINT_H_ */
