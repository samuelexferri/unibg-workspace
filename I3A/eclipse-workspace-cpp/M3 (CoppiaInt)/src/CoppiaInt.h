// Abstract Data Type (Record opaco)

#ifndef COPPIAINT_H_
#define COPPIAINT_H_

typedef struct coppiaInt *coppiaIntRef;

coppiaIntRef makeCoppiaInt(int a, int b);

coppiaIntRef sumCoppia(coppiaIntRef, coppiaIntRef);

char* toString(coppiaIntRef);

void delete(coppiaIntRef*); // Puntatore a un puntatore opaco

#endif /* COPPIAINT_H_ */
