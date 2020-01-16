/*
 * CoppiaInt.h
 */

#ifndef COPPIAINT_H_
#define COPPIAINT_H_

typedef struct coppiaInt *coppiaIntRef;

coppiaIntRef makeCoppiaInt(int a, int b);

coppiaIntRef sumCoppia(coppiaIntRef, coppiaIntRef);

char* toString(coppiaIntRef);

// Puntatore a puntatore opaco
void delete(coppiaIntRef*);

#endif /* COPPIAINT_H_ */
