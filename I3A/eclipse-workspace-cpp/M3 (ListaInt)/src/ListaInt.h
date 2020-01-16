// Abstract Data Type (Record opaco)

#ifndef LISTAINT_H_
#define LISTAINT_H_

typedef struct ListInt *ListIntRef;

ListIntRef mkList(int N);

void aggiungi(ListIntRef, int i);

char* toString(ListIntRef);

void freeList(ListIntRef*); // Puntatore a un puntatore opaco

#endif /* LISTAINT_H_ */
